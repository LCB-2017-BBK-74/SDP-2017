package actortree

/**
  * In this project we use Akka to build a distributed binary search tree where each node in the tree is an actor
  * This allows the tree to be a completely asynchronous, concurrent and distributed version of the traditional data structure
  * Actors are completely encapsulated, asynchronous entities that are each designed to perform a specific task
  * The only way that actors can communicate with each other (i.e. do tasks) is through message passing
  * When a message is sent to an actor, it is put in a queue and the actor performs the task corresponding to each message sequentially
  * Therefore actors themselves are single-threaded
  * See AlexMinnaar.com for examples
  */

import akka.actor._
import akka.routing.RoundRobinPool
import scala.collection.immutable.Queue

/**
  * We will create one main Actor called BinaryTreeSet which receives the Contains, Insert and Remove messages for the entire tree
  * Each node of the tree will also be an Actor, which we will call BinaryTreeNode
  * The BinaryTreeSet actor's state contains the root node of the tree. The root node is also a BinaryTreeNode Actor
  * Each BinaryTreeNode actor's state contains the value of the node (elem) as well as the reference to the subtrees/ children
  * The children are also BinaryTreeNode actors.
  */

/**
  * An actor class extends Akka's Actor trait and its messages are customarily defined in its companion object as case classes
  */

object BinaryTreeSet {

  trait Operation {
    def requester: ActorRef
    def id: Int
    def elem: Int
  }

  trait OperationReply {
    def id: Int
  }

  /** Request with identifier `id` to insert an element `elem` into the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Insert(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to check whether an element `elem` is present
    * in the tree. The actor at reference `requester` should be notified when
    * this operation is completed. The search can be done recursively by starting at the root and selecting the left or
    * right sub-tree and searching for the node's value. If we reach a leaf node and have not found it, the value is not there.
    */
  case class Contains(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to remove the element `elem` from the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Remove(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request to perform garbage collection*/
  case object GC

  /** Holds the answer to the Contains request with identifier `id`.
    * `result` is true if and only if the element is present in the tree.
    */
  case class ContainsResult(id: Int, result: Boolean) extends OperationReply

  /** Message to signal successful completion of an insert or remove operation.
    * OperationFinished message is sent back to the BinaryTreeSet actor when the operation specified by the id field is
    * finished
    */
  case class OperationFinished(id: Int) extends OperationReply

}

/**
  * BinaryTreeSet actor class.
  * The tree's root actor node root is created using the context.actorOf method
  * The Receive method accepts Operation messages and sends them to root
  */

class BinaryTreeSet extends Actor {
  import BinaryTreeSet._
  import BinaryTreeNode._

  def createRoot: ActorRef = context.actorOf(BinaryTreeNode.props(0, initiallyRemoved = true))

  var root = createRoot
  var pendingQueue = Queue.empty[Operation]
  def receive = normal

  /** Accepts `Operation` and `GC` messages. */
  val normal: Receive = {
    case operation: Operation => root ! operation

    /**
      * Accumulating nodes that have been removed can become problematic in terms of memory.
      * We will deal with this by introducing a GC message (GarbageCollector) that the main BinaryTreeSet actor can receive
      * When this message is received, all of the nodes in the tree that haven't been removed (i.e. where removed = false)
      * get copied into a new tree with a new root node. When the copy is completed all of the Actors in the old tree are stopped
      * There will also be a CopyTo message which holds the root node of the new tree as a field
      * This message is sent recursively to each node in the old tree and if its removed flag is false, it is inserted into the new tree
      * If messages come in while Garbage Collecting is taking place, we queue the messages and process them once garbage collection
      * is completed
      */
    case GC => {
      val newRoot = createRoot
      root ! CopyTo(newRoot)
      context.become(garbageCollecting(newRoot))
    }
  }

  // optional
  /** Handles messages while garbage collection is performed.
    * `newRoot` is the root of the new binary tree where we want to copy all non-removed elements into.
    * Once the GC message is received by the BinaryTreeSet actor, it enters into a new context where it waits for the new tree
    * to be copied and enqueing messages that are received during this time
    *
    * Once it receives the CopyFinished message, it executes all of the messages in the queue and returns to its normal context
    * For the BinaryTreeNode actors, the CopyTo message is handled in BinaryTreeNode.scala
    */
  def garbageCollecting(newRoot: ActorRef): Receive = {

    case operation: Operation => pendingQueue.enqueue(operation)

    case copyFinished => {
      root ! PoisonPill
      val newRoot = createRoot
      root = newRoot

      pendingQueue.map(root ! _)
      pendingQueue = Queue.empty

      context.become(normal)

    }
  }

}
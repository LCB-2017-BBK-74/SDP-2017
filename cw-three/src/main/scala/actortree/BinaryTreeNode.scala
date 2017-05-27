package actortree

import akka.actor.{Actor, ActorRef, Props}
import BinaryTreeNode._
import BinaryTreeSet._

/**
  * Created by lucieburgess on 26/05/2017.
  */
/**
  * Companion object to the BinaryTreeNode class
  */
object BinaryTreeNode {
  trait Position

  case object Left extends Position
  case object Right extends Position

  case class CopyTo(treeNode: ActorRef)
  case object CopyFinished

  def props(elem: Int, initiallyRemoved: Boolean) = Props(classOf[BinaryTreeNode],  elem, initiallyRemoved)

}

/**
  * class BinaryTreeNode
  * Where the subtrees Map holds the node's left and right children, which are themselves BinaryTreeNode Actors
  * @param elem value held by a node
  * @param initiallyRemoved refers to the garbage collection process
  */
class BinaryTreeNode(val elem: Int, initiallyRemoved: Boolean) extends Actor {

  var subtrees = Map[Position, ActorRef]()
  var removed = initiallyRemoved

  // optional
  def receive = normal

  //Helper function to determine whether to visit the left or right subchild
  def childToVisit(elemToFind: Int) :Position = {
    if (elemToFind>elem) Right
    else Left
  }


  /** Handles `Operation` messages and `CopyTo` requests. */
  val normal: Receive = {

    /**
      * case Contains: if the desired value is in the current node and hasn't been removed, then ContainsResult(id, true) message
      * is sent back to the requester
      * If the element doesn't exist in the tree a message Containsresult (id, false) is sent back to the requester
      * If the desired value is not in the current node but is in the subtrees, message is sent on further into the tree
      */
    case Contains(requester, id, elemToFind) => {
      if (elem != elemToFind || elem == elemToFind && removed) {
        val child = childToVisit(elemToFind)
        if (subtrees.contains(child)) {
          subtrees(child) ! Contains(requester, id, elemToFind)
        } else {
          requester ! ContainsResult(id, false)
        }
      } else {
        requester ! ContainsResult(id, true)
      }
    }

    /**
      * Insert messages can be handled in a similar way. We search the tree and when we get to a leaf node,
      * we create a new BinaryTreeNodeActor that holds the element to insert, and add this node to the leaf node's subtree Map.
      */
    case Insert (requester, id, elemToInsert) => {
      if (elem != elemToInsert || elem == elemToInsert && removed) {
        val child = childToVisit(elemToInsert)
        if (subtrees.contains(child)) {
          subtrees(child) ! Insert(requester, id, elemToInsert)
        } else {
          subtrees += (child -> context.actorOf(BinaryTreeNode.props(elemToInsert, false)))
          requester ! OperationFinished(id)
        }
      } else {
        requester ! OperationFinished(id)
      }
    }

    /**
      * Remove messages are more difficult to deal with as they result in tree restructuring
      * This is problematic in asynchronous applications - what if a removal occurs while other messages are being processed?
      * For this reason, we will handle removal by giving each node a removed flag that indicates if the node has been removed
      * Removal occurs by setting the removed flag to true
      */
    case Remove (requester, id, elemToRemove) => {
      if (elem != elemToRemove || elem == elemToRemove && removed) {
        val child = childToVisit(elemToRemove)
        if (subtrees.contains(child)) {
          subtrees(child) ! Remove(requester, id, elemToRemove)
        } else {
          requester ! OperationFinished(id)
        }
      } else {
        removed = true
        requester ! OperationFinished(id)
      }
    }

    case CopyTo(newRoot) => {
      if(!removed) {
        newRoot ! Insert(self, 0, elem)
      } //self holds the ActorRef for this Actor. Like 'this'

      subtrees.values foreach(_ ! CopyTo(newRoot))

      if (removed && subtrees.isEmpty) {
        sender ! CopyFinished
      } else {
        context.become(copying(subtrees.values.toSet, insertConfirmed = removed, sender))
      }
    }

  }

  // optional
  /** `expected` is the set of ActorRefs whose replies we are waiting for,
    * `insertConfirmed` tracks whether the copy of this node to the new tree has been confirmed.
    */
  def copying(expected: Set[ActorRef], insertConfirmed: Boolean, originator: ActorRef): Receive = {
    case OperationFinished(_) => {
      if (expected.isEmpty) {
        originator ! CopyFinished
        context.become(normal)
      } else {
        context.become(copying(expected, insertConfirmed = true, originator))
      }
    }
    case copyFinished => {
      val newExpected = expected - sender()
      if (newExpected.isEmpty && insertConfirmed) {
        originator ! CopyFinished
        context.become(normal)
      } else {
        context.become(copying(newExpected, insertConfirmed, originator))
      }
    }

  }

}

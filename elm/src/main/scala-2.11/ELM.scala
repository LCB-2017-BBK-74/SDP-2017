package dev.elm

import breeze.linalg.Matrix
import org.apache.spark.ml.linalg.DenseMatrix
import breeze.numerics._

/**
  * Created by lucieburgess on 26/08/2017.
  * ELM will take an input matrix and a bunch of parameters which can be changed, a column of labels and feature vectors
  * Get the basic version working first and then covert to the Spark version
  * Inspired by https://gist.github.com/jkdeveyra/1575440
  */
import scala.Array.canBuildFrom
import scala.collection.mutable.ListBuffer
import scala.math.random

import breeze.linalg.pinv
import breeze.linalg.{DenseMatrix => BDM}
import breeze.linalg.{DenseVector => BDV}
import breeze.linalg.{Matrix => BM}
import breeze.linalg.Vector
import breeze.linalg.NumericOps
import breeze.numerics._
import breeze.collection.mutable.ArrayMap
import breeze.linalg.functions._

// samples is just the training samples: each sample has a list of attributes(features) and a label (1 or 0)
class ELM(samples: Samples, hiddenNodes: Int, param: Param = new Param) {

  val X: BDM[Double] = samples.inputMatrix // each training sample of (attributes, label) out into an input matrix. X has N rows and (attributes + label) columns
  val N: Int = samples.size
  val L: Int = hiddenNodes
  val H: BDM[Double] = BDM.zeros[Double](N, L)
  //val w = inputWeight
  val T = samples.labelVector
  val m: Int = 2 //
  val beta: BDV[Double] = BDV.zeros[Double](L)

  // Step 1: Randomly assign input weight w and bias b
  private var bias: BDV[Double] = BDV((for (i <- 0 until L) yield random * 2 - 1 ): _*) // bias b is a Vector of scalars

  def w: BDM[Double] = BDM.rand(L, X.cols) // w is random Matrix of size (L,X.cols where the number of columns is the attributes + label)

  def train() {

    // Step 2: Calculate the hidden layer output matrix H
    // This step effectively transposes X
    for (i <- 0 until N)
      for (j <- 0 until L)
        H(i, j) = param.activationFunc(w(j, ::) * X(i, ::).t + bias(j)) // (w.x)transpose + b

    // Step 3: Calculate the output weight beta
    val beta: BDV[Double] = pinv(H) * T //
  }


  def test(sample: Sample): Long = {
    val Xin: Vector[Double] = sample.inputVector
    val node: IndexedSeq[Double] = for (i <- 0 until L) yield ((beta(i) * param.activationFunc(w(i, ::) * Xin) + bias(i)))
    node.sum.round
  }

  //def bias = b
}

object ELM {

  // defines the Sigmoid activation function
  // I will put activation functions in a separate class and define a trait for them
  def Sigmoid(x: Double): Double = 1 / (1 + math.pow(math.E, -x))

  // defines an operation transpose using a matrix which is simple Array[Array[Float]]
  // probably don't need this because Spark has transpose functions for DenseMatrix and RowMatrix
  def transpose(matrix: Array[Array[Float]]): Array[Array[Float]] =
  (for (i <- 0 until matrix(0).length) yield ((for (row <- matrix) yield row(i)).toArray)).toArray
}

class Param {
  var activationFunc: Double => Double = ELM.Sigmoid
}

class Sample(len: Int) {

  private var _attributes = new Array[Double](len) // empty Double Array of length(len)
  private var _label: Int = 0 //_label is 0

  def this(label: Label = Label(), attribs: List[Double]) = { // this takes a label and attribs, a List[Double]
    this(attribs.length) // gives attribs.length
    _attributes = attribs.toArray
    _label = label.i
  }

  def attributes = _attributes // inputMatrix features, i.e. attributes

  def label = _label // inputMatrix label i.e. label e.g. activityLabel

  def length = attributes.length

  def inputVector = Vector(_attributes: _*)
}

object Sample {

  def apply(attrib: Double*) = new Sample(Label(), attrib.toList)

  def apply(label: Label, attrib: Double*) = new Sample(label, attrib.toList)
}

case class Label(i: Int = 0)

class Samples(samples: List[Sample]) {

  private var _samples = new ListBuffer[Sample] // creates a new ListBuffer

  _samples ++= samples // adds samples to the ListBuffer

  def +=(sample: Sample) = _samples += sample // adds a sample to _samples

  def size: Int = _samples.size

  def labelVector = Vector((for (sample <- _samples) yield sample.label.toDouble): _*)

  // inputMatrix definition - don't need this because we already have an input matrix without needing to create one
  def inputMatrix: BDM[Double] = { // inputMatrix is of type DenseMatrix
  val m = BDM.zeros[Double](size, _samples(0).length) // m is a Matris of 0.0s(rows: Int, cols: (attributes + label))

    for (i <- 0 until size) // fills every row of m from i = 0 until i = _samples.size
      m(i, ::) := Vector(_samples(i).attributes: _*) // every row of m is filled with a Vector of attributes,

    m
  }
}
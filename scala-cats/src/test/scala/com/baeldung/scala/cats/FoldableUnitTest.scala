package com.baeldung.scala.cats

import org.scalatest.FlatSpec
import cats._
import cats.implicits._

class FoldableUnitTest extends FlatSpec {
  "A list" should "fold its values via foldLeft operation" in {
    val actualListOne = List(1, 2, 3).foldLeft(0)(_ + _)
    val expectedResultOne = 6

    assert(actualListOne == expectedResultOne)

    val actualListTwo = List(1, 2, 3).foldLeft(0)(_ - _)
    val expectedResultTwo = -6
    assert(actualListTwo == expectedResultTwo)
  }

  "A Foldable of List" should "fold the list values via foldLeft or foldRight operations" in {
    val actualListOne = Foldable[List].foldLeft(List(1, 2, 3), 0)(_ + _)
    val expectedResultOne = 6

    assert(actualListOne == expectedResultOne)

    val actualListTwo = Foldable[List].foldLeft(List("a", "b", "c"), "")(_ + _)
    val expectedResultTwo = "abc"

    assert(actualListTwo == expectedResultTwo)
  }
}

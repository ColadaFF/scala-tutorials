package com.baeldung.scala.cats

import org.scalatest.FlatSpec
import cats.implicits._

class TraverseUnitTest extends FlatSpec {
  "A List" should "return a None value when using traverse and one of its values is None" in {
    val listOne = List(Some(1), Some(2), None)

    val actualOne = listOne.traverse(identity)
    val expectedOne: Option[List[Int]] = None

    assert(actualOne == expectedOne)
  }

  "A List" should "return all the values whe using traverse and all of its values are Some" in {
    val listTwo: List[Option[Int]] = List(Some(1), Some(2), Some(3))

    val actualTwo = listTwo.traverse(identity)
    val expectedTwo: Option[List[Int]] = Some(List(1, 2, 3))

    assert(actualTwo == expectedTwo)
  }
}

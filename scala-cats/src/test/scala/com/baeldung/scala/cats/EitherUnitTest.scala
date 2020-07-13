package com.baeldung.scala.cats

import org.scalatest.FlatSpec

class EitherUnitTest extends FlatSpec {
  "An Either" should "Apply only map operation when the context is 'Right'" in {
    val eitherRight: Either[String, Int] = Right(3)

    val actualOne = eitherRight.map(_ * 4)
    val expectedOne = Right(12)

    assert(actualOne == expectedOne)

    val eitherLeft: Either[String, Int] = Left("BOOM error!")

    val actualTwo = eitherLeft.map(_ * 3)
    val expectedTwo: Either[String, Int] = Left("BOOM error!")

    assert(actualTwo == expectedTwo)
  }

  "A projected Either" should "apply map operation when selected projection is 'Right'" in {
    val eitherRight: Either[String, Int] = Right(1)

    val actualOne = eitherRight.right.map(_ + 42)
    val expectedOne = Right(43)

    assert(actualOne == expectedOne)

    val eitherLeft: Either[String, Int] = Left("BOOM error!")

    val actualTwo = eitherLeft.left.map(_ + " added to left")
    val expectedTwo: Either[String, Int] = Left("BOOM error! added to left")

    assert(actualTwo == expectedTwo)
  }
}

package com.baeldung.scala.cats

import cats.Apply
import org.scalatest.FlatSpec
import com.baeldung.scala.cats.ApplyExample._

class ApplyUnitTest extends FlatSpec {
  "Apply" should "Run operation across nested list of types" in {
    val listOpt = Apply[List] compose Apply[Option]
    val times3 = (x: Int) => x * 3

    val opList = List(Some(times3))
    val itemsList = List(Some(1), None, Some(3))
    val actual = listOpt.ap(opList)(itemsList)
    val expected = List(Some(3), None, Some(9))

    assert(actual == expected)
  }
}

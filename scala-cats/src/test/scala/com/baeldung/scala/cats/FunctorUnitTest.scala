package com.baeldung.scala.cats

import org.scalatest.FlatSpec
import cats.implicits._

import com.baeldung.scala.cats.Functors._

class FunctorUnitTest extends FlatSpec {
  "A Functor of Container" should "transform its internal value using map function" in {
    val container = Container(10, 20)
    val actual = container.map(value => value * 3)
    val expected = Container(30, 60)

    assert(actual == expected)
  }
}

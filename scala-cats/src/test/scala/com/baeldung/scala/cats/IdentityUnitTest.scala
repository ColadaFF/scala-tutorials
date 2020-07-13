package com.baeldung.scala.cats

import org.scalatest.FlatSpec
import cats.Id
import cats.implicits._

class IdentityUnitTest extends FlatSpec {
  "An Int Identity" should "support cats implicit operations" in {
    val one: Id[Int] = 1
    val actual = one.map(_ + 1)
    val expected: Int = 2

    assert(actual == expected)
  }
}

package com.baeldung.scala.cats

import com.baeldung.scala.cats.Monoids._
import org.scalatest.FlatSpec

class MonoidUnitTest extends FlatSpec {
  "Money List Monoid" should "combine the elements into a single object using combine all function" in {
    val moneyBag = List(Money(10, 40), Money(4, 95), Money(8, 99))

    assert(combineAll(moneyBag) == Money(24, 34))
  }
}

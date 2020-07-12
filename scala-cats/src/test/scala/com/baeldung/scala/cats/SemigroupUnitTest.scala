package com.baeldung.scala.cats

import cats.Semigroup
import com.baeldung.scala.cats.Semigroups._
import org.scalatest.FlatSpec

class SemigroupUnitTest extends FlatSpec {
  "Money Semigroup" should "add money using combine operation" in {
    val x = Money(10, 40)
    val y = Money(4, 95)

    assert(Semigroup[Money].combine(x, y) == Money(15, 35))
  }

  "Money Semigroup" should "apply the associativity law" in {
    val x = Money(10, 40)
    val y = Money(4, 95)
    val z = Money(8, 99)

    assert(
      Semigroup[Money]
        .combine(x, Semigroup[Money].combine(y, z)) == Money(24, 34)
    )

    assert(
      Semigroup[Money].combine(Semigroup[Money].combine(x, y), z) == Money(
        24,
        34
      )
    )

  }
}

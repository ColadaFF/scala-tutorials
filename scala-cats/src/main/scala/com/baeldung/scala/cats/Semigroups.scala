package com.baeldung.scala.cats

object Semigroups {

  object Introduction {
    trait Semigroup[A] {
      def combine(x: A, y: A): A
    }

    // associative law
    // combine(x, combine(y, z)) = combine(z, combine(x, y))
  }

  import cats._

  case class Money(dollars: Int, cents: Int)

  implicit val moneyAdditionSemigroup: Semigroup[Money] = new Semigroup[Money] {
    def combine(x: Money, y: Money): Money = {
      Money(x.dollars + y.dollars + ((x.cents + y.cents) / 100), (x.cents + y.cents) % 100)
    }
  }

}


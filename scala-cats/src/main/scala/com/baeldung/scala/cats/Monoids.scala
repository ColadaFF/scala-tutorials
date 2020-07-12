package com.baeldung.scala.cats

object Monoids {
  object Introduction {
    trait Monoid[A] {
      def combine(x: A, y: A): A
      def empty: A
    }

    object MonoidLaws {
      def associativeLaw[A](x: A, y: A, z: A)(
          implicit m: Monoid[A]
      ): Boolean = {
        m.combine(x, m.combine(y, z)) ==
          m.combine(m.combine(x, y), z)
      }

      def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean = {
        (m.combine(x, m.empty) == x) &&
        (m.combine(m.empty, x) == x)
      }
    }
  }

  object MonoidAsSemigroupExtension {
    import cats.Semigroup

    trait Monoid[A] extends Semigroup[A] {
      def empty: A
    }
  }

  import cats.Monoid

  case class Money(dollars: Int, cents: Int)

  implicit val moneyMonoid: Monoid[Money] = new Monoid[Money] {
    override def combine(x: Money, y: Money): Money =
      Money(
        x.dollars + y.dollars + ((x.cents + y.cents) / 100),
        (x.cents + y.cents) % 100
      )

    override def empty: Money = Money(0, 0)
  }


  def combineAll[A: Monoid](list: List[A]): A =
    list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
}

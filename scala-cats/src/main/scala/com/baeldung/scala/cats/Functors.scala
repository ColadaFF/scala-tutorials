package com.baeldung.scala.cats

object Functors {

  object Introduction {
    trait Functor[F[_]] {
      def map[A, B](fa: F[A])(f: A => B): F[B]
    }
  }

  import cats.Functor

  case class Container[A](x: A, y: A)

  implicit val functorForContainer: Functor[Container] =
    new Functor[Container] {
      def map[A, B](fa: Container[A])(f: A => B): Container[B] =
        Container(f(fa.x), f(fa.y))
    }

}

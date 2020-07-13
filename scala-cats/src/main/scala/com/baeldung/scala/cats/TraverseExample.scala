package com.baeldung.scala.cats

import cats.Applicative

object TraverseExample {

  trait Traverse[F[_]] {
    def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]
  }
}

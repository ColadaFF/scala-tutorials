package com.baeldung.scala.cats

object MonadExample {
  object Introduction {
    import cats.Applicative

    trait Monad[F[_]] extends Applicative[F] {
      def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

      def tailRecM[A, B](a: A)(f: A => F[Either[A, B]]): F[B]
    }
  }

  import cats._

  case class Wrapper[A](value: A)

  implicit val wrapperMonad: Monad[Wrapper] = new Monad[Wrapper] {
    def flatMap[A, B](fa: Wrapper[A])(f: A => Wrapper[B]): Wrapper[B] =
      f.apply(fa.value)

    def pure[A](a: A): Wrapper[A] = Wrapper(a)

    @scala.annotation.tailrec //marked as recursive method
    def tailRecM[A, B](a: A)(f: A => Wrapper[Either[A, B]]): Wrapper[B] =
      f(a) match {
        case Wrapper(either) =>
          either match {
            case Left(a)  => tailRecM(a)(f)
            case Right(b) => Wrapper(b)
          }
      }

  }
}

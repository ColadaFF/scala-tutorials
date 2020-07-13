package com.baeldung.scala.cats

object EitherExample {
  object Introduction {
    val querySomeServiceThatThrows: Int => String = ???

    val anotherQueryThatThrows: String => String = ???

    val magicOperation: Int => String =
      querySomeServiceThatThrows.andThen(anotherQueryThatThrows)

    val right: Either[String, Int] = Right(1)
  }

  object CatsExample {

  }
}

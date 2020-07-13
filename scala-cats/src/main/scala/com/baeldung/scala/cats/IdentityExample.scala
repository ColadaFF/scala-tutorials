package com.baeldung.scala.cats

object IdentityExample {
  object Introduction {
    type Id[A] = A
  }

  object CatsReference {
    import cats._

    val x: Id[Int] = 1
    val y: Int = x
  }


}

package com.baeldung.scala.cats

import org.scalatest.FlatSpec
import cats._
import cats.implicits._

class ApplicativeUnitTest extends FlatSpec {
  "An Applicative" should "wrap the value inside the context of the functor" in {

    val actualOption = Applicative[Option].pure(1)
    val expectedOption = Some(1)
    assert(actualOption == expectedOption)

    val actualApplicativeComposition =
      (Applicative[List] compose Applicative[Option]).pure(1)
    val expectedApplicativeComposition = List(Some(1))

    assert(actualApplicativeComposition == expectedApplicativeComposition)
  }
}

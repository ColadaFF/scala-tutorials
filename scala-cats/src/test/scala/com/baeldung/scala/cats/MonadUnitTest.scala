package com.baeldung.scala.cats

import cats.implicits._
import com.baeldung.scala.cats.MonadExample.Wrapper
import org.scalatest.FlatSpec

class MonadUnitTest extends FlatSpec {
  "A Monad" should "flatten a nested context returned on flatMap operation" in {
    val value = Wrapper("Hello world, ")
    val actual = value.flatMap(x => Wrapper(x.length))
    val expected = Wrapper(13)

    assert(actual == expected)
  }
}

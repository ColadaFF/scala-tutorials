package com.baeldung.scala.cats

import cats.data.Chain
import cats.data.Validated.{Invalid, Valid}
import com.baeldung.scala.cats.ValidatedExample.{
  PasswordTooShort,
  UserData,
  UsernameHasSpaces,
  ValidationFactory
}
import org.scalatest.FlatSpec

class ValidatedUnitTest extends FlatSpec {
  "Invalid user data" should "return a chain of invalid result" in {
    val actualInvalid = ValidationFactory.validateUserData(
      "oops s",
      "invalid"
    )
    val expectedInvalid =
      Invalid(Chain(UsernameHasSpaces, PasswordTooShort))

    assert(actualInvalid == expectedInvalid)
  }

  "Valid user data" should "return a valid result after validation" in {
    val actualValid = ValidationFactory.validateUserData(
      "validUsername",
      "validPassword"
    )
    val expectedValid = Valid(UserData("validUsername", "validPassword"))

    assert(actualValid == expectedValid)
  }
}

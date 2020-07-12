package com.baeldung.scala.cats

import org.scalatest.FlatSpec

class TypeClassesUnitTest extends FlatSpec {
  "A Password" should "be encrypted using implicit arguments on method" in {
    import com.baeldung.scala.cats.EncryptorInstances._
    val password = Password("abc123")
    assert(Encryption.toEncrypted(password) == "encrypted{abc123}")
  }

  "A Password" should "be encrypted using an implicit class extension" in {
    import com.baeldung.scala.cats.EncryptionSyntax._
    import com.baeldung.scala.cats.EncryptorInstances._
    val password = Password("abc123")
    assert(password.toEncrypted == "encrypted{abc123}")
  }

}

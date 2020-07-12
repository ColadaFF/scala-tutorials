package com.baeldung.scala.cats


// Interface to extend
trait Encryptor[A] {
  def encrypt(value: A): String
}


case class Password(value: String)

object EncryptorInstances {

  // Extension via implicit instance
  implicit val passwordEncryptor: Encryptor[Password] =
    new Encryptor[Password] {
      def encrypt(password: Password): String =
        s"encrypted{${password.value}}"
    }
}

object Encryption {
  // Export the extension using it as implicit argument on method
  def toEncrypted[A](value: A)(implicit e: Encryptor[A]): String =
    e.encrypt(value)
}

object EncryptionSyntax {
  // Export the extension using it as implicit class on any the interface instance
  implicit class EncryptorOps[A](value: A) {
    def toEncrypted(implicit e: Encryptor[A]): String =
      e.encrypt(value)
  }

}


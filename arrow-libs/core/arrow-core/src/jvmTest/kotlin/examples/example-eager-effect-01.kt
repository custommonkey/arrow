// This file was automatically generated from EagerEffect.kt by Knit tool. Do not edit.
package arrow.core.examples.exampleEagerEffect01

import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import arrow.core.Validated
import arrow.core.continuations.eagerEffect
import arrow.core.continuations.fold
import io.kotest.assertions.fail
import io.kotest.matchers.shouldBe

fun main() {
  eagerEffect<String, Int> {
    val x = Either.Right(1).bind()
    val y = Validated.Valid(2).bind()
    val z = Option(3).bind { "Option was empty" }
    x + y + z
  }.fold({ fail("Shift can never be the result") }, { it shouldBe 6 })

  eagerEffect<String, Int> {
    val x = Either.Right(1).bind()
    val y = Validated.Valid(2).bind()
    val z: Int = None.bind { "Option was empty" }
    x + y + z
  }.fold({ it shouldBe "Option was empty" }, { fail("Int can never be the result") })
}

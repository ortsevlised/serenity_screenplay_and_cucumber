package serenity.questions

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question

class CalculationResult(private val operation: String) :
    Question<Any> {
    override fun answeredBy(actor: Actor): Any {
        val actualResult =
            actor.recall<Any>(operation) ?: throw IllegalArgumentException("No result found for operation: $operation")
        return actualResult
    }
}

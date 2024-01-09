package serenity.Tasks

import serenity.Abilities.UseCalculator
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task

private const val ADDITION_OF_EVEN_NUMBERS_RESULT = "addition of even numbers"

class AddEvenNumbers(private val arr: IntArray) : Task {

    override fun <T : Actor> performAs(actor: T) {
        val calculator = actor.usingAbilityTo(UseCalculator::class.java)
        val result = calculator.sumOfEvens(arr)
        actor.remember(ADDITION_OF_EVEN_NUMBERS_RESULT, result)
    }

    companion object {
        fun fromIntArray(arr: IntArray): AddEvenNumbers = AddEvenNumbers(arr)
    }
}

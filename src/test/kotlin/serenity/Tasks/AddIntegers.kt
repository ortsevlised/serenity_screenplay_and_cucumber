package serenity.Tasks

import serenity.Abilities.UseCalculator
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task

private const val ADDITION_OF_INTEGERS_RESULT = "sum of 2 integers"

class Sum(private val x: Int, private val y: Int) : Task {

    override fun <T : Actor> performAs(actor: T) {
        val calculator = actor.usingAbilityTo(UseCalculator::class.java)
        val result = calculator.addIntegers(x, y)
        actor.remember(ADDITION_OF_INTEGERS_RESULT, result)
    }

    companion object {
        fun integers(x: Int, y: Int): Sum = Sum(x, y)
    }
}

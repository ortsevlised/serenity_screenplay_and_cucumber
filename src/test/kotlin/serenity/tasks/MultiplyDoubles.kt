package serenity.tasks

import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import serenity.abilities.UseCalculator

private const val ADDITION_RESULT = "multiplication of 2 doubles"

class Multiply(private val x: Double, private val y: Double) : Task {

    override fun <T : Actor> performAs(actor: T) {
        val calculator = actor.usingAbilityTo(UseCalculator::class.java)
        val result = calculator.multiplyDoubles(x, y)
        actor.remember(ADDITION_RESULT, result)
    }

    companion object {
        fun doubles(x: Double, y: Double): Multiply = Multiply(x, y)
    }
}

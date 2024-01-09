package serenity.abilities

import net.serenitybdd.screenplay.Ability

interface CalculatorAbilities : Ability {
    fun addIntegers(x: Int, y: Int): Int
    fun multiplyDoubles(x: Double, y: Double): Double
    fun sumOfEvens(arr: IntArray): Int
}

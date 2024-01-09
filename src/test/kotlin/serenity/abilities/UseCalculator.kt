package serenity.abilities

import SimpleCalc

class UseCalculator : CalculatorAbilities {
    override fun addIntegers(x: Int, y: Int): Int = SimpleCalc.add(x, y)
    override fun multiplyDoubles(x: Double, y: Double): Double = SimpleCalc.multiply(x, y)
    override fun sumOfEvens(arr: IntArray): Int = SimpleCalc.sumOffEvens(arr)

    companion object {
        fun useCalculator(): UseCalculator = UseCalculator()
    }
}




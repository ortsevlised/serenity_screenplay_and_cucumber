package serenity.Steps

import serenity.Tasks.AddEvenNumbers
import serenity.Tasks.Multiply
import serenity.Tasks.Sum
import serenity.Abilities.UseCalculator.Companion.useCalculator
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.actors.Cast
import net.serenitybdd.screenplay.actors.OnStage
import org.assertj.core.api.AssertionsForClassTypes.assertThat


class CalculatorSteps {
    @Given("{} is using the calculator")
    fun user_is_using_the_calculator(actorName: String) {
        OnStage.setTheStage(Cast.whereEveryoneCan(useCalculator()))
        OnStage.theActorCalled(actorName)
    }

    @When("he adds the values {int} and {int}")
    fun addTwoIntegers(x: Int, y: Int) {
        OnStage.theActorInTheSpotlight().attemptsTo(Sum.integers(x, y))
    }

    @When("he multiplies {} by {}")
    fun multiplyTwoDoubles(x: String, y: String) {
        OnStage.theActorInTheSpotlight().attemptsTo(Multiply.doubles(x.toDouble(), y.toDouble()))
    }

    @When("he adds the even numbers in {}")
    fun sumEvenNumbers(values: String) {
        var intArray = intArrayOf()
        if (values != "") {
            intArray = values.split(",")
                .map { it.trim().toInt() }
                .toIntArray()
        }
        OnStage.theActorInTheSpotlight().attemptsTo(AddEvenNumbers.fromIntArray(intArray))
    }

    @Then("he sees the result of the {} is a {} of value {}")
    fun heSeesTheResultIsResult(operation: String, type: String, expectedResult: String) {
        val result = OnStage.theActorInTheSpotlight().recall<Any>(operation)

        val convertedExpectedResult = when (type.lowercase()) {
            "int" -> expectedResult.toInt()
            "double" -> when (expectedResult) {
                "Double.POSITIVE_INFINITY" -> Double.POSITIVE_INFINITY
                "Double.NEGATIVE_INFINITY" -> Double.NEGATIVE_INFINITY
                else -> expectedResult.toDouble()
            }

            else -> throw IllegalArgumentException("Unknown type: $type")
        }

        assertThat(result).isEqualTo(convertedExpectedResult)
    }
}

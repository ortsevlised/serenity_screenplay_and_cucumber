package serenity.steps

import Log
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import net.serenitybdd.screenplay.actors.Cast
import net.serenitybdd.screenplay.actors.OnStage
import org.hamcrest.core.IsEqual.equalTo
import serenity.Utils.convertExpectedResult
import serenity.abilities.UseCalculator.Companion.useCalculator
import serenity.questions.CalculationResult
import serenity.tasks.AddEvenNumbers
import serenity.tasks.Multiply
import serenity.tasks.Sum


class CalculatorSteps {
    @Given("{word} is using the calculator to {}")
    fun user_is_using_the_calculator(actorName: String, action: String) {
        OnStage.setTheStage(Cast.whereEveryoneCan(useCalculator()))
        val actor = OnStage.theActorCalled(actorName)
        actor.attemptsTo(Log.info(action))
    }

    @When("he adds the values {int} and {int}")
    fun addTwoIntegers(x: Int, y: Int) {
        OnStage.theActorInTheSpotlight().attemptsTo(Sum.integers(x, y))
    }

    @When("he multiplies {word} by {word}")
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

    @Then("he sees the result of the {} is a {word} of value {}")
    fun heSeesTheResultIsResult(operation: String, type: String, expectedResult: String) {

        OnStage.theActorInTheSpotlight().should(
            seeThat("Result", CalculationResult(operation), equalTo(convertExpectedResult(type, expectedResult)))
        )
    }

}

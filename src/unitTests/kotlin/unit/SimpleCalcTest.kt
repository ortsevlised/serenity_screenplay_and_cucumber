package unit

import SimpleCalc
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimpleCalcTest {

    // Tests for add function
    @Test
    fun testAddPositiveNumbers() {
        assertEquals(5, SimpleCalc.add(2, 3))
    }

    @Test
    fun testAddNegativeNumbers() {
        assertEquals(-10, SimpleCalc.add(-2, -8))
    }

    @Test
    fun testAddMixedNumbers() {
        assertEquals(-1, SimpleCalc.add(-3, 2))
    }

    @Test
    fun testAddZeroes() {
        assertEquals(0, SimpleCalc.add(0, 0))
    }

    @Test
    fun testAddOverflow() {
        val largeValue = Int.MAX_VALUE
        assertEquals(largeValue, SimpleCalc.add(largeValue, 0))
    }

    // Tests for multiply function
    @Test
    fun testMultiplyPositiveNumbers() {
        assertEquals(6.0, SimpleCalc.multiply(2.0, 3.0), 0.001)
    }

    @Test
    fun testMultiplyNegativeNumbers() {
        assertEquals(24.0, SimpleCalc.multiply(-2.0, -12.0), 0.001)
    }

    @Test
    fun testMultiplyMixedNumbers() {
        assertEquals(-7.0, SimpleCalc.multiply(-2.0, 3.5), 0.001)
    }

    @Test
    fun testMultiplyByZero() {
        assertEquals(0.0, SimpleCalc.multiply(0.0, 5.0), 0.001)
    }

    @Test
    fun testMultiplyByIdentity() {
        assertEquals(5.0, SimpleCalc.multiply(5.0, 1.0), 0.001)
    }

    @Test
    fun testMultiplyByNegation() {
        assertEquals(-5.0, SimpleCalc.multiply(5.0, -1.0), 0.001)
    }

    @Test
    fun testMultiplyLargeNumbers() {
        val largeNumber = 1e308
        assertEquals(largeNumber * 2.0, SimpleCalc.multiply(largeNumber, 2.0))
    }

    @Test
    fun testMultiplySmallNumbers() {
        val smallNumber = 1e-308
        assertEquals(smallNumber * 2.0, SimpleCalc.multiply(smallNumber, 2.0))
    }

    // Tests for sumOffEvens function
    @Test
    fun testSumOfEvensMixedArray() {
        assertEquals(6, SimpleCalc.sumOffEvens(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSumOfEvensAllOddNumbers() {
        assertEquals(0, SimpleCalc.sumOffEvens(intArrayOf(1, 3, 5)))
    }

    @Test
    fun testSumOfEvensAllEvenNumbers() {
        assertEquals(12, SimpleCalc.sumOffEvens(intArrayOf(2, 4, 6)))
    }

    @Test
    fun testSumOfEvensEmptyArray() {
        assertEquals(0, SimpleCalc.sumOffEvens(intArrayOf()))
    }

    @Test
    fun testSumOfEvensAllNegativeNumbers() {
        assertEquals(0, SimpleCalc.sumOffEvens(intArrayOf(-1, -3, -5, -7)))
    }

    @Test
    fun testSumOfBigEvensNumbers() {
        // Choosing large even numbers that sum up to just below Int.MAX_VALUE
        val largeEven1 = Int.MAX_VALUE - 3 // Making sure it's an even number
        val smallEven = 2 // A small even number to add
        val expectedSum = Int.MAX_VALUE - 1

        assertEquals(
            expectedSum, SimpleCalc.sumOffEvens(intArrayOf(largeEven1, smallEven)),
            "The sum should be close to Int.MAX_VALUE without overflowing"
        )
    }

    @Test
    fun testSumOfEvensLargeArrayAllNegativeNumbers() {
        // Generate a large array of negative numbers (e.g., size 10000)
        val largeArray = IntArray(10000) { -it * 2 - 1 }

        assertEquals(0, SimpleCalc.sumOffEvens(largeArray))
    }
}

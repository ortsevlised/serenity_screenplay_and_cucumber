package serenity

object Utils {
    /**
     * Converts a string representation of an expected result to its actual data type.
     *
     * @param type The target data type ("int" or "double" for the purpose of this project).
     * @param expectedResult The expected result in string form.
     * @return Converted expected result as an int or double.
     * @throws IllegalArgumentException for unsupported types or invalid expectedResult format.
     */
     fun convertExpectedResult(type: String, expectedResult: String): Any {
        return when (type.lowercase()) {
            "int" -> expectedResult.toInt()
            "double" -> when (expectedResult) {
                "Double.POSITIVE_INFINITY" -> Double.POSITIVE_INFINITY
                "Double.NEGATIVE_INFINITY" -> Double.NEGATIVE_INFINITY
                else -> expectedResult.toDouble()
            }

            else -> throw IllegalArgumentException("Unknown type: $type")
        }
    }
}
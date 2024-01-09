Feature: SimpleCalc tests

  Scenario Outline: Adding <title>
    Given Jorge is using the calculator
    When he adds the values <value1> and <value2>
    Then he sees the result of the sum of 2 integers is a int of value <result>

    Examples:
      | title                             | value1     | value2 | result      |
      | two positives integers            | 1          | 2      | 3           |
      | two negatives integers            | -5         | -9     | -14         |
      | a positive and a negative integer | 4          | -3     | 1           |
      | two zeroes                        | 0          | 0      | 0           |
      | max integer and zero              | 2147483647 | 0      | 2147483647  |
      | max integer overflows             | 2147483647 | 1      | -2147483648 |


  Scenario Outline: Multiplying <title>
    Given Jorge is using the calculator
    When he multiplies <value1> by <value2>
    Then he sees the result of the multiplication of 2 doubles is a double of value <result>

    Examples:
      | title                                    | value1   | value2 | result                   |
      | two positives doubles                    | 2.0      | 3.0    | 6.0                      |
      | two negatives doubles                    | -5.0     | -2.0   | 10.0                     |
      | two mixed doubles                        | 4.0      | -3.2   | -12.8                    |
      | by zero                                  | 0.0      | 5.0    | 0.0                      |
      | by identity                              | 3123.92  | 1      | 3123.92                  |
      | large values result in Infinity          | 1.0E308  | 2.0    | Double.POSITIVE_INFINITY |
      | small values result in negative Infinity | -1.0E308 | 2.0    | Double.NEGATIVE_INFINITY |

  Scenario Outline: Adding even numbers in <title>
    Given Jorge is using the calculator
    When he adds the even numbers in <values>
    Then he sees the result of the addition of even numbers is a int of value <result>

    Examples:
      | title                | values         | result |
      | mixed array          | 2,3,6          | 8      |
      | all odd numbers      | 1,3,9,11       | 0      |
      | empty array          |                | 0      |
      | all negative numbers | -1,-2,-3,-4,-5 | -6     |



Feature: SimpleCalc tests

  Scenario Outline: Adding two Integers
    Given Jorge is using the calculator to <title>
    When he adds the values <value1> and <value2>
    Then he sees the result of the sum of 2 integers is a int of value <result>

    Examples:
      | title                                 | value1      | value2 | result      |
      | add two positives integers            | 1           | 2      | 3           |
      | add two negatives integers            | -5          | -9     | -14         |
      | add a positive and a negative integer | 4           | -3     | 1           |
      | add two zeros                         | 0           | 0      | 0           |
      | add max integer and zero              | 2147483647  | 0      | 2147483647  |
      | add max integer overflows             | 2147483647  | 1      | -2147483648 |
      | add min integer underflow             | -2147483648 | -1     | 2147483647  |


  Scenario Outline: Multiplying two doubles
    Given Jorge is using the calculator to <title>
    When he multiplies <value1> by <value2>
    Then he sees the result of the multiplication of 2 doubles is a double of value <result>

    Examples:
      | title                                             | value1   | value2 | result                   |
      | multiply two positives doubles                    | 2.0      | 3.0    | 6.0                      |
      | multiply two negatives doubles                    | -5.0     | -2.0   | 10.0                     |
      | multiply two mixed doubles                        | 4.0      | -3.2   | -12.8                    |
      | multiply by zero                                  | 0.0      | 5.0    | 0.0                      |
      | multiply by negative zero                         | 0.0      | -0.0   | -0.0                     |
      | multiply by identity                              | 3123.92  | 1.0    | 3123.92                  |
      | multiply large values result in Infinity          | 1.0E308  | 2.0    | Double.POSITIVE_INFINITY |
      | multiply small values result in negative Infinity | -1.0E308 | 2.0    | Double.NEGATIVE_INFINITY |

  Scenario Outline: Adding even numbers in array
    Given Jorge is using the calculator to <title>
    When he adds the even numbers in <values>
    Then he sees the result of the addition of even numbers is a int of value <result>

    Examples:
      | title                                                | values          | result |
      | sum even numbers in an array of mixed numbers        | 2,3,6           | 8      |
      | sum even numbers in an array of all odd numbers      | 1,3,9,11        | 0      |
      | sum even numbers in an array of all even numbers     | 10,12,14,20     | 56     |
      | sum even numbers in an empty array                   |                 | 0      |
      | sum even numbers in an array of all zeros            | 0,0,0,0,0,0,0,0 | 0      |
      | sum even numbers in an array of all negative numbers | -1,-2,-3,-4,-5  | -6     |



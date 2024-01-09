# SimpleCalc Testing Project
This project demonstrates a comprehensive approach to testing a simple Kotlin/JVM application named SimpleCalc. 
It includes unit testing, behavior-driven development (BDD) scenarios, a Python wrapper for test execution, and GitHub Actions for automated testing.

## Overview of SimpleCalc
SimpleCalc is a Kotlin object that offers three functionalities:

- Addition of integers
- Multiplication of doubles
- Calculation of the sum of even numbers in an array

## Project Structure
- src: Contains the SimpleCalc Kotlin object and its implementation.
- tests: Includes the BDD scenarios.
- unitTests: Includes the unit tests.
- simple-calc-test-runner.py: A Python script to run the tests.
- .github/workflows: Contains the GitHub Actions workflow file.

## Tasks
1. Unit Tests Implementation: Unit tests for SimpleCalc are implemented using JUnit.
2. BDD Scenarios Implementation: BDD scenarios are written and executed using Serenity BDD with Cucumber.
3. Python Wrapper: A Python script to run both unit tests and BDD scenarios, manage test reports, and handle logs.
4. GitHub Actions Automation: A GitHub Actions workflow to automate the execution of tests using the Python wrapper.

## BDD Scenarios
BDD scenarios are crafted to cover both basic and advanced use cases of SimpleCalc, showcasing thorough testing practices. The scenarios are designed to demonstrate the usage of Serenity BDD together with Cucumber following the Screenplay pattern.

## Python Wrapper
The Python wrapper, simple-calc-test-runner.py, facilitates:

- Separate execution of unit tests and BDD scenarios.
- Saving of reports in a specified reports directory.
- Logging of stdout and stderr in the logs directory.

## Usage:
```
# Run unit tests
python simple-calc-test-runner.py --run unittests --reports-dir unit-test-reports

# Run BDD scenarios
python simple-calc-test-runner.py --run scenarios --reports-dir bdd-test-reports
``` 

## GitHub Actions
The .github/workflows directory contains a workflow file to automate testing. The workflow triggers on manual dispatch, allowing the selection of test types and specification of directories for reports.

## Running the Tests Locally
To run the tests locally, ensure you have Python and the required JDK installed. Use the simple-calc-test-runner.py script as shown above to execute the tests and generate reports.
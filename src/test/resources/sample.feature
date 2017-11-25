
Feature: This feature is my first cucumber test
  This is a description for the feature


  Scenario: This is my first Cucumber scenario
    This is a description for the sample.feature's first scenario

    Given sample feature file is ready
    When I run the feature file
    Then run should be successful


  Scenario: This is my 2nd Cucumber scenario
    This is a description for the sample.feature's second scenario

    Given sample feature file is really ready
    When I really run the feature file
    Then run should be really successful

  @smokeTest
  Scenario Outline: Parse a string
    This is scenario to demonstrate the ability to parse a string

    When the string, "<theString>" should have "<expCount>" of the character "<theChar>"
    Then run should be successful
    Examples:
      | theString                          | theChar | expCount |
      | SuperCalifragilisticExpialidocious | l       | 3        |
      | SuperCalifragilisticExpialidocious | S       | 11       |
      | helloWorld                         | a       | 0        |


    Scenario: Try Groovy Cucumber
      This is to prove tha Groovy and Java classes can work side-by-side within a Cucumber project

      When Hello World
      Then We parse
      Then the JSON element "version[0]" has a value of "3.0.2"
      Then the JSON element "response" contains an object that include "returnCode"
      Then the JSON object "itemserviceresult" contains "3" arrays


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
  Scenario: Parse a string
  This is scenario to demonstrate the ability to parse a string

    Then I parse a string, "SuperCalifragilisticExpialidocious", for the count of the character, "l"

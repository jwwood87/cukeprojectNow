
Feature: This feature is my second cucumber test
  This is a description for the feature

  Scenario: This is my 1st scenario
    This is a description for the scenario

    Given sample feature file is ready
    When I run the feature file
    Then run should be successful


  Scenario: This is my 2nd Cucumber scenario
    This is a description for the scenario

    Given sample silly feature file is really ready
    When I really run the silly feature file
    Then run should be sillysuccessful

  @smokeTest
  Scenario Outline: This is my test to support Keith's request
    Keith asked me to write code for a Google Search

    Given I navigate to Google
    #Todo Need to implement an assertion to test whether we really get expected results
    When I search for "<SearchPattern>" and get the expected results
    Then I close the browser
    Examples:
      | SearchPattern |
      | Any Search    |
      | any search    |
      | Ugly Code     |
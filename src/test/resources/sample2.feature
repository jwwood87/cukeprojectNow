
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

    Given I launch a browser
    And I navigate to "http://google.com"
    When I search Google with the pattern, "<SearchPattern>", and the results include the pattern
    Then I close the browser
    Examples:
      | SearchPattern |
      | Any Search    |
      | any search    |
      | Ugly Code     |


    Scenario: List of Gherkin Statements that need step definitions

      Given I launch a browser
      Given I navigate to "<url>"
      Given I click the "<value>" element that has attribute id = "<value>"
      Given I click the "<value>" element that has attribute class = "<value>"
      Given I click the "<value>" element that has a value of "<value>"
      Given I click the "<value>" element that has attribute id = "<value>" and a value of "<value>"
      Given I click the "<value>" element that has attribute
      Given I enter "<value>" into the "<value>" element that has attribute id = "<value>"
      Given I enter "<value>" into the "<value>" element that has attribute class = "<value>"
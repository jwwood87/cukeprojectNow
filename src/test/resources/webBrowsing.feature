
Feature: This feature encapsulates browser interactions
  This is a description for the feature


  Scenario Outline: This is my test to support Keith's request
    Keith asked me to write code for a Google Search

    And I launch the browser and navigate to "http://google.com"
    When I search Google with the pattern, "<SearchPattern>", and the results include the pattern
    Examples:
      | SearchPattern |
      | Any Search    |
      # Fail path
      | any search    |
      | Ugly Code     |

  @smoke
    Scenario: List of Gherkin web navigation statements
      This scenario provides examples of the implemented gherkin statements used to direct a browser

      Given I launch the browser and navigate to "http://google.com"
      When I click the Gmail Button with element "a" and attribute "class" equal to "gb_P"
      And the element "a" with attribute "class" equal to "gmail-nav__home-link" is present
      And I move the browser back
      And I move the browser forward


  Scenario: List of Gherkin web navigation assertions
      This scenario provides examples of the implemented gherkin statements used to check a browser

    Given I launch the browser and navigate to "http://google.com"
    Given the "Google Icon" element with id "hplogo" is present
    And the element "a" with attribute "class" equal to "_XIi" contains "See what the world searched for in 2016"
    And the element "a" with attribute "class" equal to "_XIi" has a value of "See what the world searched for in 2016"
    And the element with id "hplogo" is not present

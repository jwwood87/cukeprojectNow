$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("sample.feature");
formatter.feature({
  "line": 2,
  "name": "T test my cucumber",
  "description": "",
  "id": "t-test-my-cucumber",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "cucumber setup",
  "description": "",
  "id": "t-test-my-cucumber;cucumber-setup",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "sample feature file is ready",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I run the feature file",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.givenStatement()"
});
formatter.result({
  "duration": 439995210,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.whenStatement()"
});
formatter.result({
  "duration": 107422,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.thenStatement()"
});
formatter.result({
  "duration": 122475,
  "status": "passed"
});
});
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by John on 12/3/2016.
 */
public class StepDefinitions {
    @Given("^sample feature file is ready$")
    public void givenStatement(){

        System.out.println("The feature file is ready");
    }

    @Given("^sample feature file is really ready$")
    public void givenReallyStatement(){

        System.out.println("The feature file is really ready");
    }

    @When ("^I run the feature file$")
    public void whenStatement(){

        System.out.println("I run the feature file");
    }

    @When ("^I really run the feature file$")
    public void whenReallyStatement(){

        System.out.println("I really run the feature file");
    }

    @Then("^run should be successful$")
    public void thenStatement(){
        System.out.println("The test is successful"); }

    @Then("^run should be really successful$")
    public void thenReallyStatement(){
         System.out.println("The test is really successful");
    }
}

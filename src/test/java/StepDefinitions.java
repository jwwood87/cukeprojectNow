import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by John on 12/3/2016. Test
 */
public class StepDefinitions {
    @Given("^sample feature file is ready$")
    public void givenStatement(){
        System.out.println("file is ready");
    }

    @When ("^I run the feature file$")
    public void whenStatement(){
        System.out.println("file is ready");
    }

    @Then("^run should be successful$")
    public void thenStatement(){
        System.out.println("file is ready");
    }
}

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by John on 12/3/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/test-report"},tags="@smokeTest")
public class CucumberRunner {


}

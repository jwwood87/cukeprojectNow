package javaPack; /**
 * Created by John on 12/6/2016.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by John on 12/3/2016.
 */
        // This is the class that runs Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(
        // Configure cucumber so it can find the specified feature file directory
        features = "src/test/resources/",
        // Configure cucumber to locate the package of the glue code , e.g. javaPack
        glue = "javaPack",
        // Configure cucumber so that an HTML test test report is generated in the target folder
        plugin = {"html:target/cucumber-report",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml"},
        tags = {"@smokeTest"},
        monochrome = false
)
public class CucumberRunner {

}


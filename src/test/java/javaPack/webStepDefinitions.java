package javaPack;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static javaPack.supportStepDefs.returnIncludesSearch;
import static org.junit.Assert.assertTrue;

/**
 * Created by John on 12/9/2016.
 */
public class webStepDefinitions {

    WebDriver driver;

    @Before
    public void setup () {
        System.out.println("\n" + "Hi, from within the Before setup method.");
        // Set property for geckodriver, launch browser and set the implicit wait to 5 seconds
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        System.out.println("\n" + "Bye, from within the After afterTest method.");
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.manage().window().maximize();
    }

    @Given("^I launch a browser$")
    public void i_launch_a_browser() throws Throwable {

        driver.manage().window().maximize();
    }

    @Given("^I navigate to \"([^\"]*)\"")
    public void i_navigate_to_Google(String uri) throws  Throwable{

        driver.get(uri);
    }

    @When("^I search Google with the pattern, \"([^\"]*)\", and the results include the pattern$")
    public void i_search_for(String searchPattern) {

        boolean searchResultPresent = false;
        // Enter the designated search condition into Google's page
        WebElement searchWindow = driver.findElement(By.id("lst-ib"));
        searchWindow.sendKeys(searchPattern);
        searchWindow.submit();
        WebElement searchButton = driver.findElement(By.className("sbico-c"));
        searchButton.click();
        // Check whether the search results include the search pattern for each of the first 4 returns
        WebElement searchResult1 = driver.findElement(By.xpath("//div[@id='rso']/div[1]/div/div[1]/div/h3/a"));
        System.out.println( "The first search return is \"" + searchResult1.getText() + "\"" );
        if (returnIncludesSearch(searchPattern,searchResult1.getText())) {
            System.out.println("The 1st result includes the pattern " + "\n");
            searchResultPresent=true;
        } else
            System.out.println("The 1st result does not include the pattern" + "\n");

        WebElement searchResult2 = driver.findElement(By.xpath("//div[@id='rso']/div[1]/div/div[2]/div/h3/a"));
        System.out.println( "The 2nd search return is \"" + searchResult2.getText() + "\"" );
        if (returnIncludesSearch(searchPattern,searchResult2.getText())) {
            System.out.println("The 2nd result includes the pattern " + "\n");
            searchResultPresent=true;
        } else
            System.out.println("The 2nd result does not include the pattern" + "\n");

        WebElement searchResult3 = driver.findElement(By.xpath("//div[@id='rso']/div[1]/div/div[3]/div/h3/a"));
        System.out.println( "The third search return is \"" + searchResult3.getText() + "\"" );
        if (returnIncludesSearch(searchPattern,searchResult3.getText())) {
            System.out.println("The 3rd result includes the pattern." + "\n");
            searchResultPresent=true;
        } else
            System.out.println("The 3rd result does not include the pattern." + "\n");

        WebElement searchResult4 = driver.findElement(By.xpath("//div[@id='rso']/div[1]/div/div[4]/div/h3/a"));
        System.out.println( "The fourth search return is \"" + searchResult4.getText() + "\"" );
        if (returnIncludesSearch(searchPattern,searchResult4.getText())) {
            System.out.println("The 4th result includes the pattern." + "\n");
            searchResultPresent=true;
        } else
            System.out.println("The 4th result does not include the pattern." + "\n");
        assertTrue(searchResultPresent);
    }

    @Then("^I close the browser$")
    public void i_close_the_browser(){
        // Todo. The next line closes by browser (correct), but causes an ABORT: see https://github.com/mozilla/geckodriver/issues/210
        driver.quit();
    }
    public void setDriver(WebDriver driver) {

    }
}

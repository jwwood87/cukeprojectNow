package javaPack;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
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
        // Set property for geckodriver, launch browser and set the implicit wait to 5 seconds; first line for PC; second line for Mac
        // System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Selenium\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","/Users/a84558/SoftwareAndPlugins/Selenium/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
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

    @Given("^I launch the browser and navigate to \"([^\"]*)\"")
    public void i_navigate_to_Google(String uri) throws  Throwable{
        driver.get(uri);
    }

    @Given("^I click the (?:.*) with element \"(.*?)\" and attribute \"(.*?)\" equal to \"(.*?)\"$")
    public void i_click_the_link_with_element_and_attribute(String elementName, String attributeName, String attrValue) {
        String xPathQuery;
        xPathQuery = ("//" + elementName + "[@" + attributeName + "='" + attrValue + "']");
        driver.findElement(By.xpath(xPathQuery)).click();
    }

    @Given("^I move the browser back$")
    public void i_navigate_back() throws Throwable {
        try {
            driver.navigate().back();
        } catch (Throwable th) {
            driver.close();
        }
    }

    @Given("^I move the browser forward$")
    public void i_navigate_forward() throws Throwable {
        try {
            driver.navigate().forward();
        } catch (Throwable th) {
            driver.close();
        }
    }

    @Then("^I enter \"([^\"]*)\" for the text field with an id equal to \"([^\"]*)\"$")
    public void enter_text_for_element(String textEntered, String textBox) {
        driver.findElement(By.id(textBox)).sendKeys(textEntered);
    }

    @And("^I clear the textbox for the element with an id \"([^\"]*)\"$")
    public void clear_textbox(String clearThis) {
        driver.findElement(By.id(clearThis)).clear();
    }

    @Then("^the (?:.*) element with id \"(.*?)\" is present$")
    public void the_element_with_id_is_present(String idName) throws Throwable {
        try {
            Assert.assertTrue(driver.findElement(By.id(idName)).isEnabled());
        } catch (Throwable th) {
            // If the id is NOT present, flag it in cucumber results
            Assert.assertTrue(false);
            System.out.println("\n" + "The element is not present.");
            driver.close();
        }
    }

    @Given("^an xPath equal to \"(.*?)\", the element contains \"(.*?)\"$")
    public void element_attribute_contains(String xPathQuery, String elementValue) throws Exception {

        String returnVal = driver.findElement(By.xpath(xPathQuery)).getText();
        Assert.assertTrue(driver.findElement(By.xpath(xPathQuery)).getText().contains(elementValue));
    }

    @Given("^the element \"(.*?)\" with attribute \"(.*?)\" equal to \"(.*?)\" contains \"(.*?)\"$")
    public void element_attribute_contains(String elementName, String attributeName, String attrValue, String elementValue) throws Exception {
        String xPathQuery = ("//" + elementName + "[@" + attributeName + "='" + attrValue + "']").toString();
        String returnVal = driver.findElement(By.xpath(xPathQuery)).getText();
        Assert.assertTrue(driver.findElement(By.xpath(xPathQuery)).getText().contains(elementValue));
    }

    @And("^(?:The|the) element \"([^\"]*)\" with attribute \"([^\"]*)\" equal to \"([^\"]*)\" has a value of \"([^\"]*)\"$")
    public void element_attribute_value(String elementName, String attributeName, String attrValue, String elementValue) throws Throwable {
        String xPathQuery;
        String returnVal;
        xPathQuery = ("//" + elementName + "[@" + attributeName + "='" + attrValue + "']").toString();
        Assert.assertTrue(driver.findElement(By.xpath(xPathQuery)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(xPathQuery)).getText().equals(elementValue));
    }

    @Given("^the element \"(.*?)\" with attribute \"(.*?)\" equal to \"(.*?)\" is present")
    public void the_element_with_attribute_is_present(String elementName, String attributeName, String attrValue) throws Throwable {
        try {
            String xPathQuery = ("//" + elementName + "[@" + attributeName + "='" + attrValue + "']").toString();
            Assert.assertTrue(driver.findElement(By.xpath(xPathQuery)).isEnabled());
        } catch (Throwable th) {
            System.out.println("\n" + "The element is not present.");
            driver.close();
        }
    }

//    Todo. Get this to work correctly
    @Then("^(?:The|the) element with id \"([^\"]*)\" is not present$")
    public void the_element_is_not_displayed(String idName) throws Throwable {
        try {
            System.out.println("THis is the size of the object " + driver.findElement(By.id(idName)).getSize().toString());
        } catch (Throwable th) {
            // If the id IS present, flag it in cucumber results
            System.out.println("\n" + "The element is present, but should NOT be.");
            Assert.assertTrue(false);
            driver.close();
        }
    }

    @When("^I search Google with the pattern, \"([^\"]*)\", and the results include the pattern$")
    public void i_search_for(String searchPattern) throws Throwable {
        try {

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

        } catch (Throwable th) {
            assertTrue(false);
            driver.close();
        }
    }

    @Then("^I close the browser$")
    public void i_close_the_browser(){
        // Todo. The next line closes by browser (correct), but causes an ABORT: see https://github.com/mozilla/geckodriver/issues/210
        driver.quit();
    }
    public void setDriver(WebDriver driver) {

    }
}

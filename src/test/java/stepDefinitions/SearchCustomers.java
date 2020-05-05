package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CustomerSearchPage;

import java.util.concurrent.TimeUnit;

public class SearchCustomers {
    public String baseUrl = "C:/CodingChallenge/index.html";
    public WebDriver driver;

    @Before
    public void initializeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I go to home page")
    public void iGoToHomePage() {
        driver.get(baseUrl);
    }

    @When("I enter the  phrase {string} in the input field")
    public void iEnterThePhrasePhraseInTheInputField(String phrase) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
    }

    @And("I select value from the {string} dropdown")
    public void iSelectValueFromTheSearchCriteriaDropdown(String searchCriteria) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
    }

    @Then("message contains phrase {string} and criteria {string} with {string}")
    public void messageContainsPhrasePhraseAndCriteriaSearchCriteriaWithMatchCase(String phrase, String searchCriteria, String matchCase) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
    }

    @And("there are elements containing {string} in field {string} displayed in the table")
    public void thereAreElementsContainingPhraseInFieldSearchCriteriaDisplayedInTheTable(String phrase, String searchCriteria) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
    }


}

package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        customerSearchPage.enterSearchText(phrase);
    }

    @When("I select value from the {string} dropdown")
    public void iSelectValueFromTheSearchCriteriaDropdown(String searchCriteria) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        customerSearchPage.selectSearchCriteriaFromDropdown(searchCriteria);
    }

    @When("I select {string} option")
    public void iSelectMatchCaseOption(String matchCase) {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        switch (matchCase.toLowerCase()) {
            case "with match case":
                customerSearchPage.checkMatchCase();
                break;
            case "without match case":
                customerSearchPage.uncheckMatchCase();
                break;
            default:
                throw new UnsupportedOperationException("Not supported action " + matchCase);
        }

    }

    @Then("message contains phrase {string} and criteria {string} with {string}")
    public void messageContainsPhrasePhraseAndCriteriaSearchCriteriaWithMatchCase(String phrase, String searchCriteria, String matchCase) {
        phrase = "\"" + phrase + "\"";
        searchCriteria = searchCriteria + " column";
        String matchCaseResult;
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        String searchResultMessage = customerSearchPage.getSearchResultMessage();
        Assert.assertTrue("Message does not contain searching phrase " + phrase, searchResultMessage.contains(phrase));
        Assert.assertTrue("Message does not contain search criteria " + searchCriteria, searchResultMessage.contains(searchCriteria));
        switch (matchCase.toLowerCase()) {
            case "with match case":
                matchCaseResult = "with match case.";
                break;
            case "without match case":
                matchCaseResult = "without match case.";
                break;
            default:
                throw new UnsupportedOperationException("Not supported action " + matchCase);
        }
        Assert.assertTrue("Message does not contain text " + matchCaseResult, searchResultMessage.contains(matchCaseResult));
    }

    @Then("message contains proper number of displayed rows")
    public void thereAreElementsContainingPhraseInFieldSearchCriteriaDisplayedInTheTable() {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        String numberOfRows = "Showing " + customerSearchPage.getNumberOfRows();
        String message = customerSearchPage.getResultNumberFromMessage();
        Assert.assertTrue("Wrong result number is displayed in a message (" + message + ")",
                message.contains(numberOfRows));
    }

}

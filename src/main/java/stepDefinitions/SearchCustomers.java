package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCustomers {
    @Given("I go to home page$")
    public void goToHomePage() {
    }

    @When("I enter the  phrase'<phrase>' the input field$")
    public void thePhraseIsEnteredInTheInputField() {
    }

    @When("I select value from the '<searchCriteria>' dropdown$d")
    public void theValueFromSearchCriteriaIsSelected() {
    }


    @Then("message contains phrase '<phrase>' and criteria '<searchCriteria>' with '<matchCase>'")
    public void MessageIsDisplayed() {
    }

    @Then("there are elements containing '<phrase>' in field '<searchCriteria>' displayed in the table$")
    public void ResultsAreShown() {
    }
}

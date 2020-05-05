import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CustomerSearchPage;

public class CustomersSearchTest extends BaseTest {

    @Test
    public void selectElementById() {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        customerSearchPage.enterSearchText("1")
                .selectSearchCriteriaFromDropdown("Id");
        Assertions.assertTrue(customerSearchPage.isDisplayedMessageElement(), "Showing 1 of 3 customers filtered by term \"1\" in Id column without match case.");
    }

    @Test
    public void selectElementByName() {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        customerSearchPage.enterSearchText("Bondir")
                .selectSearchCriteriaFromDropdown("Name");
        Assertions.assertTrue(customerSearchPage.isDisplayedMessageElement(), "Showing 1 of 3 customers filtered by term \"Bondir\" in Name column without match case.");
    }

    @Test
    public void selectElementByNonexistingName() {
        CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
        customerSearchPage.enterSearchText("billy")
                .selectSearchCriteriaFromDropdown("Name")
                .checkMatchCase();
        Assertions.assertTrue(customerSearchPage.isDisplayedMessageElement(), "Showing 0 of 3 customers filtered by term \"billy\" in Name column without match case.");
    }
}

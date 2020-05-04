package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerSearchPage extends BasePage {
    private final By inputElementLocator = By.cssSelector("#search-input");
    private final By dropdownElementLocator = By.cssSelector("#search-column");
    private final By matchCaseBoxLocator = By.cssSelector(".checkbox-inline");

    public CustomerSearchPage(WebDriver driver) {
        super(driver);
    }

    public CustomerSearchPage searchPeopleByInput() {
        WebElement inputElement = driver.findElement(inputElementLocator);
        inputElement.sendKeys();
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage selectSearchCriteriaFromDropdown(String searchCriteria) {
        WebElement dropdownElement = driver.findElement(dropdownElementLocator);
        new Select(dropdownElement).selectByVisibleText(searchCriteria);
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage clickMatchCase() {
        WebElement matchCaseBox = driver.findElement(matchCaseBoxLocator);
        matchCaseBox.click();
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage checkMatchCase() {
        WebElement matchCaseBox = driver.findElement(matchCaseBoxLocator);
        if (!matchCaseBox.isSelected())
            matchCaseBox.click();
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage uncheckMatchCase() {
        WebElement matchCaseBox = driver.findElement(matchCaseBoxLocator);
        if (matchCaseBox.isSelected())
            matchCaseBox.click();
        return new CustomerSearchPage(driver);
    }
}

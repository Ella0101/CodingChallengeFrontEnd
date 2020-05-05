package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerSearchPage extends BasePage {
    private final By searchInputElementLocator = By.cssSelector("#search-input");
    private final By dropdownElementLocator = By.cssSelector("#search-column");
    private final By matchCaseBoxLocator = By.cssSelector(".checkbox-inline");
    private final By searchTextElementLocator = By.cssSelector("#table-resume");

    public CustomerSearchPage(WebDriver driver) {
        super(driver);
    }

    public CustomerSearchPage enterSearchText(String text) {
        WebElement inputElement = driver.findElement(searchInputElementLocator);
        inputElement.sendKeys(text);
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

    public boolean isDisplayedMessageElement() {
        return driver.findElement(searchTextElementLocator).isDisplayed();
    }
}

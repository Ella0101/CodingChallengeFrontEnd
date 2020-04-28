package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerSearchPage extends BasePage {
    private final By inputElementLocator = By.cssSelector("#search-input");
    private final By dropdownElementLocator = By.cssSelector("#search-column");
    private final By matchCaseBoxLocator = By.cssSelector(".checkbox-inline");

    public CustomerSearchPage(WebDriver driver) {
        super(driver);
    }

    public CustomerSearchPage searchPeopleByInput(){
        WebElement inputElement = driver.findElement(inputElementLocator);
        inputElement.sendKeys();
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage searchPeopleFromDropdown() {
        WebElement dropdownElement = driver.findElement(dropdownElementLocator);
        dropdownElement.click();
        return new CustomerSearchPage(driver);
    }

    public CustomerSearchPage searchPeopleUsingMatchCase() {
        WebElement matchCaseBox = driver.findElement(matchCaseBoxLocator);
        matchCaseBox.click();
        return new CustomerSearchPage(driver);
    }
}

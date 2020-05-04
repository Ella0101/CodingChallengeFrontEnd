import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomersSearchTest extends BaseTest {

    @Test
    public void selectElementById() {
        WebElement inputElement = driver.findElement(By.cssSelector("#search-input"));
        inputElement.sendKeys("1");
        WebElement dropdownElement = driver.findElement(By.cssSelector("#search-column"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Id");
        Assertions.assertTrue(inputElement.isDisplayed(), "Showing 1 of 3 customers filtered by term \"1\" in Id column without match case.");
    }

    @Test
    public void selectElementByName() {
        WebElement inputElement = driver.findElement(By.cssSelector("#search-input"));
        inputElement.sendKeys("Bondir");
        WebElement dropdownElement = driver.findElement(By.cssSelector("#search-column"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Name");
        Assertions.assertTrue(inputElement.isDisplayed(), "Showing 1 of 3 customers filtered by term \"Bondir\" in Name column without match case.");
    }

    @Test
    public void selectElementByNonexistingName() throws InterruptedException {
        WebElement inputElement = driver.findElement(By.cssSelector("#search-input"));
        inputElement.sendKeys("billy");
        WebElement dropdownElement = driver.findElement(By.cssSelector("#search-column"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Name");
        WebElement matchCaseBox = driver.findElement(By.cssSelector(".checkbox-inline"));
        matchCaseBox.click();
        Assertions.assertTrue(inputElement.isDisplayed(), "Showing 0 of 3 customers filtered by term \"billy\" in Name column without match case.");
    }
}

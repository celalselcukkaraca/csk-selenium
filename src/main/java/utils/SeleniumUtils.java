package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout 10 seconds
        this.actions = new Actions(driver);
    }


    public String getElementText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniye bekle
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element.getText();
    }

    /**
     * Waits for the element to be clickable and then clicks it.
     *
     * @param locator By locator of the element
     */
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Waits for the element to be visible and then performs a double click.
     *
     * @param locator By locator of the element
     */
    public void doubleClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(element).perform();
    }

    /**
     * Waits for the element to be visible and sends keys to it.
     *
     * @param locator By locator of the element
     * @param text    Text to send to the element
     */
    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Waits for an element to be visible.
     *
     * @param locator By locator of the element
     * @return WebElement after it is visible
     */
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be invisible.
     *
     * @param locator By locator of the element
     * @return true if the element becomes invisible
     */
    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Moves to the element and clicks on it.
     *
     * @param locator By locator of the element
     */
    public void moveToAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).click().perform();
    }

    /**
     * Scrolls to the element and clicks it.
     *
     * @param locator By locator of the element
     */
    public void scrollToAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
        element.click();
    }

    /**
     * Checks if an element is visible on the page.
     *
     * @param locator By locator of the element
     * @return true if the element is visible, false otherwise
     */
    public boolean isVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Navigates to a specified URL.
     *
     * @param url URL to navigate to
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    public void selectDropDownByText(By locator, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sleep(500);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

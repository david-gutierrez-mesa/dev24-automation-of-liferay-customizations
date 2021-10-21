package browserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;


public class CommonMethods {
    private CommonMethods() {
    }

    public static void click(By locator) {
        DriverManager.getDriver().findElement(locator).click();

    }

    public static String getPageTitle() {
        return DriverManager.getDriver().getTitle();

    }

    public static String getTextFromElement(By locator) {
        return DriverManager.getDriver().findElement(locator).getText();

    }

    public static void inputText(By locator, String text) {
        DriverManager.getDriver().findElement(locator).clear();
        DriverManager.getDriver().findElement(locator).sendKeys(text);

    }

    public static boolean isElementPresent(By locator) {
        return DriverManager.getDriver().findElements(locator).size() != 0;

    }

    public static void navigateTo(URL baseUrl, String path) {
        DriverManager.getDriver().get(String.format("%s%s", baseUrl, path));

    }

    public static void waitAndClick(By locator) {
        waitForElementToBeVisible(locator);
        click(locator);

    }

    public static void waitAndiInputText(By locator, String text) {
        waitForElementToBeVisible(locator);
        inputText(locator, text);

    }

    public static void waitForElementToBeVisible(By locator) {
        DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}

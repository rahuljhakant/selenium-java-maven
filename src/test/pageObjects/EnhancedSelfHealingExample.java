import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class EnhancedSelfHealingExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("http://example.com");

            // Attempt to find the element with self-healing
            WebElement element = findElementWithSelfHealing(driver, wait, "elementId", "elementClassName", "//div[@class='elementClass']");
            if (element != null) {
                // Interact with the element
                element.click();
            } else {
                System.out.println("Element not found using any locator.");
            }

        } finally {
            driver.quit();
        }
    }

    public static WebElement findElementWithSelfHealing(WebDriver driver, WebDriverWait wait, String id, String className, String xpath) {
        List<By> locators = Arrays.asList(By.id(id), By.className(className), By.xpath(xpath));

        for (By locator : locators) {
            try {
                // Use WebDriverWait for better handling of dynamic content
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                System.out.println("Locator failed: " + locator.toString());
            }
        }

        // If all locators fail, attempt to find alternative locators dynamically
        return tryDynamicLocatorRecovery(driver);
    }

    private static WebElement tryDynamicLocatorRecovery(WebDriver driver) {
        // Basic example: You might analyze the DOM and try to find elements by more general criteria
        // This part can be made more sophisticated based on your requirements
        try {
            // Example: Find elements by tag name and choose the first one
            List<WebElement> elements = driver.findElements(By.tagName("div"));
            if (!elements.isEmpty()) {
                System.out.println("Using dynamic recovery to find a fallback element.");
                return elements.get(0); // Return the first div as a fallback
            }
        } catch (Exception e) {
            System.out.println("Dynamic recovery failed: " + e.getMessage());
        }

        return null; // Return null if no recovery is successful
    }
}

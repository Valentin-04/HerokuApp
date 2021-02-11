import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DynamicControlTest {

    @Test
    public void checkDynamicControl() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");

        browser.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox-example #message")));
        assertEquals(checkInputs(browser, 0), 1, "Checkbox didn't delete");

        assertEquals(checkInputs(browser, 1), 0, "Input is enable");
        browser.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-example #message")));
        assertEquals(checkInputs(browser, 1), 1, "Input is disable");

        browser.quit();
    }

    public int checkInputs(WebDriver browser, int number) {
        List<WebElement> inputs = browser.findElements(By.cssSelector("form input"));
        if (number == 0) {
            return inputs.size();
        } else {
            if (inputs.get(0).isEnabled()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest {

    @Test
    public void checkContextMenu() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(browser);
        action
                .moveToElement(browser.findElement(By.id("hot-spot")))
                .contextClick()
                .build()
                .perform();
        Alert alert = browser.switchTo().alert();
        assertEquals(alert.getText(), "You selected a context menu",
                "Message doesn't appear");
        alert.dismiss();
        browser.quit();
    }
}

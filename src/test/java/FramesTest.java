import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FramesTest {

    @Test
    public void checkFrames() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/frames");

        browser.findElement(By.cssSelector("a[href$='iframe']")).click();
        browser.switchTo().frame(0);
        assertEquals(browser.findElement(By.tagName("p")).getText(), "Your content goes here.", "Text doesn't match");

        browser.quit();
    }
}

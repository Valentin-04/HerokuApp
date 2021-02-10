import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {

    @Test
    public void jsAlert() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/javascript_alerts");
        browser.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert = browser.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.dismiss();
        browser.quit();
    }
}

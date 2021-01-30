import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class NotificationMessagesTest {

    @Test
    public void notificationMessagesChecked() {
        String message;

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement buttonClickHere = browser.findElement(By.cssSelector("div>p>a"));

        buttonClickHere.click();
        message = browser.findElement(By.id("flash")).getAttribute("innerText").trim().replaceAll("\\n", ""); // составляем все полученные строки в одну
                //browser.findElement(By.id("flash")).getText();
        checkMessage(message);
        buttonClickHere.click();
        checkMessage(message);
        buttonClickHere.click();
        checkMessage(message);
        buttonClickHere.click();
        checkMessage(message);
        browser.quit();
    }

    public void checkMessage(String text) {
        if (text.contains("Action successful")) {
            text.substring(0,15);
            assertEquals(text, "Action successful×");
        } else {
            text.substring(0,34);
            assertEquals(text, "Action unsuccesful, please try again×"); // опечатка 'unsuccesful' на сайте
        }
    }
}

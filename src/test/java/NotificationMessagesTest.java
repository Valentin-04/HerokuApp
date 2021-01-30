import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class NotificationMessagesTest {

    @Test
    public void notificationMessagesChecked() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/notification_message_rendered");
        buttonClick(browser);
        String message = browser.findElement(By.id("flash-messages")).getText();
        checkMessage(message);
        buttonClick(browser);
        checkMessage(message);
        buttonClick(browser);
        checkMessage(message);

        browser.quit();
    }

    public void buttonClick(WebDriver browser) {
        WebElement buttonClickHere = browser.findElement(By.xpath("//div[@id='content']//a[text()='Click here']"));

        if (buttonClickHere.isDisplayed()) {
            buttonClickHere.click();
        } else {
            System.out.println("I don't see the button"); // вывод для проверки себя
        }
    }

    public void checkMessage(String text) {
        if (text.isEmpty()) {
            System.out.println("Message is empty");
        } else {
            if (text.contains("un")) {
                assertEquals(text, "Action unsuccesful, please try again\n" + "×"); // опечатка 'unsuccesful' на сайте
            } else {
                assertEquals(text, "Action successful\n" + "×");
            }
        }
    }
}

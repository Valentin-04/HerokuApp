import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FileUploadTest {
    public static final String FILE_PATH = new File("src/test/resources/winter.jpg").getAbsolutePath();

    @Test
    public void checkFileUpload() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/upload");

        browser.findElement(By.xpath("//input[@type='file']")).sendKeys(FILE_PATH);
        browser.findElement(By.id("file-submit")).click();
        WebElement image = browser.findElement(By.id("uploaded-files"));
        assertEquals(image.getText(), "winter.jpg", "Filename doesn't match");

        browser.quit();
    }
}

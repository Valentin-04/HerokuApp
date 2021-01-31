import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class HtmlTest {

    @Test
    public void getDataFromSite() {
        final String URL = "file:/home/user/Desktop/index.html";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get(URL);
        // Check data from table
        String tableActualResult = browser.findElement(By.id("td5")).getText();
        assertEquals(tableActualResult, "Jackson");

        // Check data from button
        WebElement buttonActualResult = browser.findElement(By.id("btn"));
        assertTrue(buttonActualResult.isEnabled());

        // Check data from checkbox
        WebElement checkboxActualResult = browser.findElement(By.name("option3"));
        assertFalse(checkboxActualResult.isSelected());

        // Check data from select
        String selectActualResult = browser.findElement(By.name("slc4")).getText();
        assertEquals(selectActualResult, "Opel");

        // Check image
        WebElement imgActualResult = browser.findElement(By.xpath("//img[@alt='joke']"));
        assertTrue(imgActualResult.isDisplayed());

        // Check data from paragraph
        String paragraphActualResult = browser.findElement(By.id("text")).getText();
        assertEquals(paragraphActualResult, "Крановщик шестого разряда, не выходя с работы забрал ребёнка из садика");

        // Check link
        WebElement linkActualResult = browser.findElement(By.name("link"));
        assertTrue(linkActualResult.isDisplayed());

        browser.quit();
    }
}

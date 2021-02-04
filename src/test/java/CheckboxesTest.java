import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CheckboxesTest {

    @Test
    public void checkboxesChecked() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> listOfCheckboxes = browser.findElements(By.cssSelector("[type=checkbox]"));
        WebElement firstCheckbox = listOfCheckboxes.get(0);
        WebElement secondCheckbox = listOfCheckboxes.get(1);

        assertFalse(firstCheckbox.isSelected()); // проверить, что первый чекбокс unchecked
        firstCheckbox.click(); // отметить первый чекбокс
        assertTrue(firstCheckbox.isSelected()); // проверить, что первый чекбокс checked
        assertTrue(secondCheckbox.isSelected()); // проверить, что второй чекбокс checked
        secondCheckbox.click(); // сделать второй чекбокс uncheck
        assertFalse(secondCheckbox.isSelected()); // проверить, что второй чекбокс unchecked
        browser.quit();
    }
}

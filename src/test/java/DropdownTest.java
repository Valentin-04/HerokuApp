import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DropdownTest {

    @Test
    public void dropdownChecked() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/dropdown");
        List<WebElement> listOfDropdowns = browser.findElements(By.xpath("//option")); // Взять все элементы дроп-дауна
        assertEquals(listOfDropdowns.size(), 3, "Варинтов должно быть 3, с учетом 1-го(disabled)"); // и проверить их наличие
        WebElement firstPoint = listOfDropdowns.get(1);
        WebElement secondPoint = listOfDropdowns.get(2);

        firstPoint.click(); // Выбрать первый
        assertTrue(firstPoint.isSelected()); // проверить, что он выбран
        secondPoint.click(); // выбрать второй
        assertTrue(secondPoint.isSelected()); // проверить, что он выбран
        browser.quit();
    }
}

package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class FieldMetroOrderTest {

    private WebDriver driver;

    //запуск браузера
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void
    Test() {
        MainPage mainPage = new MainPage(driver);
        //открыть браузер
        mainPage.open(Locators.BASE_URL);
        //кликнуть по кнопке Заказать
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        //кликнуть по полю Метро
        mainPage.clickButton(Locators.LOCATOR_METRO_SELECTION);
        //выбор станции метров из списка
        mainPage.clickButton(Locators.LOCATOR_METRO_STATION_SELECTION);
        //нажать на клавишу TAB на клавиатуре
        WebElement metroField = driver.findElement(Locators.LOCATOR_METRO_SELECTION);
        metroField.sendKeys(Keys.ENTER);
        assertTrue("Баг: exception", mainPage.isErrorDisplayed(Locators.NOTFOUND_LOC));

    }
}

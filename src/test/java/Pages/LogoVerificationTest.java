package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LogoVerificationTest {
    private WebDriver driver;

    //запуск браузера
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void CheckingLogoScooter() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Locators.BASE_URL);
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        mainPage.clickButton(Locators.LOGO_SCOOTER_BUTTON);
        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.NOT_FOUND_IMG_LOGO);
        assertTrue("Логотип скутера не найден, ошибка отобразилась.", errorDisplayed);
    }

    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }
}

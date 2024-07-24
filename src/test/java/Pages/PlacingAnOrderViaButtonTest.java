package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PlacingAnOrderViaButtonTest {

    private WebDriver driver;
    private final String nameUser = "Иван";
    private final String lastNameUser = "Иванов";
    private final String address = "Киров";
    private final String telephone = "89876543210";


    //запуск браузера
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //проверка кнопки Заказать внизу страницы
    @Test
    public void PlacingAnOrderViaBottomButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Locators.BASE_URL);

        mainPage.scrollToElement(2000);
        mainPage.clickButton(Locators.ORDER_BOTTOM_BUTTON);
        mainPage.fillingOutFormFields(Locators.LOCATOR_NAME_USER, Locators.LOCATOR_ACTIVE_NAME_USER, nameUser);
        mainPage.fillingOutFormFields(Locators.LOCATOR_LAST_NAME_USER, Locators.LOCATOR_ACTIVE_LAST_NAME_USER, lastNameUser);
        mainPage.fillingOutFormFields(Locators.LOCATOR_ADDRESS, Locators.LOCATOR_ACTIVE_ADDRESS, address);
        mainPage.clickButton(Locators.LOCATOR_METRO_SELECTION);
        mainPage.clickButton(Locators.LOCATOR_METRO_STATION_SELECTION);
        mainPage.fillingOutFormFields(Locators.LOCATOR_TELEPHONE, Locators.LOCATOR_ACTIVE_TELEPHONE, telephone);
        mainPage.clickButton(Locators.FURTHER_BUTTON);

        mainPage.clickButton(Locators.LOCATOR_DATA);
        mainPage.clickButton(Locators.LOCATOR_ACTIVE_DATA);
        mainPage.clickButton(Locators.LOCATOR_MONTH_SELECTION);
        mainPage.clickButton(Locators.LOCATOR_SELECTION_DATA);

        mainPage.clickButton(Locators.LOCATOR_RENTAL_PERIOD);
        mainPage.clickButton(Locators.LOCATOR_SELECTION_RENTAL_PERIOD);
        mainPage.clickButton(By.xpath(".//input[@id='grey']"));
        mainPage.fillingOutFormFields(Locators.LOCATOR_COMMIT_SELECTION, Locators.LOCATOR_COMMIT_SELECTION,
                "Это мой первый автотест на JAVA");

        mainPage.clickButton(Locators.ORDER_IN_FORM_BUTTON);

        boolean errorDisplayed = !(mainPage.isErrorDisplayed(Locators.NOT_FOUND_AFTER_PLACING_ORDER_LOCATOR));
        assertTrue("Не отработала кнопка Заказать. Не открыта форма для подтверждения заказа", errorDisplayed);
    }

    //проверка кнопки Заказать вверху страницы
    @Test
    public void PlacingAnOrderViaTopButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(Locators.BASE_URL);
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        mainPage.fillingOutFormFields(Locators.LOCATOR_NAME_USER, Locators.LOCATOR_ACTIVE_NAME_USER, nameUser);
        mainPage.fillingOutFormFields(Locators.LOCATOR_LAST_NAME_USER, Locators.LOCATOR_ACTIVE_LAST_NAME_USER, lastNameUser);
        mainPage.fillingOutFormFields(Locators.LOCATOR_ADDRESS, Locators.LOCATOR_ACTIVE_ADDRESS, address);
        mainPage.clickButton(Locators.LOCATOR_METRO_SELECTION);
        mainPage.clickButton(Locators.LOCATOR_METRO_STATION_SELECTION);
        mainPage.fillingOutFormFields(Locators.LOCATOR_TELEPHONE, Locators.LOCATOR_ACTIVE_TELEPHONE, telephone);
        mainPage.clickButton(Locators.FURTHER_BUTTON);

        mainPage.clickButton(Locators.LOCATOR_DATA);
        mainPage.clickButton(Locators.LOCATOR_ACTIVE_DATA);
        mainPage.clickButton(Locators.LOCATOR_MONTH_SELECTION);
        mainPage.clickButton(Locators.LOCATOR_SELECTION_DATA);

        mainPage.clickButton(Locators.LOCATOR_RENTAL_PERIOD);
        mainPage.clickButton(Locators.LOCATOR_SELECTION_RENTAL_PERIOD);
        mainPage.clickButton(By.xpath(".//input[@id='black']"));
        mainPage.fillingOutFormFields(Locators.LOCATOR_COMMIT_SELECTION, Locators.LOCATOR_COMMIT_SELECTION,
                "Это мой первый автотест");

        mainPage.clickButton(Locators.ORDER_IN_FORM_BUTTON);

        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.NOT_FOUND_AFTER_PLACING_ORDER_LOCATOR);
        assertTrue("Не отработала кнопка Заказать. Не открыта форма для подтверждения заказа", errorDisplayed);
    }

    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }
}

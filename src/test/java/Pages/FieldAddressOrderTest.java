package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class) //
public class FieldAddressOrderTest {
    private WebDriver driver;
    private final String address;
    boolean isValid;

    //запуск браузера
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //конструктор
    public FieldAddressOrderTest(String address, boolean isValid) {
        this.address = address;
        this.isValid = isValid;
    }

    // Метод с параметрами для теста 1
    @Parameterized.Parameters(name = "Test with city: {0}, isValid: {1}") // параметры для тестов
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Псков", true}, {"Нижний Новгород", true}, {"Омск", true}, {"Комсомольск-на-Амуре", true},
                {"Нижний Новгород", true}, {"Kirov", false}, {"К@луга", false}, {"123", false},
                {"кировввввввввввввввввввввввввввввввввввввввввввввв", false}, {"           ", false},
                {"/^*#", false}, {"М", false}
        };
    }

    @Test
    public void Test() {
        MainPage mainPage = new MainPage(driver);
        //открыть браузер
        mainPage.open(Locators.BASE_URL);
        //кликнуть по кнопке Заказать
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        //нажать и заполнить поле
        WebElement addressField = mainPage.fillingOutFormFields(Locators.LOCATOR_ADDRESS, Locators.LOCATOR_ACTIVE_ADDRESS, address);
        //нажать на клавишу TAB на клавиатуре
        addressField.sendKeys(Keys.TAB);
        //проверка отрабатывает ли валидатор, при вводе некорректного значения
        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.ERROR_MESSAGE_LOCATOR_ADDRESS);
        mainPage.clearingTheInputField(Locators.LOCATOR_ACTIVE_ADDRESS);
        if(isValid) {
            assertFalse("Ошибка должна отсутствовать для корректного адреса: " + address, errorDisplayed);
        } else {
            assertTrue("Ошибка должна присутствовать для некорректного адреса: " + address, errorDisplayed);
        }
    }

    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }

}


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

@RunWith(Parameterized.class)
public class FieldTelephoneOrderTest {
    private WebDriver driver;
    private final String telephone;
    boolean isValid;

    //конструктор
    public FieldTelephoneOrderTest(String telephone, boolean isValid) {
        this.telephone = telephone;
        this.isValid = isValid;
    }

    @Parameterized.Parameters(name = "Test with telephone: {0}, isValid: {1}") // параметры для тестов
    public static Object[] getTextData() {
        return new Object[][]{
                {"79876543210", true}, {"89876543210", true}, {"7-987-654-32-10", true},
                {"79876543210", false}, {"89876543210", false}
        };
    }

    //запуск браузера
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void
    Test() {
        MainPage mainPage = new MainPage(driver);
        //открыть браузер
        mainPage.open(Locators.BASE_URL);
        //кликнуть по кнопке Заказать
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        //нажать и заполнить поле
        WebElement nameUserField =
                mainPage.fillingOutFormFields(Locators.LOCATOR_TELEPHONE, Locators.LOCATOR_ACTIVE_TELEPHONE, telephone);
        //нажать на клавишу TAB на клавиатуре
        nameUserField.sendKeys(Keys.TAB);
        //проверка отрабатывает ли валидатор, при вводе некорректного значения
        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.ERROR_MESSAGE_LOCATOR_TELEPHONE);
        mainPage.clearingTheInputField(Locators.LOCATOR_ACTIVE_TELEPHONE);

        if (isValid) {
            assertFalse("Ошибка должна отсутствовать для корректного телефона: " + telephone, errorDisplayed);
        } else {
            assertTrue("Ошибка должна присутствовать для некорректного телефона: " + telephone, errorDisplayed);
        }
    }

    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }
}

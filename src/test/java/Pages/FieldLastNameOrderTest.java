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
public class FieldLastNameOrderTest {
    private WebDriver driver;
    private final String lastNameUser;
    boolean isValid;

    //конструктор
    public FieldLastNameOrderTest(String lastNameUser, boolean isValid) {
        this.lastNameUser = lastNameUser;
        this.isValid = isValid;
    }

    @Parameterized.Parameters(name = "Test with lastNameUser: {0}, isValid: {1}") // параметры для тестов
    public static Object[] getTextData() {
        return new Object[][]{
                {"Иванов", true}, {"иванов", true}, {"Потёмкин-Таврический", true},
                {"Ivanov", false}, {"ив@нов", false}
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
        WebElement lastNameUserField = mainPage.fillingOutFormFields(Locators.LOCATOR_LAST_NAME_USER, Locators.LOCATOR_ACTIVE_LAST_NAME_USER, lastNameUser);
        //нажать на клавишу TAB на клавиатуре
        lastNameUserField.sendKeys(Keys.TAB);
        //проверка отрабатывает ли валидатор, при вводе некорректного значения
        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.ERROR_MESSAGE_LOCATOR_LAST_NAME_USER);
        mainPage.clearingTheInputField(Locators.LOCATOR_ACTIVE_LAST_NAME_USER);

        if (isValid) {
            assertFalse("Ошибка должна отсутствовать для корректной фамилии: " + lastNameUser, errorDisplayed);
        } else {
            assertTrue("Ошибка должна присутствовать для некорректной фамилии: " + lastNameUser, errorDisplayed);
        }
    }
    //закрытие браузера
    @After
    public void after() {
        driver.quit();
    }
}

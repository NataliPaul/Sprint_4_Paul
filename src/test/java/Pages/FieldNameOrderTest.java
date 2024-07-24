package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class) //
public class FieldNameOrderTest {

    private WebDriver driver;
    private final String nameUser;
    private final boolean isValid;

    //конструктор
    public FieldNameOrderTest(String nameUser, boolean isValid) {
        this.nameUser = nameUser;
        this.isValid = isValid;
    }

    @Parameterized.Parameters(name = "Test with nameUser: {0}, isValid: {1}") // параметры для тестов
    public static Object[] getTextData() {
        return new Object[][]{
                {"Иван", true}, {"Аве Мария", true}, {"иван", true},
                {"Ivan", false}, {"Иван123", false}, {"ив@н", false}, {"         ", false}
        };
    }

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
    public void fieldNameOrderTest() {
        MainPage mainPage = new MainPage(driver);
        //открыть браузер
        mainPage.open(Locators.BASE_URL);
        //кликнуть по кнопке Заказать
        mainPage.clickButton(Locators.ORDER_TOP_BUTTON);
        //нажать и заполнить поле
        WebElement nameUserField =
                mainPage.fillingOutFormFields(Locators.LOCATOR_NAME_USER, Locators.LOCATOR_ACTIVE_NAME_USER, nameUser);
        //нажать на клавишу TAB на клавиатуре
        nameUserField.sendKeys(Keys.TAB);
        //проверка отрабатывает ли валидатор, при вводе некорректного значения
        boolean errorDisplayed = mainPage.isErrorDisplayed(Locators.ERROR_MESSAGE_LOCATOR_NAME_USER);
        mainPage.clearingTheInputField(Locators.LOCATOR_ACTIVE_NAME_USER);

        if(isValid) {
            assertFalse("Ошибка должна отсутствовать для корректного имени: " + nameUser, errorDisplayed);
        } else {
            assertTrue("Ошибка должна присутствовать для некорректного имени: " + nameUser, errorDisplayed);
        }

    }
}



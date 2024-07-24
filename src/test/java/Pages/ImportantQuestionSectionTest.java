package Pages;

import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


@RunWith(Parameterized.class) //
public class ImportantQuestionSectionTest {

    private WebDriver driver;
    //локатор пункта списка вопросов о важном
    private final By numberQuestion;
    //локатор пункта ответа на вопрос о важном
    private final By textQuestion;
    //текс для проверки соответствия ответов на вопрос о важном
    private final String textForCheck;

    //конструктор
    public ImportantQuestionSectionTest(By numberQuestion, By textQuestion, String textForCheck) {
        this.numberQuestion = numberQuestion;
        this.textQuestion = textQuestion;
        this.textForCheck = textForCheck;
    }

    @Parameterized.Parameters // параметры для тестов
    public static Object[][] getTextData() {
        return new Object[][]{
                {By.xpath(".//div[@id='accordion__heading-0']"),
                    By.xpath(".//div[@id='accordion__panel-0']"),
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.xpath(".//div[@id='accordion__heading-1']"),
                    By.xpath(".//div[@id='accordion__panel-1']"),
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                                "можете просто сделать несколько заказов — один за другим."},
                {By.xpath(".//div[@id='accordion__heading-2']"),
                    By.xpath(".//div[@id='accordion__panel-2']"),
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.xpath(".//div[@id='accordion__heading-3']"),
                    By.xpath(".//div[@id='accordion__panel-3']"),
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.xpath(".//div[@id='accordion__heading-4']"),
                    By.xpath(".//div[@id='accordion__panel-4']"),
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
                                "поддержку по красивому номеру 1010."},
                {By.xpath(".//div[@id='accordion__heading-5']"),
                    By.xpath(".//div[@id='accordion__panel-5']"),
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь " +
                                "суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.xpath(".//div[@id='accordion__heading-6']"),
                    By.xpath(".//div[@id='accordion__panel-6']"),
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
                                "записки тоже не попросим. Все же свои."},
                {By.xpath(".//div[@id='accordion__heading-7']"),
                    By.xpath(".//div[@id='accordion__panel-7']"),
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
    public void checkQuestionsSection() {
        MainPage mainPage = new MainPage(driver);
        //открыть браузер
        mainPage.open(Locators.BASE_URL);
        //прокрутить до раздела вопросы о главном
        mainPage.scrollToElement(2500);
        //кликнуть по соответствующему вопросу
        mainPage.clickButton(numberQuestion);
        //сравнить тест ответа на вопрос
        mainPage.checkTestInQuestionSection(textQuestion, textForCheck);

    }

}

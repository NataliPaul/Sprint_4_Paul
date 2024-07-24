package Pages;

import org.openqa.selenium.By;

public class Locators {

    static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    //кнопка Заказать до входа в форму вверху страницы
    static final By ORDER_TOP_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //кнопка Заказать до входа в форму внизу страницы
    static final By ORDER_BOTTOM_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Далее в форме Заказать
    static final By FURTHER_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Назад в форме Заказать - еще не использовала (не успела)
    //static final By BACK_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    //кнопка Заказать в форме
    static final By ORDER_IN_FORM_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //кнопка подтверждения заказа ДА (кнопка не отрабатывает в Chrome)
    static final By ORDER_CONFIRMATION_IN_FORM_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']" +
            "/div[@class='Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка логотипа Самокат
    static final By LOGO_SCOOTER_BUTTON = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");

    //для поля Имя
    //поле ввода имя
    static final By LOCATOR_NAME_USER =
            By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //поле ввода имени после выделения
    static final By LOCATOR_ACTIVE_NAME_USER =
            By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //ошибка при вводе некорректного значения
    static final By ERROR_MESSAGE_LOCATOR_NAME_USER = By.xpath(".//div[text()='Введите корректное имя']");

    //для поля Фамилия
    //поле ввода Фамилия
    static final By LOCATOR_LAST_NAME_USER =
           By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    //поле ввода фамилии, после клика по нему
    static final By LOCATOR_ACTIVE_LAST_NAME_USER =
            By.xpath(".//input[@placeholder='* Фамилия']");
    //ошибка при вводе некорректного значения
    static final By ERROR_MESSAGE_LOCATOR_LAST_NAME_USER =
            By.xpath(".//div[text()='Введите корректную фамилию']");

    //для поля адрес
    //поле ввода адреса
    static final By LOCATOR_ADDRESS =
           By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    //поле ввода адреса, после клика по нему
    static final By LOCATOR_ACTIVE_ADDRESS =
            By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //ошибка при вводе некорректного значения
    static final By ERROR_MESSAGE_LOCATOR_ADDRESS =
            By.xpath(".//div[text()='Введите корректный адрес']");

    //для поля метро
    //поле ввода метро
    static final By LOCATOR_METRO_SELECTION = By.xpath(".//input[@class='select-search__input']");
    //поле ввода метро, после клика по нему
    static final By LOCATOR_METRO_STATION_SELECTION = By.xpath(".//li[@data-index='16']");
    //для проверки бага
    public static final By NOTFOUND_LOC = By.xpath(".//div[@class='Order_Header__BZXOb']");

    //для поля телефона
    //поле ввода телефона
    static final By LOCATOR_TELEPHONE =
           By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN'" +
                   " and @placeholder='* Телефон: на него позвонит курьер']");
    //поле ввода телефона, после клика по нему
    static final By LOCATOR_ACTIVE_TELEPHONE =
            By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //ошибка при вводе некорректного значения
    static final By ERROR_MESSAGE_LOCATOR_TELEPHONE =
            By.xpath(".//div[text()='Введите корректный номер']");

    //для поля Когда привезти самокат
    static final By LOCATOR_DATA =
           By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле ввода телефона, после клика по нему
    static final By LOCATOR_ACTIVE_DATA =
            By.xpath(".//input[@class='Input_Input__1iN_Z " +
                    "Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside']");
    //кнопка перехода на другой месяц (вперед)
    static final By LOCATOR_MONTH_SELECTION =
            By.xpath(".//button[@class='react-datepicker__navigation " +
                    "react-datepicker__navigation--next']");
    //выбор даты в календаре (25.08.2024)
    static final By LOCATOR_SELECTION_DATA =
            By.xpath("//div[@class = 'react-datepicker__day " +
                    "react-datepicker__day--025 react-datepicker__day--weekend']");

    //для поля Срок аренды
    static final By LOCATOR_RENTAL_PERIOD =
           By.xpath(".//div[@class='Dropdown-placeholder']");
    //поле Срок аренды, после клика по нему (пока не использовала)
    //static final By LOCATOR_ACTIVE_RENTAL_PERIOD =
            //By.xpath(".//div[@class='Dropdown-root is-open']");
    //выбор срока аренды (4 суток)
    static final By LOCATOR_SELECTION_RENTAL_PERIOD =
            By.xpath(".//div[text()='четверо суток']");

    //для поля Комментарий для курьера
    //поле ввода комментария
    static final By LOCATOR_COMMIT_SELECTION =
            By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    //для проверки бага подтверждения заказа (страница подтверждения заказа)
    public static final By NOT_FOUND_AFTER_PLACING_ORDER_LOCATOR
            = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //для проверки перехода на главную страницу
    public static final By NOT_FOUND_IMG_LOGO
            = By.xpath(".//div[@class='Home_Header__iJKdX']");

}

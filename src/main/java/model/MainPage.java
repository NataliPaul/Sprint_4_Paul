package model;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод открытия страницы браузера
    public void open(String url) {
        driver.get(url);
    }

    //метод скролла страницы до раздела вопросы о главном
    public void scrollToElement(int pixel) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", pixel);
    }

    //метод клик по кнопке
    public void clickButton(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //метод сравнения ответа на странице фактическому
    public void checkTestInQuestionSection(By locator, String textForCheck) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, textForCheck));
            System.out.println("Текст элемента соответствует ожидаемому: " + textForCheck);
        } catch (Exception e) {
            System.err.println("Текст элемента не соответствует ожидаемому: " + textForCheck);
            throw new AssertionError("Текст элемента не соответствует ожидаемому: " + textForCheck);
        }
    }

    //метод заполнение полей
    public WebElement fillingOutFormFields(By locator, By locator1, String inputOption) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        WebElement inputElement = driver.findElement(locator1);
        inputElement.sendKeys(inputOption);
        return inputElement;
    }

    //метод очистки полей
    public void clearingTheInputField(By locator) {
        driver.findElement(locator).clear();
    }

    //проверка видимости элемента
    public boolean isErrorDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement notFound = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return notFound.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


}

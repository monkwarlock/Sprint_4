package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.util.EnvConfig;


import java.time.Duration;

public class MainPage {
    //Конопка Статус заказа
    private final By orderStatusButton = By.cssSelector(".Header_Link__1TAG7");
    //Поле номер заказа
    private final By orderNumberField = By.cssSelector(".Input_Input__1iN_Z.Header_Input__xIoUq");
    //Кнопка Go!
    private final By goButton = By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO");
    //Кнопка заказать в шапке
    private final By orderButton = By.cssSelector("Button[class='Button_Button__ra12g']");
    //Кнопка заказать внизу страницы
    private final By bottomOrderButtonIn = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Кнопка подтверждения куки
    private final By cookieButton = By.cssSelector(".App_CookieButton__3cvqF");
    //Локатор вопроса
    private By questionLocator(String index) {
        return By.cssSelector(("#accordion__heading-" + index));
    }
    //Локатор ответа
    private By answerLocator(String index) {
        return By.cssSelector("#accordion__panel-" + index + " p");
    }

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажатие кнопки Заказать вверху страницы
    public OrderPage openOrderPage() {
        //Поиск и нажатие кнопки куки
        WebElement button = driver.findElement(cookieButton);
        if (button.isDisplayed()) {
            button.click();
        }
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }

    //Нажатие кнопки Заказать внизу страницы
    public OrderPage clickOnBottomOrderButton() {
        //Поиск и нажатие кнопки куки
        WebElement button = driver.findElement(cookieButton);
        if (button.isDisplayed()) {
            button.click();
        }
        //Прокручиваем в видимую область кнопку заказать и нажимаем на неё
        WebElement orderBottomButton = driver.findElement(bottomOrderButtonIn);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", orderBottomButton);
        orderBottomButton.click();
        return new OrderPage(driver);
    }

    //Нажатие на стрелки возле вопроса в FAQ
    public void clickOnFAQ(EnvConfig data) {
        //Находим вопрос и кликаем на него
        WebElement question = driver.findElement(questionLocator(data.getIndex()));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", question);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(questionLocator(data.getIndex())));
        question.click();
    }

    //Проверка, что отобразился соответствующий ответ
    public void checkAnswer(EnvConfig data){
        //Проверяем, что после раскрытия вопроса, появился соответствующий текст ответа
        WebElement answer = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator(data.getIndex())));
        assert answer != null;
        String expectedAnswerText = data.getAnswer();
        String currentAnswerText = answer.getText();
        Assert.assertEquals("Текст ответа не соответствует ожидаемому", expectedAnswerText, currentAnswerText);
    }

    //Нажатие кнопки статус заказа на главной странице
    public void clickOnStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    //ВВод номера заказа в поле Номер заказа
    public void enterOrderIn(String orderNumber) {
        driver.findElement(orderNumberField).sendKeys(orderNumber);
    }

    //Ожидание кликабельности кнопки Go!
    public StatusPage clickOnGoButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(goButton));
        //Нажатие кнопки Go!
        driver.findElement(goButton).click();
        return new StatusPage(driver);
    }
}
package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.time.Duration;
import java.util.Set;

public class OrderPage {
    //Логотип сервиса Самокат
    private final By logoScooter = By.cssSelector(".Header_LogoScooter__3lsAR");
    //Логотип сервиса Самокат
    private final By logoYandex = By.cssSelector(".Header_LogoYandex__3TSOI");
    //Поле Имя
    private final By nameField = By.cssSelector("input[placeholder='* Имя'].Input_Input__1iN_Z");
    //Поле Фамилия
    private final By lastNameField = By.cssSelector("input[placeholder='* Фамилия'].Input_Input__1iN_Z");
    //Поле Адрес
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ'].Input_Input__1iN_Z");
    //Поле Станция метро
    private final By metroStationField = By.cssSelector(".select-search__input");
    //Поле телефон
    private final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер'].Input_Input__1iN_Z");
    //Кнопка Далее
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Поле Дата доставки
    private final By deliveryDateField = By.cssSelector("input[placeholder='* Когда привезти самокат'].Input_Input__1iN_Z");
    //Поле Срок аренды
    private final By rentalPeriodField = By.cssSelector(".Dropdown-control");
    //Чек-бокс Черный жемчуг
    private final By blackPearl = By.cssSelector("#black.Checkbox_Input__14A2w");
    //Поле Комментарий для курьера
    private final By commentForCourier = By.cssSelector("input[type='text'].Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']");
    //Кнопка Заказать, после введения данных
    private final By orderButtonInOrder = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка Да
    private final By yesButton = By.xpath("//button[ contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Да' ]");
    //Окно заказ оформлен
    private final By orderCompleted = By.xpath("//div[ contains(@class, 'Order_ModalHeader__3FDaJ') and text()='Заказ оформлен' ]");

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение первой страницы формы заказа
    public void fillOrderForm1(EnvConfig data) {
        driver.findElement(nameField).sendKeys(data.firstName);
        driver.findElement(lastNameField).sendKeys(data.lastName);
        driver.findElement(addressField).sendKeys(data.address);
        driver.findElement(metroStationField).sendKeys(data.metroStation);
        driver.findElement(By.xpath(String.format("//button[contains(., '%s')]", data.metroStation))).click();
        driver.findElement(phoneNumberField).sendKeys(data.phone);
    }

    //Нажатие кнопки Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Заполнение второй страницы формы заказа
    public void fillOrderForm2 (EnvConfig data) {
        driver.findElement(deliveryDateField).sendKeys(data.deliveryDate, Keys.ENTER);
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-option' and contains(text(), '%s')]", data.rentalPeriod))).click();
        driver.findElement(blackPearl).click();
        driver.findElement(commentForCourier).sendKeys(data.comment);
    }

    //Подтверждение заказа и проверка, что окно подтверждения появляется
    public void checkClickEndOrderButton() {
        driver.findElement(orderButtonInOrder).click();
        driver.findElement(yesButton).click();
        //Проверка, что появилось всплывающее окно с сообщением об успешном создании заказа
        Assert.assertTrue(driver.findElement(orderCompleted).isDisplayed());
    }

    //Нажатие логотипа Самокат со страницы оформления заказа
    // и переход на главную страницу сервиса
    public void checkOpeningTheMainPageViaTheClickLogo(){
        driver.findElement(logoScooter).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = EnvConfig.BASE_URL;
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, currentUrl);
    }

    //Нажатие логотипа Yandex со страницы оформления заказа
    // и переход на главную страницу сервиса
    public void checkOpeningTheMainYandexViaTheClickLogo(){
        //Запоминаем текущую вкладку
        String currentTab = driver.getWindowHandle();
        //Нажимаем на лого Яндекс
        driver.findElement(logoYandex).click();
        //Получаем все открытые вкладки
        Set<String> allTabs = driver.getWindowHandles();
        //Находим новую вкладку
        String newTab = null;
        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) {
                newTab = tab;
                break;
            }
        }
        if (newTab == null) {
            throw new RuntimeException("Новая вкладка не найдена!");
        }
        //Переключаемся на новую вкладку
        driver.switchTo().window(newTab);
        //Ждем когда страница загрузится
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            String result = (String) js.executeScript(
                    ("return document.readyState"));
                    assert result != null;
                    return result.equals("complete");
        });
        //Проверяем совпадение URL
        String expectedUrl = EnvConfig.YANDEX_URL;
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, currentUrl);
    }
}
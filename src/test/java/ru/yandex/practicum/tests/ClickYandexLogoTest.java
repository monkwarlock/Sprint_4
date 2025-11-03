package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

public class ClickYandexLogoTest {
    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    //Если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    @Test
    public void testClickLogoAndGoToTheMainYandexPage() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.openOrderPage();
        //Открытие главной страницы Яндекса кликом по лого и проверка, что главная страница открылась
        orderPage.checkOpeningTheMainYandexViaTheClickLogo();
        //Открывается Дзен вместо Яндекса при нажатии на лого Яндекс
    }
}
package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

public class ClickLogoTest {
    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    //Если нажать на логотип Самоката, попадёшь на главную страницу Самоката.
    @Test
    public void testClickLogoAndGoToTheMainPage() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.openOrderPage();
        //Открытие главной страницы сервиса кликом по лого и проверка, что главная страница открылась
        orderPage.checkOpeningTheMainPageViaTheClickLogo();
    }
}
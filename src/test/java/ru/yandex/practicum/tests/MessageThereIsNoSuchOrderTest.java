package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.StatusPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

public class MessageThereIsNoSuchOrderTest {
    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    //Если ввести неправильный номер заказа, попадёшь на страницу статуса заказа.
    //На ней должно быть написано, что такого заказа нет.
    @Test
    public void testNonExistingOrderNotFound() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.clickOnStatusButton();
        mainPage.enterOrderIn("12345");
        StatusPage statusPage = mainPage.clickOnGoButton();
        statusPage.checkErrorMessage();
    }
}
package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    public EnvConfig data;

    public OrderScooterTest(EnvConfig data) {
        this.data = data;
    }

    @Parameterized.Parameters
    public static Collection<EnvConfig> provideData() {
        return EnvConfig.getTestData();
    }

    @Test //Заказ самоката через верхнюю кнопку
    public void testOrderScooterThroughTheTopButton() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.openOrderPage();
        orderPage.fillOrderFormFirstPage(data);
        orderPage.clickNextButton();
        orderPage.fillOrderFormSecondPage(data);
        orderPage.checkClickEndOrderButton();
        //В хроме не кликается кнопка да
    }

    @Test //Заказ самоката через нижнюю кнопку
    public void testOrderScooterThroughTheBottomButton() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.clickOnBottomOrderButton();
        orderPage.fillOrderFormFirstPage(data);
        orderPage.clickNextButton();
        orderPage.fillOrderFormSecondPage(data);
        orderPage.checkClickEndOrderButton();
        //В хроме не кликается кнопка да
    }
}
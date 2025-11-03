package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.time.Duration;

public class StatusPage {
    //Сообщение об ошибке
    private final By errorImg = By.cssSelector("img[alt='Not found']");

    private final WebDriver driver;

    public StatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkErrorMessage() {
        //Ожидание отображения сообщения на странице
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(errorImg));
        //Проверка отображения сообщения Такого заказа нет
        Assert.assertTrue(driver.findElement(errorImg).isDisplayed());
    }
}
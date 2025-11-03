package ru.yandex.practicum.pages.util;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory extends ExternalResource {
    private WebDriver driver;
    public String baseUrl;

    public DriverFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void initDriver(){
        if ("firefox".equals(System.getProperty("browser"))) {
            stertFirefox();
        } else {
            startChrome();
        }
        driver.get(baseUrl);
    }

    private void startChrome() {
        driver = new ChromeDriver();
        //Создание неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMPLICITY_TIMEOUT));
        driver.manage().window().maximize();
    }

    private void stertFirefox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMPLICITY_TIMEOUT));
        driver.manage().window().maximize();
    }

    @Override
    protected void before(){
        initDriver();
    }

    protected void after(){
        driver.quit();
    }
}
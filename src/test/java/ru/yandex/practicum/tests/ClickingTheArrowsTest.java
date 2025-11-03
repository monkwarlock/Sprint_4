package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

public class ClickingTheArrowsTest {
    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    //Выпадающий список в разделе «Вопросы о важном».
    //Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
    @Test
    public void testClickOnListOfImportantQuestions() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        //Прокликивание всех стрелок и проверка, что все стрелки раскрылись
        mainPage.checkClickOnListOfImportantQuestions();
    }
}
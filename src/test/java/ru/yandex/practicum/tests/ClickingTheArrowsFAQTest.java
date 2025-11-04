package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.util.DriverFactory;
import ru.yandex.practicum.pages.util.EnvConfig;

import java.util.Collection;

@RunWith(Parameterized.class)
public class ClickingTheArrowsFAQTest {
    @Rule
    public DriverFactory factory = new DriverFactory(EnvConfig.BASE_URL);

    public EnvConfig data;

    public ClickingTheArrowsFAQTest(EnvConfig data) {
        this.data = data;
    }

    @Parameterized.Parameters
    public static Collection<EnvConfig> textData() {
        return EnvConfig.getQuestionAndAnswerText();
    }

    //Выпадающий список в разделе «Вопросы о важном».
    //Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
    @Test
    public void testClickOnListOfImportantQuestions() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        //Прокликивание вопросов и проверка, что текст вопроса
        // и текст ответа соответствует ожидаемому
        mainPage.checkClickOnFAQ(data);
        //В последнем вопросе опечатка. Написано "Я жизу ...", должно быть "Я живу ..."
    }
}
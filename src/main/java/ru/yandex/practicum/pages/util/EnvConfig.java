package ru.yandex.practicum.pages.util;

import java.util.Arrays;
import java.util.List;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final int IMPLICITY_TIMEOUT = 15;
    public static final int EXPLICITY_TIMEOUT = 15;
    public static final String YANDEX_URL = "https://ya.ru/";

    public String firstName;
    public String lastName;
    public String address;
    public String metroStation;
    public String phone;
    public String deliveryDate;
    public String comment;
    public String rentalPeriod;

    public EnvConfig(String firstName, String lastName, String address,
                    String metroStation, String phone, String deliveryDate,
                     String rentalPeriod, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.rentalPeriod = rentalPeriod;
    }

    public static List<EnvConfig> getTestData() {
        return Arrays.asList(
                new EnvConfig("Ян", "Ли", "ул. Ленина, д. 15, кв. 3", "Пушкинская",
                        "+79991234567", "18.08.2025", "сутки", "Оставить у двери"),
                new EnvConfig("Абдурахмангаджи", "Семипополовигероверсалофедираковский", "ул Ленина, д 15, кв 3",
                        "Тверская", "84951234567", "01.12.25", "четверо суток", "")
        );
    }

    public String questionId;
    public String questionText;
    public String answerId;
    public String answerText;

    public EnvConfig(String questionId, String questionText, String answerId, String answerText){
        this.questionId = questionId;
        this.questionText = questionText;
        this.answerId = answerId;
        this.answerText = answerText;
    }

    public static List<EnvConfig> getQuestionAndAnswerText(){
        return Arrays.asList(
                new EnvConfig("accordion__heading-0", "Сколько это стоит? И как оплатить?", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                new EnvConfig("accordion__heading-1", "Хочу сразу несколько самокатов! Так можно?", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                new EnvConfig("accordion__heading-2", "Как рассчитывается время аренды?", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                new EnvConfig("accordion__heading-3", "Можно ли заказать самокат прямо на сегодня?", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                new EnvConfig("accordion__heading-4", "Можно ли продлить заказ или вернуть самокат раньше?", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                new EnvConfig("accordion__heading-5", "Вы привозите зарядку вместе с самокатом?", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                new EnvConfig("accordion__heading-6", "Можно ли отменить заказ?", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                new EnvConfig("accordion__heading-7", "Я живу за МКАДом, привезёте?", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }
}
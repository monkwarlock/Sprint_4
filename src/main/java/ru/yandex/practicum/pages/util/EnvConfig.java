package ru.yandex.practicum.pages.util;

import java.util.Arrays;
import java.util.List;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final int IMPLICITY_TIMEOUT = 7;
    public static final int EXPLICITY_TIMEOUT = 7;
    public static final String YANDEX_URL = "https://ya.ru/";

    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private String deliveryDate;
    private String comment;
    private String rentalPeriod;

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

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getMetroStation() {
        return metroStation;
    }
    public String getPhone() {
        return phone;
    }
    public String getDeliveryDate() {
        return deliveryDate;
    }
    public String getComment() {
        return comment;
    }
    public String getRentalPeriod() {
        return rentalPeriod;
    }

    private static final List<EnvConfig> testData = Arrays.asList(
                new EnvConfig("Ян", "Ли", "ул. Ленина, д. 15, кв. 3", "Пушкинская",
                        "+79991234567", "18.08.2025", "сутки", "Оставить у двери"),
                new EnvConfig("Абдурахмангаджи", "Семипополовигероверсалофедираковский", "ул Ленина, д 15, кв 3",
                        "Тверская", "84951234567", "01.12.25", "четверо суток", "")
        );

    public static List<EnvConfig> getTestData() {
        return testData;
    }

    private String index;
    private String answerText;

    public EnvConfig(String index, String answerText) {
        this.index = index;
        this.answerText = answerText;
    }

    public String getIndex(){
        return index;
    }
    public String getAnswer(){
        return answerText;
    }

    private static final List<EnvConfig> content = Arrays.asList(
            new EnvConfig(
                    "0",
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
            ),
            new EnvConfig(
                    "1",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
            ),
            new EnvConfig(
                    "2",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
            ),
            new EnvConfig(
                    "3",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
            ),
            new EnvConfig(
                    "4",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
            ),
            new EnvConfig(
                    "5",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
            ),
            new EnvConfig(
                    "6",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
            ),
            new EnvConfig(
                    "7",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."
            )
    );

    public static List<EnvConfig> getContent() {
        return content;
    }
}
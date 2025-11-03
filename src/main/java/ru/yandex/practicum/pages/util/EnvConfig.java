package ru.yandex.practicum.pages.util;

import java.util.Arrays;
import java.util.List;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final int IMPLICITY_TIMEOUT = 5;
    public static final int EXPLICITY_TIMEOUT = 5;
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
}
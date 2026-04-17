package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
// скоропортящаяся посылка
    private final int timeToLive;
    private static final int KOEF_FOR_PL = 3;

    public PerishableParcel(int weight, String description, String deliveryAddress, int sendDay, int timeToLive) {
        super(weight, description, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    /* метод isExpired
    вход currentDay - номер текущего дня
    sendDay + timeToLive >= currentDay - возвращаем false(посылка не испортилась)
    else - true(посылка испортилась)
     */
}

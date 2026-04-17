package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
// скоропортящаяся посылка
    private final int timeToLive;
    private static final int KOEF_FOR_PL = 3;

    public PerishableParcel(int weight, String description, String deliveryAddress, int sendDay, int timeToLive) {
        super(weight, description, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int tariff() {
        return KOEF_FOR_PL;
    }

    public boolean isExpired(int currentDay) {
        if ((getSendDay() + timeToLive) >= currentDay) {
            return false;//посылка не испортилась
        } else {
            return true;//посылка испортилась
        }
    }
}

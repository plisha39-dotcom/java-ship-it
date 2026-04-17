package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int KOEF_FOR_STD = 2;

    public StandardParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }

    @Override
    public int tariff() {
        return KOEF_FOR_STD;
    }
}

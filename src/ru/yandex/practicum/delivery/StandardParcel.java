package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }
}

package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
// хрупкая посылка
    public FragileParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }
}

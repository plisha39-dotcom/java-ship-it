package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
// хрупкая посылка
    private static final int KOEF_FOR_FRAG = 4;

    public FragileParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }
}

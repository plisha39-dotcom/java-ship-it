package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;
    public Parcel(int weight, String description, String deliveryAddress, int sendDay) {
        this.weight = weight;
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        // посылка *** упакована
    }

    public void deliver() {
        // посылка *** упакована и доставлена по адресу ***
    }

    public int calculateDeliveryCost() {
        // вес посылки * базовая стоимость (2-стандартная посылка
                                        //  3-скоропортящаяся посылка
                                        //  4-хрупкая посылка)
    }
}

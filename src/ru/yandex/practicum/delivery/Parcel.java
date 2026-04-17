package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    private static final int KOEF_FOR_STD = 2;
    private static final int KOEF_FOR_PL = 3;
    private static final int KOEF_FOR_FRAG = 4;

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

    public void calculateDeliveryCost() {
        // вес посылки * базовая стоимость (2-стандартная посылка
                                        //  3-скоропортящаяся посылка
                                        //  4-хрупкая посылка)
    }
}

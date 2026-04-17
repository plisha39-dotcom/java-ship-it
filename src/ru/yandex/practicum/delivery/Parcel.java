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
        System.out.println("Посылка " + description + " упакована.");
        // посылка *** упакована
    }

    public void deliver() {
        System.out.println("Посылка " + description + " упакована и доставлена по адресу: " + deliveryAddress);
        // посылка *** упакована и доставлена по адресу ***
    }

    public int calculateDeliveryCost() {
        int cost = weight * tarif();
        return cost;
        // вес посылки * базовая стоимость (2-стандартная посылка
                                        //  3-скоропортящаяся посылка
                                        //  4-хрупкая посылка)
    }

    public abstract int tarif();

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }
}

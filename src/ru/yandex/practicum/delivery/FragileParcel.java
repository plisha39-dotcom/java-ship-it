package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
// хрупкая посылка
    private static final int KOEF_FOR_FRAG = 4;

    public FragileParcel(int weight, String description, String deliveryAddress, int sendDay) {
        super(weight, description, deliveryAddress, sendDay);
    }

    @Override
    public int tariff() {
        return KOEF_FOR_FRAG;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обернута в защитную пленку.");
        System.out.println("Посылка " + getDescription() + " упакована.");
    }
}

package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final ArrayList<T> parcels = new ArrayList<>();
    private final int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        int sumWeight = 0;
        for (T oneParcel : parcels) {
            sumWeight += oneParcel.getWeight();
        }
        sumWeight += parcel.getWeight();
        if (sumWeight <= maxWeight) {
            parcels.add(parcel);
        } else {
            System.out.println("Превышен вес, посылка не добавлена!");
        }
    }

    public List<T> getAllParcels() {
        return parcels;
    }
}

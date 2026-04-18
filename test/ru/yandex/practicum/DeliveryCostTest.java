package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryCostTest {

    @Test
    public void shouldCalculateStandardParcelCost() {
        StandardParcel standardParcel = new StandardParcel(5, "Test", "Russia", 1);
        int price = standardParcel.calculateDeliveryCost();
        int expected = 10;
        assertEquals(expected, price);
    }

    @Test
    public void shouldCalculateFragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel(5, "Test", "Russia", 1);
        int price = fragileParcel.calculateDeliveryCost();
        int expected = 20;
        assertEquals(expected, price);
    }

    @Test
    public void shouldCalculatePerishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel(5, "Test", "Russia", 1, 1);
        int price = perishableParcel.calculateDeliveryCost();
        int expected = 15;
        assertEquals(expected, price);
    }

    @Test
    public void shouldReturnZeroCostWhenWeightZero() {
        StandardParcel standardParcel = new StandardParcel(0, "Test", "Russia", 1);
        int price = standardParcel.calculateDeliveryCost();
        int expected = 0;
        assertEquals(expected, price);
    }

    @Test
    public void shouldReturnFalseWhenCurrentDayEqualsExpirationDay() {
        PerishableParcel perishableParcel = new PerishableParcel(5,"Test", "Russia", 5, 5);
        int currentDay = 10;
        boolean result = perishableParcel.isExpired(currentDay);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenParcelIsNotExpired() {
        PerishableParcel perishableParcel = new PerishableParcel(5,"Test", "Russia", 5, 5);
        int currentDay = 5;
        boolean result = perishableParcel.isExpired(currentDay);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenParcelIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel(5,"Test", "Russia", 5, 5);
        int currentDay = 11;
        boolean result = perishableParcel.isExpired(currentDay);
        assertTrue(result);
    }

    @Test
    public void shouldAddParcelWhenWeightLimitIsNotExceeded() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel(5, "Test", "Russia", 1);
        boolean result = parcelBox.addParcel(standardParcel);
        assertTrue(result);
        assertEquals(1, parcelBox.getAllParcels().size());
    }

    @Test
    public void shouldAddParcelWhenWeightEqualsLimit() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel(5, "Test", "Russia", 1);
        StandardParcel standardParcel1 = new StandardParcel(5, "Test2", "Usa", 2);
        boolean result = parcelBox.addParcel(standardParcel);
        boolean result1 = parcelBox.addParcel(standardParcel1);
        assertTrue(result);
        assertTrue(result1);
        assertEquals(2, parcelBox.getAllParcels().size());
    }

    @Test
    public void shouldNotAddParcelWhenWeightLimitIsExceeded() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel(6, "Test", "Russia", 1);
        StandardParcel standardParcel1 = new StandardParcel(8, "Test2", "Usa", 2);
        boolean result = parcelBox.addParcel(standardParcel);
        boolean result1 = parcelBox.addParcel(standardParcel1);
        assertTrue(result);
        assertFalse(result1);
        assertEquals(1, parcelBox.getAllParcels().size());
    }
}

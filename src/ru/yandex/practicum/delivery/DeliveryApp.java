package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Trackable> trackables = new ArrayList<>();
    private static final ParcelBox<StandardParcel> stdParcelBox = new ParcelBox<>(10);
    private static final ParcelBox<FragileParcel> fragParcelBox = new ParcelBox<>(10);
    private static final ParcelBox<PerishableParcel> plParcelBox = new ParcelBox<>(10);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - стандартная посылка");
        System.out.println("2 - скоропортящаяся посылка");
        System.out.println("3 - хрупкая посылка");
        int typeParcel = scanner.nextInt();
        scanner.nextLine();
        if (typeParcel != 1 && typeParcel != 2 && typeParcel != 3) {
            System.out.println("Неправильный ввод");
            return;
        }

        System.out.println("Введите название посылки:");
            String description = scanner.nextLine();
        System.out.println("Введите вес посылки:");
            int weight = scanner.nextInt();
            scanner.nextLine();
        System.out.println("Введите адрес доставки:");
            String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправки");
            int sendDay = scanner.nextInt();

        switch (typeParcel) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(weight, description, deliveryAddress,sendDay);
                stdParcelBox.addParcel(standardParcel);
                break;
            case 2:
                System.out.println("Введите срок годности:");
                int timeToLive = scanner.nextInt();
                PerishableParcel perishableParcel = new PerishableParcel(weight, description, deliveryAddress, sendDay, timeToLive);
                plParcelBox.addParcel(perishableParcel);
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(weight, description, deliveryAddress, sendDay);
                if (fragParcelBox.addParcel(fragileParcel)) {
                    trackables.add(fragileParcel);
                }
                    break;
        }
        scanner.nextLine();
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
    }
}


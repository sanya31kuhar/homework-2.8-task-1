import sun.rmi.transport.Transport;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static <E> void main(String[] args) {

        Mechanic<Car> ivan = new Mechanic<Car>("Иван", "Иванов", " Cobra");
        Sponsor gazprom = new Sponsor("Газпром", 5_000_000);
        Sponsor bridgestone = new Sponsor("Бриджстоун", 3_000_000);

        Mechanic<Truck> andrey = new Mechanic<Truck>("Андрей", "Портнов", "Vulkan");
        Sponsor belrus = new Sponsor("Белрус", 2_000_000);

        Mechanic<Bus> denis = new Mechanic<Bus>("Денис", "Патов", " Luna");
        Sponsor lukoyl = new Sponsor("Лукойл", 3_500_000);
        Sponsor sber = new Sponsor("Сбер", 1_500_000);

        Car car = new Car("Lada", "Granta", 1.7, TypeOfBody.SEDAN);
        DriverB anton = new DriverB("Антон", 'B', 5, car);
        car.addMechanic(ivan);
        car.addSponsor(gazprom, bridgestone);
        System.out.println(car.toString());

        Truck truck = new Truck("Валдай", "NEXT", 7.0, LoadCapasity.N2);
        DriverC platon = new DriverC("Платон", 'C', 3, truck);
        truck.addMechanic(andrey);
        truck.addSponsor(belrus);
        System.out.println(truck.toString());

        Bus bus = new Bus("IKARUS", "417", 3.8, TypeOfCapacity.VERY_BIG);
        DriverD simon = new DriverD("Саймон", 'D', 4, bus);
        bus.addMechanic(andrey);
        bus.addSponsor(lukoyl, sber);
        System.out.println(bus.toString());

        diagnostics(car, truck, bus);

        Set<Transport> transports = new HashSet<>();
        transports.add(car);
        transports.add(truck);
        transports.add(bus);

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(car);
        serviceStation.addTruck(truck);
        serviceStation.diagnostics();
        serviceStation.diagnostics();


        for (Transport transport : transports) {
            printInfo(transport);
        }
    }

    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю:" + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водители:" + transport.getDrivers());
        System.out.println("Спонсоры:" + transport.getSponsors());
        System.out.println("Механики:" + transport.getMechanics());
        System.out.println();
    }

    private static void diagnostics(Car car, Truck truck, Bus bus, Transport... transports) {
        for (Transport transport : transports) {
            diagnosticsTransport(transport);
        }
    }

    private static void diagnosticsTransport(Transport transport) {
        try {
            if (!transport.diagnostics()) {
                throw new RuntimeException("Автомобиль " + transport.getBrand() + " " + transport.getModel() + " не прошел диагностику");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}


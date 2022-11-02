import sun.rmi.transport.Transport;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Mechanic<Car> ivan = new Mechanic<Car>("Иван", "Иванов", " Cobra");
        Sponsor gazprom = new Sponsor("Газпром", 5_000_000);
        Sponsor bridgestone = new Sponsor("Бриджстоун", 3_000_000);

        Mechanic<Truck> andrey = new Mechanic<Truck>("Андрей", "Портнов", "Vulkan");
        Sponsor belrus = new Sponsor("Белрус", 2_000_000);

        Mechanic<Bus> denis = new Mechanic<Bus>("Денис", "Патов", " Luna");
        Sponsor lukoyl = new Sponsor("Лукойл", 3_500_000);
        Sponsor sber = new Sponsor("Сбер", 1_500_000);


        Car car = new Car("Lada", "Granta", 1.7, TypeOfBody.SEDAN);
        car.addDriver(new DriverB("Антон", 'B', 5, car));
        car.addMechanic(ivan);
        car.addSponsor(gazprom, bridgestone);
        System.out.println(car.toString());

        //Car car1 = new Car("Audi", "A8 50 L TDI quattro", 3.0, TypeOfBody.COUPE);
        // System.out.println(car1.toString());

        //Car car2 = new Car("BMW", "Z8", 3.0, TypeOfBody.CROSSOVER);
        // System.out.println(car2.toString());

        //Car car3 = new Car("Kia", "Sportage 4 поколение", 2.4, TypeOfBody.PICKUP);
        //System.out.println(car3.toString());

        Truck truck = new Truck("Валдай", "NEXT", 7.0, LoadCapasity.N2);
        truck.addDriver(new DriverC("Платон", 'C', 3, truck));
        truck.addMechanic(andrey);
        truck.addSponsor(belrus);
        System.out.println(truck.toString());

        // Truck truck1 = new Truck("Тонар", "7502", 19.0, LoadCapasity.N3);
        // System.out.println(truck1.toString());

        // Truck truck2 = new Truck("JAC", "Sunray", 3.3, LoadCapasity.N1);
        // System.out.println(truck2.toString());

        // Truck truck3 = new Truck("MAN", "TGX 4X4", 10.5, LoadCapasity.N2);
        // System.out.println(truck3.toString());

        Bus bus = new Bus("IKARUS", "417", 3.8, TypeOfCapacity.VERY_BIG);
        bus.addDriver(new DriverD("Саймон", 'D', 4, bus));
        bus.addMechanic(andrey);
        bus.addSponsor(lukoyl, sber);
        System.out.println(bus.toString());

        //Bus bus1 = new Bus("VOLVO", "7900", 4.1, TypeOfCapacity.AVERAGE);
        // System.out.println(bus1.toString());

        // Bus bus2 = new Bus("IVECO", "Urbanway 10", 3.5, TypeOfCapacity.VERY_BIG);
        // System.out.println(bus2.toString());

        // Bus bus3 = new Bus("SETRA", "Comfort Class 500", 5.0, TypeOfCapacity.SMALL);
        // System.out.println(bus3.toString());

        diagnostics(lada, audi, bmw, kia, truck, truck1, truck2, truck3, bus, bus1, bus2, bus3);

        // DriverB anton = new DriverB("Антон", 'B', 5, lada);
        //  DriverC platon = new DriverC("Платон", 'C', 3, truck);
        // DriverD simon = new DriverD("Саймон", 'D', 4, bus);

        // System.out.println(anton);
        // anton.driverInfo();
        //lada.printType();

        //System.out.println(platon);
        // platon.driverInfo();
        // truck.printType();

        // System.out.println(simon);
        // simon.driverInfo();
        // bus.printType();


        List<Transport> transports = List.of(car, truck, bus);

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

    private static void diagnostics(Transport... transports) {
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


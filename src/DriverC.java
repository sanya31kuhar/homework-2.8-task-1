public class DriverC extends Driver<Truck> {

    public DriverC(String fullName, Character driverLicense, double experience, Truck licenseCar) {
        super(fullName, driverLicense, experience, licenseCar);
    }

    @Override
    public String toString() {
        return "C";
    }
}

public class DriverB extends Driver<Car> {

    public DriverB(String fullName, Character driverLicense, double experience, Car licenseCar) {
        super(fullName, driverLicense, experience, licenseCar);
    }

    @Override
    public String toString() {
        return "B";
    }
}

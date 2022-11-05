public class DriverD extends Driver<Bus> {

    public DriverD(String fullName, Character driverLicense, double experience, Bus licenseCar) {
        super(fullName, driverLicense, experience, licenseCar);
    }

    @Override
    public String toString() {
        return "D";
    }
}

import java.util.Objects;

public abstract class Driver<T extends Transport & Competing> {

    private final String fullName;
    private final Character driverLicense;
    private double experience;
    private T licenseCar;

    protected Driver(String fullName, Character driverLicense, double experience, T licenseCar) {
        if (fullName == null || fullName.isEmpty()) {
            throw new NullPointerException("Укажите ФИО водителя");
        } else {
            this.fullName = fullName;
        }
        if (driverLicense != 'B' && driverLicense != 'C' && driverLicense != 'D') {
            throw new IllegalArgumentException("Нет прав, иди в автошколу");
        } else {
            this.driverLicense = driverLicense;
        }
        if (licenseCar != null) {
            this.licenseCar = licenseCar;
        }
        setExperience(experience);
    }

    public T getLicenseCar() {
        return licenseCar;
    }

    public void setLicenseCar(T licenseCar) {
        if (licenseCar == null) {
            throw new IllegalArgumentException("Необходимо указать тип прав!");
        }
        this.licenseCar = licenseCar;
    }

    public void startMoving() {
        licenseCar.startMoving();
    }

    public void stopsMoving() {
        licenseCar.stopsMoving();
    }

    public void refills() {
        System.out.println(getFullName() + "Заправляется");
    }

    public String getFullName() {
        return fullName;
    }

    public Character getDriverLicense() {
        return driverLicense;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        if (experience <= 0) {
            throw new NullPointerException("Иди учиться водить!");
        } else {
            this.experience = experience;
        }
    }

    public void driverInfo() {
        System.out.println("Водитель " + fullName + " управляет " + licenseCar.getBrand() + " " +
                licenseCar.getModel() + " и будет участвовать в заезде");
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, driverLicense, experience, licenseCar);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Driver)) return false;
        Driver<?> driver = (Driver<?>) obj;
        return experience == driver.experience && fullName.equals(driver.fullName) &&
                driverLicense.equals(driver.driverLicense) && licenseCar.equals(driver.licenseCar);
    }

    @Override
    public String toString() {
        return fullName + " , стаж вождения: " + experience + " лет, категория: " + licenseCar;
    }
}

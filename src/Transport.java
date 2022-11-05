import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Transport {

    private final String brand;
    private final String model;
    private final double engineVolume;
    private final Set<Driver<?>> drivers = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();

    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty()) {
            this.brand = "Укажите бренд";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty()) {
            this.model = "Укажите модель";
        } else {
            this.model = model;
        }
        if (engineVolume < 0) {
            this.engineVolume = 0;
            System.out.println("Укажите объем двигателя");
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void addDriver(Driver<?>... driver) {
        this.drivers.addAll(Arrays.asList(driver));
    }
    public void addMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }
    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));

    }

    public abstract void startMoving();

    public abstract void stopsMoving();

    public abstract void printType();

    public abstract boolean diagnostics();

    public abstract void fixing();

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, drivers, mechanics, sponsors);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Transport)) return false;
        Transport transport = (Transport) obj;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && brand.equals(transport.brand) &&
                model.equals(transport.model) && Objects.equals(drivers, transport.drivers)
                && mechanics.equals(transport.mechanics) && sponsors.equals(transport.sponsors);
    }

    @Override
    public String toString() {
        return "transports.Transport {" +
                "brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", engineVolume = " + engineVolume +
                '}';
    }
}

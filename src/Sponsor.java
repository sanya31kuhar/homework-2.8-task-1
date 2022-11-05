import java.util.Objects;

public class Sponsor {

    private final String name;
    private final int amountOfSupport;

    public Sponsor(String name, int amountOfSupport) {
        this.name = name;
        this.amountOfSupport = amountOfSupport;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfSupport() {
        return amountOfSupport;
    }

    public void raceSponsor() {
        System.out.printf("Спонсор \"%s\" проспонсировал заезд на %d%n", name, amountOfSupport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfSupport);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sponsor)) return false;
        Sponsor sponsor = (Sponsor) obj;
        return Double.compare(sponsor.amountOfSupport, amountOfSupport) == 0 && Objects.equals(name, sponsor.name);
    }

    @Override
    public String toString() {
        return name + ", сумма поддержки: " + amountOfSupport;


    }
}

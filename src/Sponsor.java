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
    public String toString() {
        return name + ", сумма поддержки: " + amountOfSupport;
    }
}

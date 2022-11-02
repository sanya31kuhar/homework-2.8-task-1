public class Mechanic<T extends Transport> {

    private final String name;
    private final String surname;
    private final String company;

    public Mechanic(String name, String surname, String company) {
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public boolean diagnostics(T t) {
        return t.diagnostics();
    }

    public void fixing(T t) {
        t.fixing();
    }

    @Override
    public String toString() {
        return name + " " + surname + " из " + company;
    }
}

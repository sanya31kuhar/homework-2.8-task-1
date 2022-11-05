import java.util.Objects;

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
    public int hashCode() {
        return Objects.hash(name, surname, company);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mechanic)) return false;
        Mechanic<?> mechanic = (Mechanic<?>) obj;
        return Objects.equals(name, mechanic.name) && Objects.equals(surname, mechanic.surname) &&
                Objects.equals(company, mechanic.company);
    }

    @Override
    public String toString() {
        return name + " " + surname + " из " + company;
    }
}

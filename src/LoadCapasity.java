public enum LoadCapasity {

    N1(0d, 3.5),
    N2(3.5, 12d),
    N3(12d, 100d);

    private double from;
    private double to;

    LoadCapasity(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}

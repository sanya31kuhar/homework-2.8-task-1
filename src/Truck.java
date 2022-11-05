public class Truck extends Transport implements Competing {

    private LoadCapasity loadCapasity;

    public Truck(String brand, String model, double engineVolume, LoadCapasity loadCapasity) {
        super(brand, model, engineVolume);
        this.loadCapasity = loadCapasity;
    }

    public LoadCapasity getLoadCapasity() {
        return loadCapasity;
    }

    public void setLoadCapasity(LoadCapasity loadCapasity) {
        this.loadCapasity = loadCapasity;
    }

    @Override
    public void startMoving() {
        System.out.println("Грузовик начал движение");
    }

    @Override
    public void stopsMoving() {
        System.out.println("Грузовик закончил движение");
    }

    @Override
    public void printType() {
        if (loadCapasity == null) {
            System.out.println("Данных недостаточно");
        } else {
            System.out.println("Грузоподъемность грузовика:- от " + loadCapasity.getFrom() + " до " +
                    loadCapasity.getTo() + " тонн");
        }
    }

    @Override
    public void fixing() {
        System.out.println("Грузовик" + getBrand() + " " + getModel() + "починен!");
    }

    @Override
    public boolean diagnostics() {
        return Math.random() > 0.8;
    }

    @Override
    public String toString() {
        return "Грузовик: " + super.toString();
    }

    @Override
    public void getPitStop() {
        System.out.println("Сделать остановку грузовику");
    }

    @Override
    public void getBestTime() {
        System.out.println("Лучшее время круга грузовика");
    }

    @Override
    public void getMaxSpeed() {
        System.out.println("Максимальная скорость грузовика за круг ");
    }
}

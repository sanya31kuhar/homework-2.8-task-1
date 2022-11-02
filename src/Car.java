public class Car extends Transport implements Competing {

    private TypeOfBody typeOfBody;

    public Car(String brand, String model, double engineVolume, TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeOfBody;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    public void startMoving() {
        System.out.println("Автомобиль начал движение");
    }

    @Override
    public void stopsMoving() {
        System.out.println("Автомобиль закончил движение");
    }

    @Override
    public void printType() {
        if (typeOfBody == null) {
            System.out.println("Данных недостаточно");
        } else {
            System.out.println("Тип авто: - " + typeOfBody);
        }
    }

    @Override
    public boolean diagnostics() {
        return Math.random() > 0.7;
    }

    @Override
    public void fixing() {
        System.out.println("Машина" + getBrand() + " " + getModel() + "починена!");
    }

    @Override
    public String toString() {
        return "Автомобиль: " + super.toString();
    }

    @Override
    public void getPitStop() {
        System.out.println("Сделать остановку машине");
    }

    @Override
    public void getBestTime() {
        System.out.println("Лучшее время круга машины");
    }

    @Override
    public void getMaxSpeed() {
        System.out.println("Максимальная скорость  машины за круг ");
    }
}

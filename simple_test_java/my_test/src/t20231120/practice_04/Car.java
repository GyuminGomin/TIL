package practice_04;

public class Car {

    String color;
    int speed;
    int gear;

    void changeGear(int gearNum) {
        gear = gearNum;
    }

    void speedUp() {
        speed += 10;
    }

    void speedDown() {
        speed -= 10;
    }

    @Override
    public String toString() {
        return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
    }
	

}

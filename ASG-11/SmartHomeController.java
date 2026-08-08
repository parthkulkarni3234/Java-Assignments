interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is now ON");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is now ON");
    }
}

public class SmartHomeController {
    public static void main(String[] args) {
        Switchable light = new Light();
        light.turnOn();

        Switchable fan = new Fan();
        fan.turnOn();
    }
}
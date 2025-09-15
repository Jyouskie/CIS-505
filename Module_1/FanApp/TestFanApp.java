package Module_1.FanApp;

public class TestFanApp {
    public static void main(String[] args) {
        // Default fan
        Fan defaultFan = new Fan();

        // Fan using argument constructor
        Fan customFan = new Fan(Fan.FAST, true, 10, "blue");

        // Display the fans
        System.out.println(defaultFan.toString());
        System.out.println(customFan.toString());
    }
}


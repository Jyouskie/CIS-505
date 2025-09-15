package Module_1.FanApp;


public class Fan {
    // 1. Speed constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // 2–5. Data fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // 7. No-argument constructor (default values)
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6;
        this.color = "white";
    }

    // 8. Argument constructor
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    // 6. Accessors and mutators
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public boolean isOn() { return on; }
    public void setOn(boolean on) { this.on = on; }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // 9. Override toString
    @Override
    public String toString() {
        if (on) {
            return String.format("Fan speed: %d, color: %s, radius: %.1f", speed, color, radius);
        } else {
            return String.format("Fan color: %s, radius: %.1f, fan is off", color, radius);
        }
    }
}


package Module_4.BowlingShopApp;

public class Shoe extends Product {
    private double size = 0.0;

    public Shoe() {}

    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }

    @Override
    public String toString() {
        return super.toString() + String.format("\nSize: %.1f", size);
    }
}

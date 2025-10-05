package Module_4.BowlingShopApp;

public class Product {
    private String code = "";
    private String description = "";
    private double price = 0.0;

    public Product() {}

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("%s\n%s\n$%,6.2f", code, description, price);
    }
}

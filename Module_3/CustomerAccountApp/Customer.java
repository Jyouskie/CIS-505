package Module_3.CustomerAccountApp;

public class Customer {
    // Private fields
    private String name;
    private String address;
    private String city;
    private String zip;

    // No-arg constructor
    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    // Argument constructor
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getZip() { return zip; }

    // toString method
    @Override
    public String toString() {
        return name + "\n" + address + "\n" + city + "\n" + zip;
    }
}

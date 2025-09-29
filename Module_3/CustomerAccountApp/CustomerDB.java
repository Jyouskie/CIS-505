package Module_3.CustomerAccountApp;

public class CustomerDB {

    public static Customer getCustomer(int id) {
        if (id == 1007) {
            return new Customer("Joseph Youskievicz", "123 Main St", "Omaha", "68102");
        } else if (id == 1008) {
            return new Customer("Alice Smith", "456 Oak Ave", "Lincoln", "68510");
        } else if (id == 1009) {
            return new Customer("Bob Johnson", "789 Pine Rd", "Bellevue", "68005");
        } else {
            return new Customer("Unknown", "N/A", "N/A", "00000");
        }
    }
}

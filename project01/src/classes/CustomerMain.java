package classes;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer("이효석", 41, 10000, true);
        Customer customer2 = new Customer();

        customer1.printCustomerInfo();
        customer2.printCustomerInfo();


    }
}

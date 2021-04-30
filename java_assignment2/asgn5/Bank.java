package java_assignment2.asgn5;

import java.util.*;

public class Bank {
    private String bankid;
    private ArrayList<Customer> B = new ArrayList<Customer>();
    public Bank() { // default constructor
        bankid = new String("UNREGISTERED");
    }
    public Bank(String s) { // parameterized constructor
        bankid = new String(s);
    }
    public Customer searchCustomer() { // function to search a customer
        System.out.println("Enter Customer ID: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (Customer C : B) {
            if (C.retID().equals(id)) {
                return C;
            }
        }
        System.out.println("Invalid Customer ID.");
        return null;
    }
    public void addCustomer() { // function to add a customer
        int iter = B.size();
        ++iter;
        Customer C = new Customer();
        if (C.getData(bankid, iter)) {
            B.add(C);
        }
    }
    public void getLoan() { // function to get loan for a customer
        Customer C = searchCustomer();
        if (C != null) {
            C.getLoan();
        }
    }
    public void modifyData() {  // function to modify data of a customer;
        Customer C = searchCustomer();
        if (C != null) {
            C.modifyData();
        }
    }
    public void showData() {    // function to show details for a customer
        Customer C = searchCustomer();
        if (C != null) {
            C.showAccountDetails();
        }
    }
}

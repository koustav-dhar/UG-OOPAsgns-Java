package java_assignment2.asgn5;

import java.util.*;

public class Customer {
    private String customerid;
    private String name;
    private float currloanamount;
    private String phoneno;
    private static final float creditlimit = 100000.0f;
    private static final float creditlimitpri = 200000.0f;
    private boolean isprivileged;
    public Customer() {
        customerid = null; name = null; currloanamount = 0.0f; phoneno = null; isprivileged = false;
    }
    private String getAcNoFormat(int r, int tot) {  // utility function to generate unique last portion of the account number
        String temp = String.valueOf(r);    
        String res = new String();
        for (int i = 0; i < (tot - temp.length()); ++i) {
            res += "0";
        }
        res += temp;
        return res;
    }
    public boolean getData(String bankid, int iter) { // function to get user data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter phone no.: ");
        phoneno = sc.nextLine();
        System.out.println("Are you a privileged customer?\nPress 1 if you are privileged.\nPress 2 if you are a normal customer.");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            isprivileged = true;
        } else if (choice != 2) {
            System.out.println("Wrong Choice Selected. Failed to create account.");
            return false;
        }
        customerid = new String(bankid);
        customerid += getAcNoFormat(iter, 3);
        System.out.println("Successfully created account.");
        System.out.println("Your Customer ID is: " + customerid);
        return true;
    }
    public void modifyData() {  // function to modify user data
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to modify your name?(y/n)");
        String ch = sc.nextLine();
        if (ch.equals("y") || ch.equals("Y")) {
            System.out.println("Enter new name: ");
            name = sc.nextLine();
        }
        System.out.println("Do you want to modify your phone?(y/n");
        ch = sc.nextLine();
        if (ch.equals("y") || ch.equals("Y")) {
            System.out.println("Enter new phone: ");
            phoneno = sc.nextLine();
        }
    }
    public void getLoan() { // function to issue loan
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter loan amount to be sanctioned: ");
        float amount = sc.nextFloat();
        sc.nextLine();
        if (amount < 0.0f) {
            System.out.println("Invalid amount entered.");
            return;
        }
        float credlim;
        if (isprivileged) 
            credlim = creditlimitpri;
        else
            credlim = creditlimit;
        if (currloanamount + amount <= credlim) {
            currloanamount += amount;
            System.out.println("Loan Sanctioned Successfully.");
        } else {
            System.out.println("Credit Limit Exceeded. Can't Sanction Loan.");
        }
    }
    public void showAccountDetails() { // function to show account details
        System.out.println("Customer ID: " + customerid);
        System.out.println("Customer Name: " + name);
        System.out.println("Phone No: " + phoneno);
        float credlim;
        if (isprivileged) 
            credlim = creditlimitpri;
        else
            credlim = creditlimit;
        System.out.println("Credit Limit: " + credlim);
        System.out.println("Current Loan Amount Sanctioned: " + currloanamount);
        System.out.println("Amount of Loan you can still seek: " + (credlim - currloanamount));
    }
    public String retID() { // accessor function to return ID
        return customerid;
    }
}


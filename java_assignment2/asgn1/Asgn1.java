
package java_assignment2.asgn1;

import java.util.*;

class BankAcct {
    private String acno;
    private float balance;
    private static float interest_rate = -1.0f;  // initialized as negative(to show that rate isn't initialized by user)
    public BankAcct() { // default constructor
        acno = null;
        balance = 0.0f;
        interest_rate = -1.0f;
    }
    public BankAcct(String ac, float in_bal, float int_rate) {  // parameterized constructor
        acno = new String(ac);
        balance = in_bal;
        interest_rate = int_rate;
    }
    public void getAccountDetails() {   // function to get input account details
        System.out.println("Enter initial deposit: ");
        Scanner sc = new Scanner(System.in);
        balance = sc.nextFloat();
        sc.nextLine();
        // more attributes if added, can be taken input here
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
    public void generateAccountNumber(String bankidentifier, int num) { // utility function to generate account number
        acno = new String(bankidentifier);
        acno += getAcNoFormat(num, 3);
    }
    public void showAccountDetails() {  // function to show account details
        System.out.println("Account Number: " + acno);
        System.out.println("Account Balance: " + balance);
        System.out.println("Current Interest Rate: " + interest_rate);
    }
    public static void initInterestRate(float rate) {   // function to initialize interest rate
        if(rate < 0.0) {
            System.out.println("Invalid Interest Rate passed.");
            return;
        }
        interest_rate = rate;
        System.out.println("Interest Rate initialized.");
    }
    public static void modifyInterestRate(float newrate) {  // function to modify interest rate
        if (interest_rate < 0.0) {
            System.out.println("Interest Rate not initialized yet.");
            return;
        }
        if(newrate < 0.0) {
            System.out.println("Invalid Interest Rate passed.");
            return;
        }
        interest_rate = newrate;
        System.out.println("Interest Rate updated.");
    }
    public static void displayInterestRate() { // function to display interest rate
        System.out.println("Current Interest Rate is " + interest_rate + "%.");
    }
    public float returnBalance() {  // accessor function to return balance
        return balance;
    }
    private void updateBalance(float delta) { // function to update balance after a transaction or interest add
        balance += delta;
    }
    public void calculateInterest(int years, int months) {   // function to calculate interest for certain time period
        if (interest_rate < 0.0) {
            System.out.println("Interest Rate not initialized yet.");
            return;
        }
        float t = years + ((float)(months))/(12.0f);
        float interest = balance * t * interest_rate / 100.0f;
        System.out.println("Interest Generated: " + interest);
        System.out.println("Would you like to add this to your balance?");
        System.out.println("Press 1 to process this. Press anything else to skip.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            this.updateBalance(interest);
        }
    }
}

public class Asgn1 {
    public static int menu() {
        System.out.println("Select what to do: ");
        System.out.println("Press 1 to add account details.");
        System.out.println("Press 2 to initialize interest rate.");
        System.out.println("Press 3 to modify interest rate.");
        System.out.println("Press 4 to display current interest rate.");
        System.out.println("Press 5 to calculate interest.");
        System.out.println("Press 6 to check account details.");
        System.out.println("Press 7 to exit.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void main(String args[]) {
        BankAcct B = new BankAcct();
        Scanner sc = new Scanner(System.in);
        int c = 1;
        float rate;
        while(c != 7) {
            switch(c = menu()) {
                case 1:
                    B.getAccountDetails();
                    B.generateAccountNumber("191050", 1);
                    break;
                case 2:
                    System.out.println("Enter interest rate to be initialized.");
                    rate = sc.nextFloat();
                    sc.nextLine();
                    BankAcct.initInterestRate(rate);
                    break;
                case 3:
                    System.out.println("Enter interest rate to be modified.");
                    rate = sc.nextFloat();
                    sc.nextLine();
                    BankAcct.modifyInterestRate(rate);
                    break;
                case 4:
                    BankAcct.displayInterestRate();
                    break;
                case 5:
                    System.out.println("Enter no of years: ");
                    int y = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter no of months: ");
                    int m = sc.nextInt();
                    sc.nextLine();
                    B.calculateInterest(y, m);
                    break;
                case 6:
                    B.showAccountDetails();
                    break;
                case 7:
                    break;
            }
        }
    }
}

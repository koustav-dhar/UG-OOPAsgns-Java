package java_assignment2.asgn5;

import java.util.*;

public class Asgn5 {
    public static int menu() {
        System.out.println("Select what to do: ");
        System.out.println("Press 1 to add an account.");
        System.out.println("Press 2 to get loan.");
        System.out.println("Press 3 to show account details.");
        System.out.println("Press 4 to modify user details(name and phone no.).");
        System.out.println("Press 5 to exit.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void main(String args[]) {
        int choice = 1;
        Bank b = new Bank("SBIASN");
        while (choice != 5) {
            switch (choice = menu()) {
                case 1:
                    b.addCustomer();
                    break;
                case 2:
                    b.getLoan();
                    break;
                case 3:
                    b.showData();
                    break;
                case 4:
                    b.modifyData();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

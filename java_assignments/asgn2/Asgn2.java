package java_assignments.asgn2;

import java.util.*;

public class Asgn2 {
    static int menu() { // initial menu for choosing user type
        System.out.println("Select user type: ");
        System.out.println("Press 1 if you are a Stock Entry Operator");
        System.out.println("Press 2 if you are a Shopkeeper");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    static int menuSEO() {  // menu for stock entry operators
        System.out.println("Select your choice: ");
        System.out.println("Press 1 to add item");
        System.out.println("Press 2 to update rate of item");
        System.out.println("Press 3 to issue some item");
        System.out.println("Press 4 to restock some item");
        System.out.println("Press 5 to check rate of an item");
        System.out.println("Press 6 to check available quantity of an item");
        System.out.println("Press 7 to find how many items are costlier than an amount");
        System.out.println("Press 8 to exit");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    static int menuShopkeeper() {   // menu for shopkeepers
        System.out.println("Select your choice: ");
        System.out.println("Press 1 to issue some item");
        System.out.println("Press 2 to restock some item");
        System.out.println("Press 3 to check rate of an item");
        System.out.println("Press 4 to check available quantity of an item");
        System.out.println("Press 5 to find how many items are costlier than an amount");
        System.out.println("Press 6 to exit");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void main (String[] args) {
        int choice1 = 0, choice2 = 0;
        ItemList list = new ItemList();
        while (!((choice1 == 1 && choice2 == 8) || (choice1 == 2 && choice2 == 6))) {
            switch (choice1 = menu()) {
                case 1:
                    {
                        switch (choice2 = menuSEO()) {
                            case 1:
                                StockEntryOperator.addItem(list);
                                break;
                            case 2:
                                StockEntryOperator.updateRate(list);
                                break;
                            case 3:
                                StockEntryOperator.issueItem(list);
                                break;
                            case 4:
                                StockEntryOperator.restockItem(list);
                                break;
                            case 5:
                                StockEntryOperator.knowPrice(list);
                                break;
                            case 6:
                                StockEntryOperator.knowQuantity(list);
                                break;
                            case 7:
                                StockEntryOperator.knowHowManyCostsMore(list);
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                    }
                    break;
                case 2:
                    {
                        switch (menuShopkeeper()) {
                            case 1:
                                Shopkeeper.issueItem(list);
                                break;
                            case 2:
                                Shopkeeper.restockItem(list);
                                break;
                            case 3:
                                Shopkeeper.knowPrice(list);
                                break;
                            case 4:
                                Shopkeeper.knowQuantity(list);
                                break;
                            case 5:
                                Shopkeeper.knowHowManyCostsMore(list);
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid User Type");
            }
        }
    }
}

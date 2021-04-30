package java_assignments.asgn2;

import java.util.*;

public class Shopkeeper {
    public static void issueItem(ItemList list) {   // function to issue item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item code to issue: ");
        String code = sc.nextLine();
        Item I = list.search(code);
        try {
            if (I == null) {
                throw new ItemException("ItemNotFound");
            } else {
                System.out.println("Enter quantity you want to issue: ");
                int issueQty = sc.nextInt();
                sc.nextLine();
                if (I.canUpdateQuantity(-issueQty)) {
                    I.updateQuantity(-issueQty);
                    System.out.println("Successfully issued " + issueQty + " items.");
                } else {
                    System.out.println("Enough Stock not available.");
                }
            }
        } catch (ItemException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void restockItem(ItemList list) { // function to restock an item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item code to restock: ");
        String code = sc.nextLine();
        Item I = list.search(code);
        try {
            if (I == null) {
                throw new ItemException("ItemNotFound");
            } else {
                System.out.println("Enter quantity you want to restock: ");
                int restockQty = sc.nextInt();
                sc.nextLine();
                I.updateQuantity(restockQty);
                System.out.println("Successfully restocked " + restockQty + " items.");   
            }
        } catch (ItemException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void knowPrice(ItemList list) {   // function to know price of an item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item code to know price: ");
        String code = sc.nextLine();
        Item I = list.search(code);
        try {
            if (I == null) {
                throw new ItemException("ItemNotFound");
            } else {
                System.out.println("Price of item: " + I.retRate());
            }
        } catch (ItemException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void knowQuantity(ItemList list) {    // function to know available quantity of an item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item code to know available quantity: ");
        String code = sc.nextLine();
        Item I = list.search(code);
        try {
            if (I == null) {
                throw new ItemException("ItemNotFound");
            } else {
                System.out.println("Available quantity of item: " + I.retQuantity());
            }
        } catch (ItemException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void knowHowManyCostsMore(ItemList list) {    // function to know number of items costlier than a certain price
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter price bound: ");
        float bound = sc.nextFloat();
        sc.nextLine();
        System.out.println(list.itemCostsMoreThan(bound) + " items cost more than " + bound);
    }
}

package java_assignments.asgn2;

import java.util.*;

public class StockEntryOperator extends Shopkeeper {
    public static void addItem(ItemList list) { // function to add an item
        list.addItem();
    }
    public static void updateRate(ItemList list) {  // function to update rate of an item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item code to update rate: ");
        String code = sc.nextLine();
        Item I = list.search(code);
        try {
            if (I == null) {
                throw new ItemException("ItemNotFound");
            } else {
                System.out.println("Enter updated rate: ");
                float newrate = sc.nextFloat();
                I.updateRate(newrate);
                System.out.println("Successfully updated rate.");
            }
        } catch (ItemException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

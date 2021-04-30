package java_assignments.asgn2;

import java.util.*;

public class Item {
    private String itemcode;
    private String itemname;
    private float rate;
    private int quantity;
    public Item() { // default constructor
        itemcode = null; itemname = null;
        rate = 0.0f; quantity = 0;
    }
    public Item(Item I) {   // copy constructor
        itemcode = new String(I.itemcode);
        itemname = new String(I.itemname);
        rate = I.rate;
        quantity = I.quantity;
    }
    public void getInput() {   // function to get input of item
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item name: ");
        itemname = sc.nextLine();
        System.out.println("Enter rate of item: ");
        rate = sc.nextFloat();
        System.out.println("Enter quantity: ");
        quantity = sc.nextInt();
        sc.nextLine();
    }
    void generateItemCode(int eorder, int tot) { // function to generate item using given entry order
        itemcode = itemname.substring(0, 3).toUpperCase();
        String temp = String.valueOf(eorder);
        for (int i = 0; i < (tot - temp.length()); ++i) {
            itemcode += "0";
        }
        itemcode += temp;
    }
    public void showData() {    // function to display item details
        System.out.println("Item Code: " + itemcode);
        System.out.println("Item Name: " + itemname);
        System.out.println("Rate: " + rate);
        System.out.println("Quantity Available: " + quantity + "\n");
    }
    void updateRate(float newrate) {    // function to update rate 
        rate = newrate;
    }
    boolean canUpdateQuantity(int delta) {  // function to check if can issue
        return (quantity + delta >= 0);
    }
    void updateQuantity(int delta) {    // function to update quantity
        quantity += delta;
    }
    public String retItemCode() {   // accessor function to get itemcode
        return itemcode;
    }
    public String retItemName() {   // accessor function to get itemname
        return itemname;
    }
    public float retRate() {    // accessor function to get rate
        return rate;
    }
    public int retQuantity() {  // accessor function to get quantity
        return quantity;
    }
}

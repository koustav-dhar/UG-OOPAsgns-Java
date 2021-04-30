package java_assignments.asgn2;

import java.util.*;

class ItemException extends Exception { // custom class for exception handling
    public ItemException(String s) {    // copy constructor
        super(s);
    }
}

public class ItemList {
    private ArrayList<Item> list = new ArrayList<Item>();
    Item search(String code) { // function to search an item using given item code
        for (Item I : list) {
            if (I.retItemCode().equals(code)) {
                return I;
            }
        }
        return null;    // if not found
    }
    public void addItem() { // function to add a new item
        int n = list.size();
        ++n;
        Item newitem = new Item();
        newitem.getInput(); // get item details
        newitem.generateItemCode(n, 3); // generate item code
        list.add(newitem);
        System.out.println("Item Added Successfully.");
        System.out.println("Item Code is " + newitem.retItemCode());
    }
    public void showAllItems() {    // function to show all items
        for (Item I : list) {
            I.showData();
        }
    }
    public int itemCostsMoreThan(float bound) { // function to return number of items which cost more than given rate
        int cnt = 0;
        for (Item I : list) {
            if (I.retRate() > bound) {
                ++cnt;
            }
        }
        return cnt;
    }
}


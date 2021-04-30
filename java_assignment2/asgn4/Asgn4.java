package java_assignment2.asgn4;

import java.util.*;

public class Asgn4 {
    public static void main(String args[]) {
        // basic type to object
        float a = 3.14f;
        KdFloat k1 = KdFloat.toKdFloat(a);
        System.out.println("Object - " + k1.toFloat());
        // object to basic type
        KdFloat k2 = new KdFloat(2.5f);
        System.out.println("Basic Type - " + k2.toFloat());
        // basic type to string
        float b = 6.9f;
        System.out.println("Basic Type to String - " + KdFloat.toString(b));
        // string to numeric object
        String s = "4.56";
        KdFloat k3 = KdFloat.toObjectKdFloat(s);
        System.out.println("String to Object - " + k3.toFloat());
        // object to string
        KdFloat k4 = new KdFloat(5.77f);
        System.out.println("Object to String - " + k4.toString());
    }
}

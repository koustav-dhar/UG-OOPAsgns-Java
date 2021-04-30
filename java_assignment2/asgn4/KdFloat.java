package java_assignment2.asgn4;

import java.util.*;

public class KdFloat {
    private float num;
    public KdFloat() {  // default constructor
        num = 0.0f;
    }
    public KdFloat(float n) {   // parameterized constructor
        num = n;
    }
    public KdFloat(KdFloat t) { // copy constructor
        num = t.toFloat();
    }
    public float toFloat() {    // accessor function to return the float value
        return num;
    }
    public static KdFloat toKdFloat(float n) {  // static function to convert basic numeric type to wrapper class object
        KdFloat temp = new KdFloat(n);
        return temp;
    }
    @Override
    public String toString() {  // convert object to numeric string
        return KdFloat.toString(num);
    }
    public static String toString(float num) {  // static function to convert numeric type to string
        return String.valueOf(num);
    }
    public static KdFloat toObjectKdFloat(String s) {   // static function to convert string to numeric object
        KdFloat t = new KdFloat(Float.parseFloat(s));
        return t;
    }
}

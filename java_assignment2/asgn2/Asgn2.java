package java_assignment2.asgn2;

import java.util.*;

class Metric {
    static float kmtomileconverter = 1.5f;
    public static float kmToMile(float kms) {   // function to convert kms to miles
        return (kms / kmtomileconverter);
    }
    public static float mileToKM(float miles) { // function to convert miles to kms
        return (miles * kmtomileconverter);
    }
}

public class Asgn2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float distance;
        int choice = 1;
        while (choice != 3) {
            System.out.println("Select what to do: ");
            System.out.println("Press 1 to convert kms to miles.");
            System.out.println("Press 2 to convert miles to kms.");
            System.out.println("Press 3 to exit.");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter distance in kms: ");
                    distance = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Distance in miles: " + Metric.kmToMile(distance));
                    break;
                case 2:
                    System.out.println("Enter distance in miles: ");
                    distance = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Distance in kms: " + Metric.mileToKM(distance));
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

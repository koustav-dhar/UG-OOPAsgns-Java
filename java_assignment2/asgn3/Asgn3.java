package java_assignment2.asgn3;

import java.util.*;

public class Asgn3 {
    public static void countA(String s) {   // function to count no of 'a's in the string
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                ++count;
            }
        }
        System.out.println("No of 'a's in the string is: " + count);
    }
    public static void countAnd(String s) { // function to count no of 'and's in the string
        StringTokenizer st = new StringTokenizer(s);
        int count = 0;
        while(st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals("and")) {
                ++count;
            }
        }
        System.out.println("No of 'and's in the string is: " + count);
    }
    public static void startsWithThe(String s) {    // function to check if string starts with 'The'
        if (s.startsWith("The")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void convertToCharArray(String s) {   // function to convert the string into a character array
        char str[] = s.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            System.out.println(str[i]);
        }
    }
    public static void tokenize(String s) { // function to tokenize the string separated by space, @ and .
        StringTokenizer st = new StringTokenizer(s, " @.");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        int choice = 1;
        
        while (choice != 7) {
            System.out.println("Select what to do: ");
            System.out.println("Press 1 to enter a new string.");
            System.out.println("Press 2 to count no of 'a's in the string.");
            System.out.println("Press 3 to count no of 'and's in the string.");
            System.out.println("Press 4 to check if the string starts with 'The' or not.");
            System.out.println("Press 5 to convert the string into a character array and display.");
            System.out.println("Press 6 to tokenize the string separated by space, @, . and display the tokens.");
            System.out.println("Press 7 to exit.");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: 
                    System.out.println("Enter the new string: ");
                    s = sc.nextLine();
                    break;
                case 2:
                    countA(s);
                    break;
                case 3:
                    countAnd(s);
                    break;
                case 4:
                    startsWithThe(s);
                    break;
                case 5:
                    convertToCharArray(s);
                    break;
                case 6:
                    tokenize(s);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

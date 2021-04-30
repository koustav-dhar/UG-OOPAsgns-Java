package java_assignments.asgn3;

import java.util.Scanner;

import java_assignments.asgn3.Stack;

public class Parentheses {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String par = sc.nextLine();
        int len = par.length();
        boolean ok = true;
        Stack S = new Stack();  // initializing a stack to analyze the parentheses matching
        for (int i = 0; i < len; ++i) {
            switch (par.charAt(i)) {
                case '(':
                case '[':
                case '{':   // if a opening parentheses, push it to stack
                    S.push(par.charAt(i));
                    break;
                // if a closing parentheses, check if the top of the stack
                // is corresponding opening or not
                case ')':
                    if (S.top() == '(') {
                        S.pop();
                    } else {
                        ok = false;
                    }
                    break;
                case ']':
                    if (S.top() == '[') {
                        S.pop();
                    } else {
                        ok = false;
                    }
                    break;
                case '}':
                    if (S.top() == '{') {
                        S.pop();
                    } else {
                        ok = false;
                    }
                    break;
                default:
                    ok = true;
            }
        }
        if (ok) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

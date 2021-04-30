package java_assignments.asgn3;

// class for implementing stack data structure
public class Stack {
    static final int max_size = 1001;   // max no of elements the stack can have
    private char[] stack = new char[max_size];
    private int curr_size = 0;  // leeps track of count of elements at any moment
    public void push(char ch) { // function to push an element
        if (curr_size == max_size) {    // if the stack is full
            System.out.println("Stack Overflow");
        } else {
            stack[curr_size] = ch;
            ++curr_size;    // increasing count of elements
        }
    }
    public void pop() { // function to pop an element in LIFO way
        if (curr_size == 0) {   // if the stack is empty
            System.out.println("Stack Underflow");
        } else {
            --curr_size;    // decreasing count of elements
        }
    }
    public char top() { // function to print the top element of the stack
        if (curr_size == 0) {   // if the stack is empty
            System.out.println("Stack Underflow");
            return '\0';
        } else {
            return stack[curr_size - 1];
        }
    }
}

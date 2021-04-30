package java_assignments.asgn1;

import java.util.*;

public class Student { 
    protected String roll;
    private String name;
    private String course;
    private int dd, mm, yy; // stores admission date(dd/mm/yy)
    protected static final int n_subs = 5;
    protected int[] marks = null;
    static final int n_stud = 1000;
    static Student[] studentList = new Student[n_stud];
    static int studentsAdmitted = 0;
    public Student() {  // default constructor
        roll = null; name = null; course = null;
    }
    public boolean isEvaluated() {  // function to check if marks allocated or not
        return (marks != null);
    }
    public Student(Student S) { // copy constructor
        roll = new String(S.roll);
        name = new String(S.name);
        course = new String(S.course);
        dd = S.dd; mm = S.mm; yy = S.yy;
    }
    public static Student search(String r) {    // function to search by roll and return student if found
        for (int i = 0; i < studentsAdmitted; ++i) {
            if (studentList[i].roll.equals(r)) {    // using equals method of String class to compare roll
                return studentList[i];
            }
        }
        return null;
    }  
    public static boolean remove(String r) {    // function to remove a student by roll
        int i;
        for (i = 0; i < studentsAdmitted; ++i) {
            if (studentList[i].roll.equals(r)) {    // using equals method of String class to compare roll
                break;
            }
        }
        if (i == studentsAdmitted) {    // if no student with given roll found
            return false;
        }
        for (; i < studentsAdmitted; ++i) { 
            studentList[i] = studentList[i + 1];    // adjusting the ordering of remaining students
        }
        studentList[i] = null;  // freeing the removed student
        --studentsAdmitted; // decreasing no of students admitted currently
        return true;
    }
    public int getInput() { // function to get input of a student
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        course = new String("BE");
        System.out.println("Enter date in numbers: ");
        dd = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter month in numbers: ");
        mm = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter year in numbers: ");
        yy = sc.nextInt();
        sc.nextLine();
        return 1;
    }
    private String getRollFormat(int r, int tot) {  // function to generate unique last portion of the roll
        String temp = String.valueOf(r);    
        String res = new String();
        for (int i = 0; i < (tot - temp.length()); ++i) {
            res += "0";
        }
        res += temp;
        return res;
    }
    public void admit(int nextRoll) {   // function to add a newly admitted student to the universal student list
        roll += String.valueOf(yy % 100);   // generating
        roll += getRollFormat(nextRoll, 3); // roll number
        studentList[studentsAdmitted] = this;
        ++studentsAdmitted; // increasing no of students admitted currently
    }
    public void getMarks() {    // function to get input of marks of a student
        Scanner sc = new Scanner(System.in);
        marks = new int[n_subs];
        System.out.println("Enter marks for 5 subjects: ");
        for (int i = 0; i < n_subs; ++i) {
            marks[i] = sc.nextInt();
            sc.nextLine();
        }
    }
    public int[] retMarks() {   // accessor function to return array of the marks
        return marks;
    }
    public String getRoll() {   // accessor function to return roll number
        return roll;
    }
    public String getName() {   // accessor function to return name
        return name;
    }
    int getTotalMarks() {   // function to get total marks
        if (marks == null)
            return -1;
        int sum = 0;
        for (int i = 0; i < n_subs; ++i) {
            sum += marks[i];
        }
        return sum;
    }
    public void showMarkSheet() {   // function to print the marksheet of a student object
        System.out.println("Roll: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Date of Admission: " + dd + "/" + mm + "/" + yy);
        if (marks == null) {
            System.out.println("Marks not evaluated.");
            return;
        }
        System.out.println("Marks: ");
        for (int i = 0; i < n_subs; ++i) {
            System.out.println("Subject" + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + getTotalMarks());
    }
}

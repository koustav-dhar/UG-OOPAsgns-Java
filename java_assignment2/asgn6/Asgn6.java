package java_assignment2.asgn6;

import java.util.*;

abstract class Person {
    private String name;
    private String premiseno;
    private String street;
    private String city;
    private String pin;
    private String state;
    public void getData() { // function to get data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        System.out.println("Enter premises no.: ");
        premiseno = sc.nextLine();
        System.out.println("Enter street name: ");
        street = sc.nextLine();
        System.out.println("Enter city: ");
        city = sc.nextLine();
        System.out.println("Enter PIN Code: ");
        pin = sc.nextLine();
        System.out.println("Enter State: ");
        state = sc.nextLine();
    }
    public void modifyAddress() {    // function to modify address
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println("Do you want to change premise no.? (y/n)");
        choice = sc.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new premise no.: ");
            premiseno = sc.nextLine();
        }
        System.out.println("Do you want to change street name? (y/n)");
        choice = sc.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new street name: ");
            street = sc.nextLine();
        }
        System.out.println("Do you want to change city? (y/n)");
        choice = sc.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new city: ");
            city = sc.nextLine();
        }
        System.out.println("Do you want to change PIN Code? (y/n)");
        choice = sc.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new PIN Code: ");
            pin = sc.nextLine();
        }
        System.out.println("Do you want to change State? (y/n)");
        choice = sc.nextLine();
        if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Enter new State: ");
            state = sc.nextLine();
        }
    }
    public void showData() { // function to show details of a person
        System.out.println("Name: " + name);
        System.out.println("Address: ");
        System.out.println("Premises No.: " + premiseno);
        System.out.println("Street Name: " + street);
        System.out.println("City: " + city);
        System.out.println("PIN Code: " + pin);
        System.out.println("State: " + state);
    }
    protected String getIDFormat(int r, int tot) {  // utility function to generate unique last portion of the ID
        String temp = String.valueOf(r);    
        String res = new String();
        for (int i = 0; i < (tot - temp.length()); ++i) {
            res += "0";
        }
        res += temp;
        return res;
    }
}

class Student extends Person {
    private String roll;
    private String course;
    @Override
    public void getData() { // overriding the getData function
        System.out.println("Enter student details: ");
        super.getData();
        System.out.println("Enter course of study: ");
        Scanner sc = new Scanner(System.in);
        course = sc.nextLine();
    }
    public void generateRollNumber(String firstpart, int iter) {    // function to generate roll number of a student
        roll = new String(firstpart);
        roll += getIDFormat(iter, 3);
        System.out.println("Your roll number is: " + roll);
    }
    @Override
    public void showData() {    // overriding the showData function
        System.out.println("Student Roll No. : " + roll);
        System.out.println("Course of Study: " + course);
        super.showData();
    }
    public String retRollNumber() { // accessor function to return roll number of a student
        return roll;
    }
}

class Faculty extends Person {
    private String empid;
    private String dept;
    private String specialization;
    @Override
    public void getData() { // overriding the getData function
        System.out.println("Enter Faculty Details: ");
        super.getData();
        System.out.println("Enter Department: ");
        Scanner sc = new Scanner(System.in);
        dept = sc.nextLine();
        System.out.println("Enter Specialization: ");
        specialization = sc.nextLine();
    }
    public void generateEmpID(String firstpart, int iter) {   // function to generate employee id of a faculty
        empid = new String(firstpart);
        empid += getIDFormat(iter, 3);
        System.out.println("Your Employee ID is: " + empid);
    }
    @Override
    public void showData() {    // overriding showData function
        System.out.println("Employee ID: " + empid);
        System.out.println("Department: " + dept);
        System.out.println("Specialization: " + specialization);
        super.showData();
    }
    public String retEmpID() {  // accessor function to get employee id of a faculty
        return empid;
    }
}

class Institute {
    private ArrayList<Student> S = new ArrayList<Student>();
    private ArrayList<Faculty> F = new ArrayList<Faculty>();
    private String studentuid;
    private String facultyuid;
    public Institute() {    // default constructor
        studentuid = new String("S");
        facultyuid = new String("F");
    }
    public Institute(String uid) {  // parameterized constructor
        studentuid = new String(uid);
        studentuid += "S";
        facultyuid = new String(uid);
        facultyuid += "F";
    }
    private Student searchStudent() {   // function to search for a student
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll Number: ");
        String r = sc.nextLine();
        for (Student s : S) {
            if (s.retRollNumber().equals(r)) {
                return s;
            }
        }
        System.out.println("Invalid Roll Number.");
        return null;
    }
    private Faculty searchFaculty() {   // function to search for a faculty
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id of Faculty: ");
        String id = sc.nextLine();
        for (Faculty f : F) {
            if (f.retEmpID().equals(id)) {
                return f;
            }
        }
        System.out.println("Invalid ID.");
        return null;
    }
    public void addStudent() {  // function to add student
        Student s = new Student();
        s.getData();
        s.generateRollNumber(studentuid, S.size() + 1);
        S.add(s);
        System.out.println("Student Added.");
    }
    public void addFaculty() {  // function to add faculty
        Faculty f = new Faculty();
        f.getData();
        f.generateEmpID(facultyuid, F.size() + 1);
        F.add(f);
        System.out.println("Faculty Added.");
    }
    public void modifyStudentAddress() {    // function to modify address of a student
        Student s = searchStudent();
        if (s != null) {
            s.modifyAddress();
        }
    }
    public void modifyFacultyAddress() {    // function to modify address of a faculty
        Faculty f = searchFaculty();
        if (f != null) {
            f.modifyAddress();
        }
    }
    public void showStudentData() { // function to show student data
        Student s = searchStudent();
        if (s != null) {
            s.showData();
        }
    }
    public void showFacultyData() { // function to show faculty data
        Faculty f = searchFaculty();
        if (f != null) {
            f.showData();
        }
    }
 }

public class Asgn6 {
    public static int menu() {
        System.out.println("\nSelect what to perform: ");
        System.out.println("Press 1 to add a student.");
        System.out.println("Press 2 to add a faculty.");
        System.out.println("Press 3 to modify address of a student.");
        System.out.println("Press 4 to modify address of a faculty.");
        System.out.println("Press 5 to show details of a student.");
        System.out.println("Press 6 to show details of a faculty.");
        System.out.println("Press 7 to exit.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void main(String args[]) {
        Institute I = new Institute("JADUNIV");
        int choice = 1;
        while (choice != 7) {
            switch (choice = menu()) {
                case 1:
                    I.addStudent();
                    break;
                case 2:
                    I.addFaculty();
                    break;
                case 3:
                    I.modifyStudentAddress();
                    break;
                case 4:
                    I.modifyFacultyAddress();
                    break;
                case 5:
                    I.showStudentData();
                    break;
                case 6:
                    I.showFacultyData();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

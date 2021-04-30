package java_assignments.asgn6;

import java.util.*;

public class Doctor {
    private String docname;
    private String degree;
    private String docid;
    private String contactno;
    private int noofpatients;
    public void getInput() {    // function to get input of doctor's data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor Name: ");
        docname = sc.nextLine();
        System.out.println("Enter Degree: ");
        degree = sc.nextLine();
        System.out.println("Enter Contact No.: ");
        contactno = sc.nextLine();
        noofpatients = 0;
    }
    void generateDoctorID(int eorder, int tot) { // function to generate Doctor ID (Doctor Name + Admission Order)
        docid = docname.substring(0, 3).toUpperCase();
        String temp = String.valueOf(eorder);
        for (int i = 0; i < (tot - temp.length()); ++i) {
            docid += "0";
        }
        docid += temp;
        System.out.println("Generated Doctor ID: " + docid);
    }
    public void showData() {   // function to show doctor's data
        System.out.println("Doctor ID: " + docid);
        System.out.println("Doctor Name: " + docname);
        System.out.println("Degree: " + degree);
        System.out.println("Contact No.: " + contactno);
        System.out.println("No of Patients diagnosing currently: " + noofpatients);
    }
    public String retID() { // accessor function to return doctor ID
        return docid;
    }
    public String retName() {   // accessor function to return doctor's name
        return docname;
    }
    public void incrementPatients() {   // mutator function to increase the no of patients
        ++noofpatients;
    }
    public void decrementPatients() {   // mutator function to decrease the no of patients
        --noofpatients;
    }
    public int retPatients() {  // accessor function to return no of patients
        return noofpatients;
    }
}

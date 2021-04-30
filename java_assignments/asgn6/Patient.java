package java_assignments.asgn6;

import java.util.*;

class Record {
    private int systolic;
    private int diastolic;
    private float temperature;
    private Date recorddate;
    void getRecord() {  // function to get input of a record
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Systolic Blood Pressure: ");
        systolic = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Diastolic Blood Pressure: ");
        diastolic = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Temperature of Patient in Fahrenheit: ");
        temperature = sc.nextFloat();
        sc.nextLine();
        recorddate = new Date();
        System.out.println("Test Results recorded at " + recorddate);
    }
    void showRecord() { // function to show the record
        Scanner sc = new Scanner(System.in);
        System.out.println("Test Results recorded at " + recorddate);
        System.out.println("Blood Pressure (Systolic / Diastolic): " + systolic + " / " + diastolic);
        System.out.println("Temperature: " + temperature + " F\n");
    }
}

public class Patient {
    private String patientid;
    private String patientname;
    private int age;
    private String contactno;
    private String address;
    private String doctorassigned;
    private ArrayList<Record> records;
    public void getInput() {    // function to get input of patient data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient Name: ");
        patientname = sc.nextLine();
        System.out.println("Enter Patient Age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Patient Contact No.: ");
        contactno = sc.nextLine();
        System.out.println("Enter Patient Address: ");
        address = sc.nextLine();
        records = new ArrayList<Record>();
    }
    void generatePatientID(int eorder, int tot) { // function to generate Patient ID (Patient Name + Admission Order)
        patientid = patientname.substring(0, 3).toUpperCase();
        String temp = String.valueOf(eorder);
        for (int i = 0; i < (tot - temp.length()); ++i) {
            patientid += "0";
        }
        patientid += temp;
        System.out.println("Generated Patient ID is: " + patientid);
    }
    void assignDoctor(String docname) { // mutator function to assign doctor name who's diagnosing the patient
        doctorassigned = new String(docname);
        System.out.println("Doctor Assigned to you is Dr. " + docname);
    }
    public void showPatientData() { // function to show patient's information
        System.out.println("Patient ID: " + patientid);
        System.out.println("Patient Name: " + patientname);
        System.out.println("Patient Age: " + age);
        System.out.println("Patient Address: " + address);
        System.out.println("Doctor Assigned: " + doctorassigned);
        System.out.println("Test Results Recorded Till Now: ");
        for (Record R : records) {
            R.showRecord();
        }
    }
    public void addRecord() {   // function to add record of a test result
        Record R = new Record();
        R.getRecord();
        records.add(R);
    }
    public String retID() { // accessor function to return patient ID
        return patientid;
    }
}

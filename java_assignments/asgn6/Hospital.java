package java_assignments.asgn6;

import java.util.*;
import java.util.Map.Entry;

class DoctorComparator implements Comparator<Entry<String, Integer>> {
    @Override
    public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
        if (arg0.getValue().equals(arg1.getValue())) {
            return arg0.getKey().compareTo(arg1.getKey());
        } else {
            return (arg0.getValue() - arg1.getValue());
        }
    }
}



public class Hospital {
    private ArrayList<Patient> P = new ArrayList<Patient>();
    private int totalnoofpatients = 0;
    private ArrayList<Doctor> D = new ArrayList<Doctor>();
    private TreeMap<Entry<String, Integer>, ArrayList<String>> DoctsPatients = new TreeMap<Entry<String, Integer>, ArrayList<String>>(new DoctorComparator());
    public Patient searchPatient(String id) {  // function to search patient by id
        for (Patient pat : P) {
            if (pat.retID().equals(id)) {
                return pat;
            }
        }
        return null;
    }
    public Doctor searchDoctor(String id) { // function to search doctor by id
        for (Doctor doc : D) {
            if (doc.retID().equals(id)) {
                return doc;
            }
        }
        return null;
    }
    public void addDoctor() {   // function to add a doctor
        Doctor doc = new Doctor();
        doc.getInput();
        doc.generateDoctorID(D.size() + 1, 3);
        D.add(doc);
        ArrayList<String> pats = new ArrayList<String>();
        Entry<String, Integer> key = Map.entry(doc.retID(), 0);
        DoctsPatients.put(key, pats);
    }
    public void addPatient() {  // function to admit a patient
        if (DoctsPatients.isEmpty()) {
            System.out.println("No Doctors at the moment.");
            System.out.println("Can't admit a patient. Sorry.");
            return;
        }
        Patient pat = new Patient();
        pat.getInput();
        ++totalnoofpatients;
        pat.generatePatientID(totalnoofpatients, 3);
        Entry<Entry<String, Integer>, ArrayList<String>> E = DoctsPatients.pollFirstEntry();
        Doctor doc = searchDoctor(E.getKey().getKey());
        pat.assignDoctor(doc.retName());
        P.add(pat);
        ArrayList<String> temp = E.getValue();
        temp.add(pat.retID());
        doc.incrementPatients();
        Integer I = E.getKey().getValue();
        Integer I2 = (I.intValue() + 1);
        DoctsPatients.put(Map.entry(doc.retID(), I2), E.getValue());
    }
    public void addRecord() {   // function to add record for a patient
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor ID: ");
        String docid = sc.nextLine();
        Doctor doc = searchDoctor(docid);
        if (doc == null) {
            System.out.println("Invalid Doctor ID.");
        } else {
            Entry<String, Integer> key = Map.entry(docid, doc.retPatients());
            Set<Entry<Entry<String, Integer>, ArrayList<String>>> est = DoctsPatients.entrySet();
            boolean flag = false;
            for (Entry<Entry<String, Integer>, ArrayList<String>> E : est) {
                if (E.getKey().getKey().equals(key.getKey()) && E.getKey().getValue().equals(key.getValue())) {
                    flag = true;
                }
            }
            if (flag) {
                ArrayList<String> list = DoctsPatients.get(key);
                System.out.println("Enter Patient ID whose results are to be recorded: ");
                String patid = sc.nextLine();
                Patient pat = searchPatient(patid);
                if (pat == null) {
                    System.out.println("Invalid Patient ID.");
                } else {
                    boolean ok = false;
                    for (String ID : list) {
                        if (ID.equals(patid)) {
                            ok = true;
                        }
                    }
                    if (ok) {
                        pat.addRecord();
                    } else {
                        System.out.println("This Doctor doesn't supervises this patient.");
                    }
                }
            } else {
                System.out.println("Error Occured.");
            }
        }
    }
    public void showPatient() { // function to show patient data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient ID for viewing data: ");
        String patid = sc.nextLine();
        Patient pat = searchPatient(patid);
        if (pat == null) {
            System.out.println("Invalid Patient ID.");
        } else {
            pat.showPatientData();
        }
    }
    public void showDoctor() {  // function to show doctor data
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor ID for viewing data: ");
        String docid = sc.nextLine();
        Doctor doc = searchDoctor(docid);
        if (doc == null) {
            System.out.println("Invalid Doctor ID.");
        } else {
            doc.showData();
        }
    }
    public void dischargePatient() {    // function to remove patient
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient ID for discharge: ");
        String patid = sc.nextLine();
        Patient pat = searchPatient(patid);
        if (pat == null) {
            System.out.println("Invalid Patient ID.");
        } else {
            for (Entry<Entry<String, Integer>, ArrayList<String>> E : DoctsPatients.entrySet()) {
                boolean ok = false;
                for (String s : E.getValue()) {
                    if (s.equals(patid)) {
                        ok = true;
                        break;
                    }
                }
                if (ok) {
                    E.getValue().remove(patid);
                    Doctor doc = searchDoctor(E.getKey().getKey());
                    doc.decrementPatients();
                    break;
                }
            }
            P.remove(pat);
            System.out.println("Patient discharged successfully.");
        }
    }
    public int menu() {
        System.out.println("Select your choice: ");
        System.out.println("Press 1 to admit a patient.");
        System.out.println("Press 2 to add a doctor.");
        System.out.println("Press 3 to record test results.");
        System.out.println("Press 4 to show patient details.");
        System.out.println("Press 5 to show doctor details.");
        System.out.println("Press 6 to discharge a patient.");
        System.out.println("Press 7 to exit.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public void operate() {
        int choice = 0;
        while (choice != 7) {
            switch (choice = menu()) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    addRecord();
                    break;
                case 4:
                    showPatient();
                    break;
                case 5:
                    showDoctor();
                    break;
                case 6:
                    dischargePatient();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

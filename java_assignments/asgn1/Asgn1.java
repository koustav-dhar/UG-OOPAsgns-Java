package java_assignments.asgn1;

import java.util.*;

public class Asgn1 {
    static int menu() { // function to display menu and get choice
        System.out.println("Select your choice: ");
        System.out.println("Press 1 to add Student");
        System.out.println("Press 2 to assign marks to student");
        System.out.println("Press 3 to print Mark Sheet of Student");
        System.out.println("Press 4 to know how many students have taken admission");
        System.out.println("Press 5 to get Ranked List by Department on total marks");
        System.out.println("Press 6 to remove a student");
        System.out.println("Press 7 to Exit");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public static void main (String args[]) {
        Student S;
        ArrayList<ExtendedStudent>[] DeptList = new ArrayList[Departments.n_dept];
        for (int i = 0; i < Departments.n_dept; ++i) {
            DeptList[i] = new ArrayList<ExtendedStudent>();
        }
        ExtendedStudent tempE;
        int choice = 0;
        int idx = 0;
        String r;
        Scanner sc = new Scanner(System.in);
        while (choice != 7) {
            switch (choice = menu()) {
                case 1: // add student
                    S = new ExtendedStudent();
                    idx = S.getInput();
                    S.admit(Departments.getNextRoll(idx));
                    System.out.println("Your roll number is: " + S.getRoll());
                    tempE = new ExtendedStudent(S, idx);
                    DeptList[idx - 1].add(tempE);
                    Departments.updateDeptRoll(idx);
                    break;
                case 2: // assign marks to a student
                    System.out.println("Enter roll number: ");
                    r = sc.nextLine();
                    S = Student.search(r);
                    if (S == null) {
                        System.out.println("Invalid Roll Number.");
                    } else {
                        S.getMarks();
                        idx = Departments.getIndex(S.getRoll().substring(0, 4));
                        for (ExtendedStudent E : DeptList[idx - 1]) {
                            if (E.getRoll().equals(S.getRoll())) {
                                E.setMarks(S.retMarks());
                                break;
                            }
                        }
                        System.out.println("Marks Added Successfully.");
                    }
                    break;
                case 3: // show marksheet of a student
                    System.out.println("Enter roll number: ");
                    r = sc.nextLine();
                    S = Student.search(r);
                    if (S == null) {
                        System.out.println("Invalid Roll Number.");
                    } else {
                        S.showMarkSheet();
                    }
                    break;
                case 4: // show number of students admitted currently
                    System.out.println("Number of students taken admission: " + Student.studentsAdmitted);
                    break;
                case 5: // get ranked list of dept
                    System.out.println("Choose the department: ");
                    Departments.showDeptList();
                    idx = sc.nextInt();
                    sc.nextLine();
                    
                    Collections.sort(DeptList[idx - 1], ExtendedStudent.OnTotalMarks);
                    for (ExtendedStudent E : DeptList[idx - 1]) {
                        if (E.isEvaluated()) {
                            System.out.println(E.getName() + ": " + E.getTotalMarks());
                        } else {
                            System.out.println(E.getName() + ": Not Evaluated");
                        }
                    }
                    break;
                case 6: // removal of student
                    System.out.println("Enter roll number to be removed: ");
                    r = sc.nextLine();
                    S = Student.search(r);
                    if (S == null) {
                        System.out.println("Invalid Roll.");
                        break;
                    }
                    idx = Departments.getIndex(S.getRoll().substring(0, 4));
                    tempE = new ExtendedStudent(S, idx);
                    int i = 0;
                    for (ExtendedStudent E : DeptList[idx - 1]) {
                        if (E.equals(tempE)) {
                            break;
                        }
                        ++i;
                    }
                    DeptList[idx - 1].remove(i);
                    Student.remove(r);
                    System.gc();
                    S = null;
                    tempE = null;
                    System.gc();
                    System.out.println("Student removed.");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
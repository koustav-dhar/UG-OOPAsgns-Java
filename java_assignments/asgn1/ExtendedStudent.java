package java_assignments.asgn1;

import java.util.*;

// class for Departmental student inheriting Student class
public class ExtendedStudent extends Student {
    private String dept;
    public ExtendedStudent() {  // default constructor
        super();
        dept = null;
    }
    public ExtendedStudent(Student S, int idx) {    // custom constructor(kind of copy with the additional attributes)
        super(S);
        dept = new String(Departments.getDept(idx));
    }
    @Override
    public int getInput() { // overriding function to get input 
        super.getInput();
        Departments.showDeptList();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        dept = Departments.getDept(choice);
        roll = new String(Departments.getDeptCode(choice));
        return choice;
    }
    public void setMarks(int m[]) { // function to allocate marks from a given array
        marks = new int[n_subs];
        for (int i = 0; i < n_subs; ++i) {
            marks[i] = m[i];
        }
    }
    // comparator for sorting on the basis of total marks(descending)
    public static final Comparator<ExtendedStudent> OnTotalMarks = new Comparator<ExtendedStudent>() {
        public int compare(ExtendedStudent a, ExtendedStudent b) {
            return Integer.compare(b.getTotalMarks(), a.getTotalMarks());
        }
    };
    @Override
    public boolean equals(Object obj) { // overriding equals function of Object class
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof ExtendedStudent) {
            ExtendedStudent e = (ExtendedStudent)obj;
            return roll.equals(e.getRoll());
        }
        else
            return false;
    }    
}

package java_assignments.asgn1;

// class to store hardcoded names and codes of departments available
public class Departments {
    static int n_dept = 4;
    static String[] depts = {"Computer Science and Engineering",
                             "Electronics and Telecommunication Engineering",
                             "Chemical Engineering",
                             "Mechanical Engineering"};
    static String[] deptcodes = {"BCSE", "ETCE", "BCHE", "MECH"};
    static int[] deptAdmitted = new int[n_dept];
    public static void showDeptList() { // function to print available departments list
        System.out.println("Departments Available: ");
        for (int i = 0; i < n_dept; ++i) {
            System.out.println(String.valueOf(i + 1) + ". " + depts[i]);
        }
    }
    public static int getIndex(String deptcode) {   // function to get index from department code
        for (int i = 0; i < n_dept; ++i) {
            if (deptcodes[i].equals(deptcode)) {
                return i + 1;
            }
        }
        return 0;
    }
    public static String getDept(int choice) {  // function to get department name from choice of department list
        return depts[choice - 1];
    }
    public static String getDeptCode(int choice) {  // function to get department code from choice of department list
        return deptcodes[choice - 1];
    }
    public static int getNextRoll(int choice) { // function to get next roll from choice of department list
        return deptAdmitted[choice - 1] + 1;
    }
    public static void updateDeptRoll(int choice) { // function to update number of students in department from choice of department list
        ++deptAdmitted[choice - 1];
    }
}

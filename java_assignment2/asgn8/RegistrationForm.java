package java_assignment2.asgn8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Employee {    // class for storing employee details
    private String emp_id;
    private String name;
    private String b_salary;
    private String grade;
    private String dept;


    public String getName(){    // accessor function to return name
        return this.name;
    }

    public void setName(String name){   // setter function to set name
        if(name == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setId(String id){   // setter function to set id
        this.emp_id= id;
    }

    public String getId(){  // accessor function to return id
        return this.emp_id;
    }

    public String getSalary(){  // accessor function to return salary
        return this.b_salary;
    }
    public void setSalary(String s){    // setter function to set salary
        this.b_salary = s;
    }

    public String getGrade(){   // accessor function to return grade
        return this.grade;
    }
    public void setGrade(String c){ // setter function to set grade
        this.grade = c;
    }

    public void setDept(String d){  // setter function to set department
        this.dept = d;
    }

    public String getDept(){    // accessor function to return department
        return this.dept;
    }
    @Override
    public String toString(){   // overriding toString function
        return emp_id + "\t" + name + "\t" + b_salary + "\t" +  grade + "\t" + dept +  "\t\n";
    }
}



class RegistrationForm extends JFrame{  // class for the main GUI application

    // components

    private JLabel heading;
    private JLabel idLabel;
    private JTextField idTextField;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel salaryLabel;
    private JTextField salaryTextField;
    private ButtonGroup gradeBg;
    private JLabel gradeLabel;
    private JRadioButton A_Button;
    private JRadioButton B_Button;
    private JRadioButton C_Button;
    private JLabel depLabel;
    private JList<String> depList;
    private JButton addEmp;
    private JButton Save;
    private JButton reset;
    private JTextArea tShow;
    private JTextField searchField;
    private JButton search;
    private JButton displayAllButton;
    private JLabel selDep;
    private JButton clButton;
    // arraylist for storing list of employees
    private ArrayList<Employee> empList = new ArrayList<>();

    public RegistrationForm(){  // constructor to apply the components
        setVisible(true);  
        setSize(1150, 800);  
        setLayout(null);  
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("EMPLOYEE REGISTRATION");  
        heading = new JLabel("ENTER THE DETAILS");   
        heading.setFont(new Font("Serif", Font.BOLD, 20));  
        
        // initializing the components
        idLabel = new JLabel("Employee ID:");
        nameLabel = new JLabel("Name:");  
        salaryLabel = new JLabel("Salary: ");   
        idTextField = new JTextField(20);  
        nameTextField = new JTextField(20);  
        salaryTextField = new JTextField(20);
        searchField = new JTextField(); 
        gradeLabel = new JLabel("Grade: ");   
        A_Button = new JRadioButton("A");
        B_Button = new JRadioButton("B");
        C_Button = new JRadioButton("C");
        gradeBg = new ButtonGroup();  
        addEmp = new JButton("Add Employee");
        clButton = new JButton("Clear Display");
        depLabel = new JLabel("Department : ");
        
        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("Accounts");
        l1.addElement("Product Management");
        l1.addElement("Engineering");
        l1.addElement("Service");
        l1.addElement("Sales");
        l1.addElement("IT");
        l1.addElement("Marketing");
        l1.addElement("Human Resources");
        
        depList = new JList<>(l1); 
        Save = new JButton("Save");  
        reset = new JButton("Clear");  
        tShow = new JTextArea();
        search = new JButton("Search");
        displayAllButton = new JButton("Display All");

        // positioning the components
        heading.setBounds(500, 20, 400, 30);  
        idLabel.setBounds(80, 70, 200, 30);  
        nameLabel.setBounds(80, 110, 200, 30);  
        salaryLabel.setBounds(80, 150, 200, 30); 
        gradeLabel.setBounds(80, 200, 200,30);   
        idTextField.setBounds(300, 70, 200, 30);  
        nameTextField.setBounds(300, 110, 200, 30);  
        salaryTextField.setBounds(300, 150, 200, 30);
        A_Button.setBounds(300,180,50,60);
        B_Button.setBounds(350,180,50,60);
        C_Button.setBounds(400,180,50,60);
        addEmp.setBounds(200, 450, 200, 30);
        clButton.setBounds(450, 300, 200, 30);
        
        depLabel.setBounds(80, 240, 200,30);   
        // depList.setBounds(300,240,200,130);  
        Save.setBounds(50, 450, 100, 30);  
        reset.setBounds(170, 450, 100, 30);  
        // tShow.setBounds(600,30,500,400);
        search.setBounds(650, 450, 100, 30);
        searchField.setBounds(770, 450, 200, 30);
        displayAllButton.setBounds(450, 450, 150, 30);
       

        JScrollPane scroll = new JScrollPane(tShow);
        scroll.setBounds(350,60,400,200); 
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane scrollList = new JScrollPane();
        scrollList.setViewportView(depList);
        scrollList.setBounds(300,240,200,100);
        depList.setLayoutOrientation(JList.VERTICAL);
        
        // adding the components
        add(scroll);
        add(addEmp);
        add(clButton);

        // add(tShow);
        add(search);
        add(searchField);
        add(displayAllButton);

        selDep = new JLabel();


        // setting the event listeners
        addEmp.addActionListener            (event -> toAddEmployee());
        displayAllButton.addActionListener  (event -> displayAll());
        search.addActionListener            (event -> search());
        clButton.addActionListener          (event -> clearText());

    
    }
    // function to check if employee with passed id exists or not
    private boolean isEmployeeIdInList(String idStr)
    {
        boolean inList = false;

        for (Employee emp : empList)
        {
            if (emp.getId().compareToIgnoreCase(idStr) == 0)
            {
                inList = true;
            }
        }

        return inList;
    }
    // function to perform the events when an employee is to be added
    private void toAddEmployee(){
        JPanel dbox = new JPanel(new GridBagLayout());  // panel for the form
        
        // setting the layout constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
    
        // adding and positioning the components in the form
        constraints.gridx = 0; constraints.gridy = 0;
        dbox.add(idLabel, constraints);  
        constraints.gridx = 1; constraints.gridy = 0;
        dbox.add(idTextField, constraints);  
        constraints.gridx = 0; constraints.gridy = 1;
        dbox.add(nameLabel, constraints);  
        constraints.gridx = 1; constraints.gridy = 1;
        dbox.add(nameTextField, constraints);  
        constraints.gridx = 0; constraints.gridy = 2;
        dbox.add(salaryLabel, constraints);  
        constraints.gridx = 1; constraints.gridy = 2;
        dbox.add(salaryTextField, constraints);  
        constraints.gridx = 0; constraints.gridy = 3;
        dbox.add(gradeLabel, constraints);
        constraints.gridx = 1; constraints.gridy = 3;
        dbox.add(A_Button, constraints);
        constraints.gridx = 1; constraints.gridy = 4;
        dbox.add(B_Button, constraints);
        constraints.gridx = 1; constraints.gridy = 5;
        dbox.add(C_Button, constraints);
        gradeBg.add(A_Button);
        gradeBg.add(B_Button);
        gradeBg.add(C_Button);
        constraints.gridx = 0; constraints.gridy = 6;
        dbox.add(depLabel, constraints);
    
        JScrollPane scrollList = new JScrollPane();
        scrollList.setViewportView(depList);
        scrollList.setBounds(300,240,200,100);
        depList.setLayoutOrientation(JList.VERTICAL);
        
        constraints.gridx = 1; constraints.gridy = 6;
        dbox.add(scrollList, constraints);
        dbox.setSize(800, 600);
    
        // passing the form panel in a dialog box
        int result = JOptionPane.showConfirmDialog(null, dbox, "Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            addEmployee();  // add the employee if ok is pressed
        }
    }
    // function to add an employee
    private void addEmployee(){
        if(isEmployeeIdInList (idTextField.getText()) == true){ // if employee id already exists
            JOptionPane.showMessageDialog(this, "Error: Employee Id already in the list.","Alert",JOptionPane.WARNING_MESSAGE);
        }else{
                // extract data from the fields and add the employee
                Employee emp = new Employee();
                emp.setId(idTextField.getText());
                emp.setName(nameTextField.getText());
                emp.setSalary(salaryTextField.getText());

            
                if(A_Button.isSelected()){
                    emp.setGrade(A_Button.getText());                  
                }else if(B_Button.isSelected()){
                    emp.setGrade(B_Button.getText());                   
                }else{
                    emp.setGrade(C_Button.getText());
                }
                
                String data = depList.getSelectedValue();
                selDep.setText(data);
                emp.setDept(selDep.getText());
                
                empList.add(emp);
                // display all employees in the display text box
                displayAll();
                clearAll();
            

        }
    }

    private void clearAll() {
       
        idTextField.setText("");
        nameTextField.setText("");
        salaryTextField.setText("");
        selDep.setText("");
        gradeBg.clearSelection();
        depList.clearSelection();
    
    }
    // function to display all the employees in the display text box
    private void displayAll (){
        tShow.setText ("");
        tShow.append("emp_id" + "\t" + "Name" + "\t" + "Base_Salary" + "\t" +  "Grade" + "\t" + "Department" +  "\n\n");
        for (Employee emp : empList)
        {
            tShow.append(emp+ "\n");
        }
    }
    // function to search for an employee
    private void search(){

        boolean inList = false;
        String st = searchField.getText();
        if(isEmployeeIdInList (searchField.getText()) == false){
            JOptionPane.showMessageDialog(this, "Error: Enter a valid id!","Alert",JOptionPane.WARNING_MESSAGE);
            searchField.setText("");
            return;
        }else{
            for (Employee emp : empList)
            {
                if (emp.getId().compareToIgnoreCase(st) == 0)
                {   
                    tShow.setText("");
                    tShow.append("emp_id" + "\t" + "Name" + "\t" + "Base_Salary" + "\t" +  "Grade" + "\t" + "Department" +  "\n\n");
                    inList = true;
                    tShow.append(emp+"\n");
                }
            }
        }

        if(inList == false){
            JOptionPane.showMessageDialog(this, "Error: Enter a valid id!","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearText(){
        tShow.setText("");
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new RegistrationForm();
            }
        });
    }
}


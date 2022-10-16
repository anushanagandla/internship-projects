package com.wavemaker.training;

import com.wavemaker.training.db.dao.DepartmentDAO;
import com.wavemaker.training.db.dao.EmployeeDAO;
import com.wavemaker.training.db.dao.Department;
import com.wavemaker.training.db.dao.Employee;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    public  void printEmployees() {
        List<Employee> listOfEmployees = employeeDAO.getListOfEmployees();
        if (listOfEmployees != null) {
            for (Employee employee : listOfEmployees) {
                System.out.println(employee);
            }
        }
    }
        public  void printDepartments() {
            List<Department> listOfDepartments = departmentDAO.getListOfDepartments();
            if(listOfDepartments != null) {
                for (Department department : listOfDepartments) {
                    System.out.println(department);
                }
            }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("jdbc programming menu:");
            System.out.println("1.insert employees");
            System.out.println("2.delete employee");
            System.out.println("3.update employee");
            System.out.println("4.display");
            System.out.println("Enter your choice");
            choice= scanner.nextInt();
            Employee employee=new Employee();
           // EmployeeDAO employee1=new EmployeeDAO();
            switch(choice)
            {
                case 1:
                    System.out.println("enter employee id");
                    int id=scanner.nextInt();
                    employee.setId(id);
                    System.out.println("enter employee name");
                    String name= scanner.next();
                    System.out.println("enter gender");
                    String gender= scanner.next();
                    System.out.println("enter dob");
                    String DOB= scanner.next();
                    System.out.println("enter dept id");
                    int dept_id=scanner.nextInt();
                    System.out.println("enter address id");
                    int address_id= scanner.nextInt();
                    employeeDAO.createEmployee(new Employee(id,name,gender,DOB,dept_id,address_id));
                    System.out.println("user id "+employee.getId() +"successfully inserted");
                    break;
                case 2:
                    System.out.println("enter employee id");
                    int id1=scanner.nextInt();
                    employee.setId(id1);
                    System.out.println("enter employee name");
                    String name1= scanner.next();
                    System.out.println("enter gender");
                    String gender1= scanner.next();
                    System.out.println("enter dob");
                    String DOB1= scanner.next();
                    System.out.println("enter dept id");
                    int dept_id1=scanner.nextInt();
                    System.out.println("enter address id");
                    int address_id1= scanner.nextInt();
                    employeeDAO.deleteEmployee(new Employee(id1,name1,gender1,DOB1,dept_id1,address_id1));

                    System.out.println("user id "+employee.getId() +"successfully deleted");
                    break;
                case 3:
                    System.out.println("enter employee id");
                    int id2=scanner.nextInt();
                    employee.setId(id2);
                    System.out.println("enter employee name");
                    String name2= scanner.next();
                    System.out.println("enter gender");
                    String gender2= scanner.next();
                    System.out.println("enter dob");
                    String DOB2= scanner.next();
                    System.out.println("enter dept id");
                    int dept_id2=scanner.nextInt();
                    System.out.println("enter address id");
                    int address_id2= scanner.nextInt();
                    employeeDAO.UpdateEmployee(new Employee(id2,name2,gender2,DOB2,dept_id2,address_id2));
                    System.out.println("successfully updated");
                    break;
                case 4:
                    System.out.println(employeeDAO.getListOfEmployees());

                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }}while (choice!=4);
        System.out.println("Main Program");

        new Main().printEmployees();
        new Main().printDepartments();



    }
}
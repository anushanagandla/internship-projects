package com.wavemaker.training.db.dao;


import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.dao.Employee;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


 public class EmployeeDAO {

    public List<Employee> getListOfEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("NAME");
                String gender = resultSet.getString("gender");
                String DOB = resultSet.getString("DOB");
                int dept_id = resultSet.getInt("dept_id");
                int address_id = resultSet.getInt("address_id");

                employeeList.add(new Employee(id, name,gender,DOB,dept_id,address_id));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return  employeeList;
    }

    public void createEmployee(Employee employee) {
        //TDOO
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "INSERT INTO  Employees(id, name,gender,DOB, dept_id, address_id) VALUES (?, ?, ?, ?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getGender());
            statement.setString(4, employee.getDOB());
            statement.setInt(5, employee.getDept_id());
            statement.setInt(6, employee.getAddress_id());




            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void deleteEmployee(Employee employee) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM Employees WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getId() );

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Employee was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(Employee employee){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE Employees SET  name=?, dept_id=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getDept_id());
            statement.setInt(3, employee.getId());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

package com.wavemaker.training.db.dao;

import com.wavemaker.training.db.connection.MySQLConnectionUtility;
import com.wavemaker.training.db.dao.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAO {

    public List<Department> getListOfDepartments() {
        List<Department> DepartmentList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Department");
            while (resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, ADDRESS
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");


                DepartmentList.add(new Department(id, name));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return DepartmentList ;
    }

    public void createDepartment(Department department) {
        //TDOO
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "INSERT INTO Department (id, name) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());



            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Department was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void deleteEmployee(Department department) {
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "DELETE FROM Department  WHERE name=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department.getName() );

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A department was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void UpdateDepartment(Department department){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            String sql = "UPDATE Department SET name=? WHERE dept_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, department.getName());
            statement.setInt(1,department.getId() );
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing department was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

package com.wavemaker.hospital.implementation;
import com.wavemaker.hospital.PatientManager;
import com.wavemaker.hospital.connectivity.Mysqlconnection;
import com.wavemaker.hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public  class PatientDAOImplementation implements PatientManager {

    public List<Patient> listPatient() {
        List<Patient> patientList = new ArrayList<>();
        Connection connection = Mysqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PATIENT");
            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String address = resultSet.getString("address");
                String  phno= resultSet.getString("phno");
                String gender= resultSet.getString("gender");
                String DOB = resultSet.getString("DOB");

                patientList.add(new Patient(id,name,age,address,phno,gender,DOB));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return  patientList;
    }

    public void addPatient(Patient patient) {
        //TDOO
        List<Patient> patientList = new ArrayList<>();
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "INSERT INTO  PATIENT(id, name,age,address,phno,gender,DOB) VALUES (?, ?, ?, ?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getId());
            statement.setString(2, patient.getName());
            statement.setString(3, patient.getAge());
            statement.setString(4, patient.getAddress());
            statement.setString(5, patient.getPhno());
            statement.setString(6, patient.getGender());
            statement.setString(7, patient.getDOB());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new patient was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }

    }
    public void deletePatient(Patient patient) {
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "DELETE FROM PATIENT WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getId() );

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" patient was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient){
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "UPDATE PATIENT SET  name=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setInt(2, Integer.parseInt(patient.getId()));


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing patient was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }

}


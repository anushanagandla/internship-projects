package com.wavemaker.hospital.implementation;

import com.wavemaker.hospital.PatientManager;
import com.wavemaker.hospital.connectivity.Mysqlconnection;
import com.wavemaker.hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class PatientDAOImplementation implements PatientManager {

    public List<Patient> listPatient() {
        List<Patient> patientList = new ArrayList<>();
        Connection connection = Mysqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PATIENT");
            while (resultSet.next()) {

                String id = String.valueOf(resultSet.getInt("id"));
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");

                String  phno= resultSet.getString("phno");
                String select_doctor=resultSet.getString("select_doctor");
                String date= resultSet.getString("date");
                String gender = resultSet.getString("gender");

                patientList.add(new Patient(id,name,age,phno,select_doctor,date,gender));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return  patientList;
    }

    public void addPatient(Patient patient) {
        //TDOO

        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "INSERT INTO  PATIENT(id, name,age,phno,select_doctor,date,gender) VALUES (?, ?, ?, ?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patient.getId());
            statement.setString(2, patient.getName());
            statement.setString(3, patient.getAge());
            statement.setString(4, patient.getPhno());
            statement.setString(5, patient.getSelect_doctor());
            statement.setString(6, patient.getDate());
            statement.setString(7, patient.getGender());

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
            statement.setInt(1, patient.getId());

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
            statement.setInt(2, patient.getId());


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


package com.wavemaker.hospital.implementation;

import com.wavemaker.hospital.PrescriptionManager;
import com.wavemaker.hospital.connectivity.Mysqlconnection;
import com.wavemaker.hospital.model.Prescription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class PatientPrescriptionDAOImpl implements PrescriptionManager {
    public List<Prescription> listPrescription() {
        List<Prescription>  prescriptionList = new ArrayList<>();
        Connection connection = Mysqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from patient_prescription");
            while (resultSet.next()) {
                int pre_id= Integer.parseInt(resultSet.getString("pre_id"));
                String name = resultSet.getString("name");
                String phno = resultSet.getString("phno");
                String medicines = resultSet.getString("medicines");
                String description = resultSet.getString("description");

                prescriptionList.add(new Prescription(pre_id,name,phno ,medicines,description));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return prescriptionList;
    }
    public void addPrescription(Prescription prescription) {
        //TDOO

        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql ="INSERT INTO patient_prescription (pre_id,name,phno ,medicines,description) VALUES (?, ?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(String.valueOf(prescription.getPre_id())));
            statement.setString(2, prescription.getName());
            statement.setString(3, prescription.getPhno());
            statement.setString(4, prescription.getMedicines());
            statement.setString(5, prescription.getDescription());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new appointment was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void deletePrescription(Prescription prescription) {
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "DELETE FROM patient_prescription WHERE pre_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, prescription.getPre_id());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("appointment was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void updatePrescription(Prescription prescription) {
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "UPDATE patient_prescription SET  medicines=? WHERE pre_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,prescription.getMedicines());
            statement.setInt(2, prescription.getPre_id());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing appointment was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
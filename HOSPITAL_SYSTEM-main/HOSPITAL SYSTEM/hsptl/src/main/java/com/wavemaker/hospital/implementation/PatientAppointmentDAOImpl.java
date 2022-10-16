package com.wavemaker.hospital.implementation;

import com.wavemaker.hospital.AppointmentManager;
import com.wavemaker.hospital.connectivity.Mysqlconnection;
import com.wavemaker.hospital.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class PatientAppointmentDAOImpl implements AppointmentManager {
    public List<Appointment> listAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        Connection connection = Mysqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from  patient_appointment");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phno = resultSet.getString("phno");
                String gender = resultSet.getString("gender");
                int aptid = Integer.parseInt(resultSet.getString("aptid"));
                String date = resultSet.getString("date");

                appointmentList.add(new Appointment(name, phno ,gender,aptid,date));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return appointmentList;
    }
    public void addAppointment(Appointment appointment) {
        //TDOO

        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql ="INSERT INTO patient_appointment (name,phno,gender,aptid,date) VALUES (?, ?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, appointment.getName());
            statement.setString(2, appointment.getPhno());
            statement.setString(3, appointment.getGender());
            statement.setString(4, String.valueOf(appointment.getAptid()));
            statement.setString(5, appointment.getDate());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new appointment was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void deleteAppointment(Appointment appointment) {
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "DELETE FROM patient_appointment WHERE aptid=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, appointment.getAptid());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("appointment was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void updateAppointment(Appointment appointment) {
        Connection connection = Mysqlconnection.getConnection();
        try {
            String sql = "UPDATE patient_appointment SET  name=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, appointment.getName());
            statement.setInt(2, appointment.getAptid());


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing appointment was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
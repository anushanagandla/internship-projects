package com.wavemaker.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.hospital.AppointmentManager;
import com.wavemaker.hospital.implementation.PatientAppointmentDAOImpl;
import com.wavemaker.hospital.model.Appointment;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AppointmentServlet extends HttpServlet{
    private AppointmentManager appointmentManager=new PatientAppointmentDAOImpl() ;


    private ObjectMapper objectMapper=new ObjectMapper();

    protected void doGet(HttpServletRequest request,HttpServletResponse  response)throws IOException{
        List<Appointment> appointment= appointmentManager.listAppointment();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(appointment));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Appointment appointment = objectMapper.readValue(request.getReader(), Appointment.class);
        try {
            appointmentManager.addAppointment(appointment);
        } catch (UnknownError e) {
            response.setStatus(400);
            response.getWriter().write("bad request");
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("Internal server error");
        }
    }
}


package com.wavemaker.hospital.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.hospital.PatientManager;
import com.wavemaker.hospital.model.Patient;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import com.wavemaker.hospital.implementation.PatientDAOImplementation;

public class PatientServlet extends HttpServlet{
    private PatientManager patientManager=new PatientDAOImplementation() ;


    private ObjectMapper objectMapper=new ObjectMapper();

    protected void doGet(HttpServletRequest request,HttpServletResponse  response)throws IOException{
        List<Patient> patient= patientManager.listPatient();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Patient patient = objectMapper.readValue(request.getReader(), Patient.class);
        try {
            patientManager.addPatient(patient);
        } catch (UnknownError e) {
            response.setStatus(400);
            response.getWriter().write("bad request");
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("Internal server error");
        }
    }
}

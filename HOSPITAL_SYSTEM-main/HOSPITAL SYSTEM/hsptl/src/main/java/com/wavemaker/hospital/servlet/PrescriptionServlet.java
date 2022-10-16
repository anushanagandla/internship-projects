package com.wavemaker.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.hospital.PrescriptionManager;
import com.wavemaker.hospital.implementation.PatientPrescriptionDAOImpl;
import com.wavemaker.hospital.model.Prescription;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrescriptionServlet extends HttpServlet{
    private PrescriptionManager prescriptionManager=new PatientPrescriptionDAOImpl() ;


    private ObjectMapper objectMapper=new ObjectMapper();

    protected void doGet(HttpServletRequest request,HttpServletResponse  response)throws IOException{
        List<Prescription> prescription= prescriptionManager.listPrescription();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(prescription));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Prescription prescription=objectMapper.readValue(request.getReader(), Prescription.class);
        try {
            prescriptionManager.addPrescription(prescription);
        } catch (UnknownError e) {
            response.setStatus(400);
            response.getWriter().write("bad request");
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("Internal server error");
        }
    }
}


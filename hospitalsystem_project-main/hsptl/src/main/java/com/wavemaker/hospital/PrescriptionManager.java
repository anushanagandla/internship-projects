package com.wavemaker.hospital;

import com.wavemaker.hospital.model.Prescription;

import java.util.List;

public interface PrescriptionManager {
    void addPrescription(Prescription prescription);
    void updatePrescription(Prescription prescription);
    List<Prescription> listPrescription();
    void deletePrescription(Prescription prescription);
}
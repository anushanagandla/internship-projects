package com.wavemaker.hospital;
import com.wavemaker.hospital.model.Patient;
import java.util.List;
import java.util.ListIterator;
public interface PatientManager {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    List<Patient> listPatient();
    void deletePatient(Patient patient);
//    List<Patient> searchUsers(String searchword);

}
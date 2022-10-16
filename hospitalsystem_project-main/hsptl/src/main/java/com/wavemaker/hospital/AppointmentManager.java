package com.wavemaker.hospital;
import com.wavemaker.hospital.model.Appointment;

import java.util.List;

public interface AppointmentManager {
    void addAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    List<Appointment> listAppointment();
    void deleteAppointment(Appointment appointment);
}
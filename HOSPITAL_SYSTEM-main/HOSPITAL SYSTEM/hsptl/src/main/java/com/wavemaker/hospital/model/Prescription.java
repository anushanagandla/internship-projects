package com.wavemaker.hospital.model;

public class Prescription {
    private int pre_id;
    private String name;

    private String phno;
    private String medicines;

    private String description;
    @Override
    public String toString() {
        return "Appointment{" +
                "pre_id=" + pre_id +
                ", name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", medicines='" + medicines + '\'' +
                ", description='" + description + '\'' +
                '}';
    }




    public Prescription(int pre_id, String name, String phno, String medicines, String description) {
        this.pre_id = pre_id;
        this.name = name;
        this.phno=phno;
        this.medicines=medicines;
        this.description=description;


    }

    public Prescription(){

    }

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.wavemaker.hospital.model;
public class Appointment {
    private String name;
    private String phno;

    private String gender;
    private int aptid;
    private String date;

    @Override
    public String toString() {
        return "Appointment{" +
                "name='" + name + '\'' +
                ", phno='" + phno + '\'' +
                ", gender='" + gender + '\'' +
                ", aptid=" + aptid +
                ", date='" + date + '\'' +
                '}';
    }

    public Appointment(String name, String phno, String gender, int aptid, String date) {
        this.name = name;
        this.phno = phno;
        this.gender=gender;
        this.aptid=aptid;
        this.date=date;


    }

    public Appointment(){

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAptid() {
        return aptid;
    }

    public void setAptid(int aptid) {
        this.aptid = aptid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


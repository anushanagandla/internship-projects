package com.wavemaker.hospital.model;
public class Patient {
    private int id;
    private String name;
    private String age;
    private String phno;
    private String select_doctor;

    private String date;
    private String gender;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phno='" + phno + '\'' +
                ", select_doctor='" + select_doctor + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Patient(String id, String name, String age, String phno, String select_doctor, String date, String gender) {
        this.id= Integer.parseInt(id);
        this.name = name;
        this.age = age;

        this.phno = phno;
        this.select_doctor=select_doctor;
        this.date=date;
        this.gender= gender;

    }

    public Patient(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getSelect_doctor() {
        return select_doctor;
    }

    public void setSelect_doctor(String select_doctor) {
        this.select_doctor = select_doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

package com.wavemaker.training.db.dao;


public class Employee {

    private int Id;
    private String name;

    private String gender;
    private String DOB;
    private int dept_id;
    private int address_id;
    public Employee(int id, String name, String gender, String DOB, int dept_id, int address_id) {
        this.Id= id;
        this.name = name;
        this.gender=gender;
        this.DOB=DOB;
        this.dept_id = dept_id;
        this.address_id=address_id;

    }

    public  Employee() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }


    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
    public int getDept_id() {
        return dept_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", dept_id=" + dept_id +
                ", address_id=" + address_id+
                '}';
    }
}
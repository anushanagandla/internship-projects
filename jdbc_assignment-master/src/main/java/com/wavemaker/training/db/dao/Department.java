package com.wavemaker.training.db.dao;


public class Department{

    private int Id;
    private String name;



    public Department() {
    }
    public Department(int id, String name) {
        this.Id= id;
        this.name = name;


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






    @Override
    public String toString() {
        return "employee{" +
                "Id=" + Id +
                ", name='" + name +
                '}';
    }
}
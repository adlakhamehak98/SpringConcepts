package com.thymeleaf.thymeleafDemo.entity;

//Question 3: Create an Employee registration form and bind it's requested values on the controller.

public class Employee {
    private String name;
    private long id;
    private String contactNumber;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Employee(String name, long id, String contactNumber) {
        this.name = name;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

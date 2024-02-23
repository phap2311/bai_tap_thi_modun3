package com.example.bai_thi_modun3.models;

public class Student {
    private int id;
    private String nameStudent;
    private String email;
    private String dateBirth;
    private String address;
    private int phoneNumber;
    private Classes classes;

    public Student() {
    }

    public Student(int id, String nameStudent, String email, String dateBirth, String address, int phoneNumber, Classes classes) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.email = email;
        this.dateBirth = dateBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classes = classes;
    }

    public Student(String nameStudent, String email, String dateBirth, String address, int phoneNumber, Classes classes) {
        this.nameStudent = nameStudent;
        this.email = email;
        this.dateBirth = dateBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

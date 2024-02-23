package com.example.bai_thi_modun3.models;

public class Classes {
    private int idClass;
    private  String nameClass;

    public Classes() {
    }

    public Classes(int idClass, String nameClass) {
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public Classes(String nameClass) {
        this.nameClass = nameClass;
    }

    public Classes(int idClass) {
        this.idClass = idClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}

package com.example.schoolapp.activities;

import java.io.Serializable;

public class Section implements Serializable {
    private String eduLevel ;
    private  String name;
    private  int img;

    //edu المرحلة الدراسية  section  الشعبة  numStudent  عدد طلاب الشعبة
    public Section(String eduLevel, String name, int img) {
        this.eduLevel = eduLevel;
        this.name = name;
        this.img = img;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

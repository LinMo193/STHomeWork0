package com.join;

public class Student {
    private int id;
    private String name;
    private String birDate;
    private boolean gender;

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

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Student() {
    }

    public Student(int id, String name, String birDate, boolean gender) {
        this.id = id;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }
}

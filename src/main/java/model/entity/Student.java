package main.java.model.entity;

public class Student {
    private String nameStudent;
    private int dogecoin;

    public Student(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Student() {
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getDogecoin() {
        return dogecoin;
    }

    public void setDogecoin(int dogecoin) {
        this.dogecoin = dogecoin;
    }
}

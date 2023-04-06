package main.java.model.entity;

public class Student {
    private String nameStudent;

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
}

package main.java.model.entity;

import main.java.model.objects.DogeCoin;

import javax.swing.*;

public class Student {

    private String studentName;
    private JPanel dataPanel;
    private DogeCoin dogecoin;
    private String nameStudent;

    public Student(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Student() {
        dataPanel=new JPanel();
        dogecoin=new DogeCoin();
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
}

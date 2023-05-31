package main.java.controller;

import main.java.model.entity.Classroom;
import main.java.model.entity.Student;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Student student = new Student("Javier", 5,10,10,200);
        Classroom classroom = new Classroom("Introduccion a la Matematica",219,student);
        System.out.println(classroom.canTakeTheExamToStudent());
    }
}
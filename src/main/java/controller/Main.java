package main.java.controller;

import main.java.model.entity.Classroom;
import main.java.model.entity.Student;
import main.java.model.objects.Item;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Item item = new Item("Tabla de Derivadas", "Buenarda para derivar");
        Student student = new Student("Javier", 5,10,10,200);
        Classroom classroom = new Classroom("Introduccion a la Matematica",219,student);
        System.out.println(classroom.canTakeTheExamToStudent());
        System.out.println(classroom.examResultInfomation());
        System.out.println(classroom.getItemNecesary().getName());
        System.out.println(classroom.getCreditsNecesary());
        student.addUsableInBackpack(item);
        student.addCredits(10);
        System.out.println(classroom.canTakeTheExamToStudent());

    }
}
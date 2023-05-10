package main.java.controller;

import main.java.model.entity.Hallway;
import main.java.model.entity.Store;
import main.java.model.entity.Student;
import main.java.model.objects.Consumable;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        Student student = new Student("Tomas",5,5,10,200);
        Consumable mate = new Consumable("Mate", "Ayuda a energizarte");
        Consumable mate1 = new Consumable("Mate", "Ayuda a energizarte");
        Item trincheta = new Item("Trincheta", "Sirve para cortarte la poca dignidad que te queda");

        student.addUsableInBackpack(mate);
        student.addUsableInBackpack(mate);
        student.addUsableInBackpack(mate);
        student.addUsableInBackpack(trincheta);

        System.out.println(student.getBackpack().size());

        student.deleteUsableInBackpack(mate1);
        student.deleteUsableInBackpack(mate);
        student.deleteUsableInBackpack(mate);

        System.out.println(student.getBackpack().size());

    }
}
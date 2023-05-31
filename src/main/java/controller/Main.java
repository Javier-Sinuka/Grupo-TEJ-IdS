package main.java.controller;


import main.java.model.entity.DBExams;
import main.java.model.entity.Hallway;
import main.java.model.entity.Store;
import main.java.model.entity.Student;
import main.java.model.objects.Consumable;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

import main.java.model.entity.Classroom;
import main.java.model.entity.Student;


import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        GameManager gm=new GameManager();
        gm.getWindow().revalidate();
        gm.getWindow().repaint();
    }
}
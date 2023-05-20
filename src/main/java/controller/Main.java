package main.java.controller;

import main.java.model.entity.DBExams;
import main.java.model.entity.Hallway;
import main.java.model.entity.Store;
import main.java.model.entity.Student;
import main.java.model.objects.Consumable;
import main.java.model.objects.Item;
import main.java.model.objects.Usable;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        DBExams dbExams = new DBExams("C:\\Users\\javie\\OneDrive\\Escritorio\\Facultad\\Ing del Soft\\TEJ - TP\\TEJ - Juego de Roll\\src\\main\\assets\\text\\professor.txt");
        for (String clave : dbExams.getKeyCourseAvailable() ){
            System.out.println(clave);
        }
        System.out.println(dbExams.getNameProfessor("Introduccion a la Matematica"));
        System.out.println(dbExams.getCreditsNecesary("Introduccion a la Matematica"));
        System.out.println(dbExams.getItemNecesary("Introduccion a la Matematica"));


    }
}
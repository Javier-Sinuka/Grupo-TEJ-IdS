package controller;

import model.entity.DBExams;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        DBExams dbExams = new DBExams();
        for (String s : dbExams.getAnswers("Fisica I","¿Es necesario tener pasion por el rock para entender a Bethoven?")){
            System.out.println(s);
        }

    }
}
package main.java.controller;

import main.java.model.entity.DBExams;
import main.java.model.entity.Hallway;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
//        GameManager gm=new GameManager();
//        gm.getWindow().revalidate();
//        gm.getWindow().repaint();
        String course = "Fisica I";
        DBExams dbExams = new DBExams("src/main/assets/text/professor.txt");
        System.out.println(dbExams.getItemNecesary(course).getName());
        Hallway hallway = new Hallway("Tabla de Derivadas", "Para sentirte un verdadero dios",
                "Mate", "Para que levantes ese amigo");
        try {
            System.out.println(hallway.getRandomUsable().getName());
        }catch (Exception e){

        }
//        for (String clave : dbExams.getKeyCourseAvailable() ){
//            System.out.println("Curso Disponible: " + clave);
//        }
//        System.out.println(dbExams.getNameProfessor(course));
//        System.out.println("cantidad de creditos necesarios: " + dbExams.getCreditsNecesary(course));
//        System.out.println("cantidad de creditos ganados: " + dbExams.getCreditsForAprove(course));
//        System.out.println(dbExams.getItemNecesary(course));
//        System.out.println(dbExams.getApodoProfessor(course));
//        for (String clave : dbExams.getQuestionsKeys(course)){
//            System.out.println("Pregunta: "+ clave );
//            for (String claveRespuesta : dbExams.getAnswers(course,clave)){
//                System.out.println("- " + claveRespuesta);
//            }
//            System.out.println("Respuesta Correcta: " + dbExams.getCorrectOption(course,clave));
//        }
    }
}
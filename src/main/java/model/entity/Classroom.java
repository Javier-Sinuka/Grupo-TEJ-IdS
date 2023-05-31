package main.java.model.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Classroom {
    private Professor professor;
    private int roomNumber;

    public Classroom(String nameSubjectToDictate, int roomNumber, Student student) throws IOException {
        this.professor = new Professor(nameSubjectToDictate, student);
        this.roomNumber = roomNumber;
    }

    /**
     * Contructor deprecado.
     */
    public Classroom(){}

    public Professor getProfessor(){
        return professor;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    /**
     * Metodo que retorna un Set con las preguntas para el examen.
     * @return Set de String con las preguntas de la materia
     */
    public Set<String> getQuestionsKeys(){
        return this.professor.getQuestionsKeysExamns();
    }

    /**
     * Metodo que devuelve un ArrayList con las respuestas asociadas a una pregunta en especifico,
     * sin tener estas dentro la respuesta correcta.
     * @param question
     * @return Respuestas asociadas a una pregunta, sin la respuesta correcta
     */
    public ArrayList<String> getAnswerToTheQuestion(String question){
        return this.professor.getAnswer(question);
    }

    /**
     * Metodo que retorna la respuesta correcta a una pregunta especifica
     * @param question
     * @return Respuesta correcta de una pregunta
     */
    public String getCorrectOption(String question){
        return this.professor.getCorrectOption(question);
    }

    /**
     * Comprueba si el alumno ingresado puede tomar el examen
     * @return True si puede tomar el examen, False en caso contrario
     */
    public boolean canTakeTheExamToStudent(){
        return this.professor.canTakeTheExam();
    }

    /**
     * Metodo que retorna si el examen a sido aprobado o no, siendo que este tiene que
     * cumplir con el 60% de las respuestas correctas (no se maneja dichoa logica en
     * Classroom, sino, en Professor)
     * @return True si cumplio con las respuestas necesarias para aprobar, False caso contrario
     */
    public boolean examAproved(){
        return this.professor.examResult();
    }

    /**
     * Metodo que devuelve un String con informacion sobre si aprobo o no el examen,
     * tambien, dicho metodo resta la vida del Estudiante si desaprobo o si respondio
     * incorrectamente alguna respuesta, ademas suma los creditos ganados por aprobar
     * el examen (Manejado tod0 esto en Professor).
     * @return String con informacion sobre el resultado del examen
     */
    public String examResultInfomation(){
        return this.professor.examResultInfo();
    }

    /**
     * Metodo que incrementa un contador cuando el Estudiante selecciona la respuesta
     * correcta de una pregunta, se tiene que agregar a la hora de exponer dicha respuesta,
     * asi la logica de examen funciona correctamente.
     */
    public void increaseCounterCorrectOption(){
        this.professor.increaseCounterCorrectQuestions();;
    }


}

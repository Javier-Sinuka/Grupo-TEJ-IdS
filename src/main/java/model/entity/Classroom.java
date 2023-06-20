package model.entity;

import model.objects.Usable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Las Materias posibles a ingresar actualmente son las siguientes:
 * 1) Introduccion a la Matematica
 * 2) Fisica I
 * 3) Representacion Grafica
 *
 */

public class Classroom {
    private Professor professor;
    private int roomNumber;

    public Classroom(String nameSubjectToDictate, int roomNumber, Student student) throws IOException {
        professor = new Professor(nameSubjectToDictate, student);
        this.roomNumber = roomNumber;
    }

    public Professor getProfessor(){
        return professor;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    /**
     * Metodo que retorna un ArrayList con las preguntas para el examen.
     * @return Set de String con las preguntas de la materia
     */

    public LinkedList<String> getQuestionsKeys(){
        return this.professor.getQuestionsKeysExams();
    }

    /**
     * Metodo que devuelve un ArrayList con las respuestas asociadas a una pregunta en especifico,
     * incluyendo tambien la respuesta correcta la respuesta correcta.
     * @param question
     * @return Respuestas asociadas a una pregunta, sin la respuesta correcta
     */
    public ArrayList<String> getAnswersToTheQuestion(String question){
        return this.professor.getAnswers(question);
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
        return this.professor.canTakeExam();
    }

    /**
     * Metodo que retorna si el examen a sido aprobado o no, siendo que este tiene que
     * cumplir con el 60% de las respuestas correctas (no se maneja dichoa logica en
     * Classroom, sino, en Professor)
     * @return True si cumplio con las respuestas necesarias para aprobar, False caso contrario
     */
    public boolean isExamPassed(){
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
        this.professor.increaseCounterCorrectQuestions();
    }

    /**
     * Metodo que devuelve los creditos necesarios para poder rendir la materia dictada
     * en el aula.
     * @return Creditos necesarios para rendir el examen
     */
    public int getCreditsNecesary(){
        return this.professor.getNecessaryCredits();
    }

    /**
     * Metodo que devuelve el item necesario para rendir el examen que se dicta en el aula
     * @return Usable del Item necesario para rendir
     */
    public Usable getItemNecessary(){
        return this.professor.getNecessaryItem();
    }

}

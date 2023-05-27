package main.java.model.entity;

import main.java.model.objects.Usable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Professor {
    private String nameCourseAsociatted;
    private Student student;
    private DBExams dbExams;
    public Professor(String nameCourseAsociatted, DBExams dbExams, Student student) throws IOException{
        this.student = student;
        this.dbExams = dbExams;
        this.nameCourseAsociatted = nameCourseAsociatted;
    }

    /**
     * Metodo que devuelve las preguntas asociadas a la materia en cuestion.
     * @return Set con las preguntas del examen
     */
    public Set<String> getQuestionsKeysExamns(){
        return dbExams.getQuestionsKeys(this.nameCourseAsociatted);
    }

    /**
     * Metodo que retorna un ArrayList con las respuestas asociadas a una pregunta en cuestion.
     * @param question
     * @return ArrayList con las respuestas a una pregunta puntual
     */
    public ArrayList<String> getAnswer(String question){
        return dbExams.getAnswers(nameCourseAsociatted, question);
    }

    /**
     * Metodo que devuelte la respuesta correcta asociada a una pregunta del examen
     * @param question
     * @return Respuesta correcta a la pregunta pasada
     */
    public String getCorrectOption(String question){
        return dbExams.getCorrectOption(nameCourseAsociatted, question);
    }

    /**
     * @return Nombre de la Materia asociado a este profesor
     */
    public String getNameCourseAsociatted(){
        return this.nameCourseAsociatted;
    }

    /**
     * @return Nombre del Profesor que dicta esta materia
     */
    public String getNameProfessor(){
        return dbExams.getNameProfessor(nameCourseAsociatted);
    }

    /**
     * @return Apodo asociado al Profesor que dicta esta materia
     */
    public String getApodoProfessor(){
        return dbExams.getApodoProfessor(nameCourseAsociatted);
    }

    /**
     * @return Cantidad de creditos necesarios para cursar la materia
     */
    public int getCreditsNecesary(){
        return dbExams.getCreditsNecesary(nameCourseAsociatted);
    }

    /**
     * @return Item necesario para cursar esta materia
     */
    public Usable getItemNecesary(){
        return dbExams.getItemNecesary(nameCourseAsociatted);
    }

    /**
     * Metodo que chequea si el Estudiante posee el item necesario para rendir la
     * materia (TODO: SE VA A DEPRECAR CUANDO SE HAGA EL PdD STRATEGY)
     * @return True si cuenta con el Item, False en caso contrario
     */
    public boolean checkStudentHasNecessaryItem(){
        boolean flag = false;
        for (Usable usable : student.getBackpack()){
            if (usable.getName().equals(dbExams.getItemNecesary(nameCourseAsociatted).getName()) &&
            usable.getDescription().equals(dbExams.getItemNecesary(nameCourseAsociatted).getDescription())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Metodo que comprueba que el estudiante tenga los creditos necesarios para rendir
     * la materia en cuestion (TODO: SE VA A DEPRECAR CUANDO SE HAGA EL PdD STRATEGY)
     * @return True si cuenta con los creditos necesarios, False en caso contrario
     */
    public boolean checkStudentHasNecessatyCredits(){
        return student.getCredits() >= dbExams.getCreditsNecesary(nameCourseAsociatted);
    }

    /**
     * Metodo que comprueba si puede rendir o no el examen en cuestion.
     * @return True si puede rendir, False en caso contrario
     */
    public boolean canTakeTheExam(){
        return this.checkStudentHasNecessaryItem() && this.checkStudentHasNecessatyCredits();
    }
}
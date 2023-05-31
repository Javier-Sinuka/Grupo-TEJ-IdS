package main.java.model.entity;

import main.java.model.objects.Usable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Professor {
    private String nameCourseAsociatted;
    private Student student;
    private DBExams dbExams;
    private int counterCorrectAnswers;
    private boolean flag;
    public Professor(String nameCourseAsociatted, Student student) throws IOException{
        this.student = student;
        this.dbExams = new DBExams();
        this.nameCourseAsociatted = nameCourseAsociatted;
        this.counterCorrectAnswers = 0;
        this.flag = false;
    }

    /**
     * Metodo que devuelve las preguntas asociadas a la materia en cuestion.
     * @return Set con las preguntas del examen
     */
    public Set<String> getQuestionsKeysExamns(){
        return dbExams.getQuestionsKeys(this.nameCourseAsociatted);
    }

    /**
     * Metodo que retorna un ArrayList con las respuestas asociadas a una pregunta en cuestion,
     * sin poseer la respuestas correcta dentro de estas.
     * @param question
     * @return ArrayList con las respuestas a una pregunta puntual sin la respuesta correcta
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
     * materia.
     * @return True si cuenta con el Item, False en caso contrario
     */
    public boolean checkStudentHasNecessaryItem(){
        boolean flag = false;
        for (Usable usable : student.getBackpack()){
            if (usable.getName().equals(dbExams.getItemNecesary(nameCourseAsociatted).getName())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Metodo que comprueba que el estudiante tenga los creditos necesarios para rendir
     * la materia en cuestion.
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

    /**
     * Metodo que incrementa el contador de respuesta correcta.
     */
    public void increaseCounterCorrectQuestions(){
        this.counterCorrectAnswers++;
        this.flag = true;
    }

    public int getCounterCorrectAnswers(){
        return counterCorrectAnswers;
    }

    /**
     * Metodo que devuelve el porcentaje de preguntas respondidas correctamente, en valor flotante
     * la cual tiene como tope maximo de 100 por ser el total de preguntas correctas, y de ahi
     * para abajo
     * @return valor flotante que representa el porcentaje de preguntas acertadas correctamente
     */
    public double percentageOfCorrectAnswers(){
        if (flag){
            return (double) (getCounterCorrectAnswers()*100)/this.getQuestionsKeysExamns().size();
        }else {
            return 0;
        }
    }

    /**
     * Metodo que devuelve la cantidad de vida a restar, dependiendo del resultado del examen.
     * @return Cantidad de vida a restar.
     */
    public int lifeToSubtractStudent(){
        if (flag){
            return (int)(Math.floor((this.getQuestionsKeysExamns().size() - this.getCounterCorrectAnswers())*(1/2)));
        }else {
            return 0;
        }
    }

    /**
     * Metodo que retorna la cantidad de creditos a aumentar al Estudiante por aprobar
     * la materia dictada por este profesor
     * @return Creditos a aumentar por aprobar la materia
     */
    public int increaseCreditsToApprove(){
        return this.dbExams.getCreditsForAprove(nameCourseAsociatted);
    }

    /**
     * Metodo que retorna un True si el examen fue pasado con el 60% de respuestas correctas,
     * o False en caso contrario, es decir, se desaprobo el examen
     * @return True si aprobo el examen, False si no es asi
     */
    public boolean examResult(){
        return (this.percentageOfCorrectAnswers()>=60);
    }

    /**
     * Metodo que devuelve un texto asociado a la instancia de aprobacion, desaprobacion o muerte,
     * tambien se realiza el descuento de la vida, aumento de creditos
     * @return Texto asociado al resultado del examen
     */
    public String examResultInfo(){
        if (flag){
            int life = this.student.getLifeAmount();
            life -= this.lifeToSubtractStudent();
            if (this.examResult() && life>0){
                this.student.decreaseLifeBar(lifeToSubtractStudent());
                this.student.addCredits(this.increaseCreditsToApprove());
                return "Examen aprobado! Se acertaron " + this.getCounterCorrectAnswers() +
                        " respuestas y se restaron " + this.lifeToSubtractStudent() + " puntos de vida.\n" +
                        "Felicidades, ya puedes ir por tu birra para festejar ;) ";
            }else if (life <= 0){
                this.student.decreaseLifeBar(lifeToSubtractStudent());
                return "No pudiste pasar soportar el estres de ser un Semi Dios, y moriste en el intento... " +
                        "Prueba en Abogacia o Filosofia.";
            }else {
                return "No pudiste pasar el examen, por no contar con los puntos necesarios para arpobarlo" +
                        ", repasa y vuelve en otra instancia.";
            }
        }else {
            return "El examen no ha sido rendido todavia, intente presentarse a rendir, cagon!";
        }
    }

}
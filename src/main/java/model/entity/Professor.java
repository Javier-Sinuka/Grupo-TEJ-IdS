package model.entity;

import model.objects.Usable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Professor {
    private String associatedSubjectName;
    private Student student;
    private DBExams dbExams;
    private int counterCorrectAnswers;
    private boolean flag;

    public Professor(String nameCourseAsociatted, Student student) throws IOException {
        this.student = student;
        this.dbExams = new DBExams();
        this.associatedSubjectName = nameCourseAsociatted;
        this.counterCorrectAnswers = 0;
        this.flag = false;
    }


    /**
     * Metodo que devuelve las preguntas asociadas a la materia en cuestion.
     *
     * @return Set con las preguntas del examen
     */

    public LinkedList<String> getQuestionsKeysExams() {
        return dbExams.getQuestionsKeys(this.associatedSubjectName);
    }

    /**
     * Metodo que retorna un ArrayList con las respuestas asociadas a una pregunta en cuestion,
     * inclyendo tambien la respuesta correcta.
     *
     * @param question
     * @return ArrayList con las respuestas a una pregunta puntual sin la respuesta correcta
     */
    public ArrayList<String> getAnswers(String question) {
        this.flag = true;
        return dbExams.getAnswers(associatedSubjectName, question);
    }

    /**
     * Metodo que devuelte la respuesta correcta asociada a una pregunta del examen
     * @param question
     * @return Respuesta correcta a la pregunta pasada
     */
    public String getCorrectOption (String question){
        return dbExams.getCorrectOption(associatedSubjectName, question);
    }

    /**
     * @return Nombre de la Materia asociado a este profesor
     */
    public String getAssociatedSubject () {
        return this.associatedSubjectName;
    }

    /**
     * @return Nombre del Profesor que dicta esta materia
     */
    public String getProfessorName () {
        return dbExams.getNameProfessor(associatedSubjectName);
    }

    /**
     * @return Apodo asociado al Profesor que dicta esta materia
     */
    public String getProfessorNickname () {
        return dbExams.getApodoProfessor(associatedSubjectName);
    }

    /**
     * @return Cantidad de creditos necesarios para cursar la materia
     */
    public int getNecessaryCredits () {
        return dbExams.getCreditsNecesary(associatedSubjectName);
    }

    /**
     * @return Item necesario para cursar esta materia
     */
    public Usable getNecessaryItem () {
        return dbExams.getItemNecesary(associatedSubjectName);
    }

    /**
     * Metodo que devuelve la ubicacion del Item necesario para rendir el examen
     * @return Ubicacion del Item necesario para rendir el examen
     */
    public String getItemLocation(){
        return dbExams.getItemUbication(associatedSubjectName);
    }

    /**
     * Metodo que chequea si el Estudiante posee el item necesario para rendir la
     * materia.
     * @return True si cuenta con el Item, False en caso contrario
     */
    public boolean studentHasItem () {
        boolean flag = false;
        for (Usable usable : student.getBackpack()) {
            if (usable.getName().equals(dbExams.getItemNecesary(associatedSubjectName).getName())) {
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
    public boolean studentHasCredits () {
        return student.getCredits() >= dbExams.getCreditsNecesary(associatedSubjectName);
    }

    /**
     * Metodo que comprueba si puede rendir o no el examen en cuestion.
     * @return True si puede rendir, False en caso contrario
     */
    public boolean canTakeExam () {
        return this.studentHasItem() && this.studentHasCredits();
    }

    /**
     * Metodo que incrementa el contador de respuesta correcta.
     */
    public void increaseCounterCorrectQuestions () {
        this.flag = true;
        this.counterCorrectAnswers++;
    }

    public void resetCounterCorrectQuestions(){ counterCorrectAnswers=0;}

    public int getCounterCorrectAnswers(){return counterCorrectAnswers;}

    /**
     * Metodo que devuelve el porcentaje de preguntas respondidas correctamente, en valor flotante
     * la cual tiene como tope maximo de 100 por ser el total de preguntas correctas, y de ahi
     * para abajo
     * @return valor flotante que representa el porcentaje de preguntas acertadas correctamente
     */
    public double percentageOfCorrectAnswers () {
        if (flag) {
            double t = (getCounterCorrectAnswers() * 100) / this.getQuestionsKeysExams().size();
            return t;
        } else {
            return 0;
        }
    }

    /**
     * Metodo que devuelve la cantidad de vida a restar, dependiendo del resultado del examen.
     * @return Cantidad de vida a restar.
     */
    public int lifeToSubtractStudent () {
        if (flag) {
//            int value = this.getQuestionsKeysExams().size() - this.getCounterCorrectAnswers();
//            int perccentage = (int) Math.round(value * (0.5));
            return 25;
        } else {
            return 0;
        }
    }

    /**
     * Metodo que retorna la cantidad de creditos a aumentar al Estudiante por aprobar
     * la materia dictada por este profesor
     * @return Creditos a aumentar por aprobar la materia
     */
    public int getCreditsIfPassed () {
        return this.dbExams.getCreditsForAprove(associatedSubjectName);
    }

    /**
     * Metodo que retorna un True si el examen fue pasado con el 60% de respuestas correctas,
     * o False en caso contrario, es decir, se desaprobo el examen
     * @return True si aprobo el examen, False si no es asi
     */
    public boolean examResult() {
        return (this.percentageOfCorrectAnswers() >= 60.00);
    }

    /**
     * Metodo que devuelve un texto asociado a la instancia de aprobacion, desaprobacion o muerte,
     * tambien se realiza el descuento de la vida, aumento de creditos
     * @return Texto asociado al resultado del examen
     */
    public String examResultInfo () {
        if (flag) {
            int life = this.student.getLifeAmount();
//            life -= this.lifeToSubtractStudent();
            if (this.examResult()){
                this.student.addCredits(this.getCreditsIfPassed());
                return "APROBASTE WACHIN!! acertaste: " + this.getCounterCorrectAnswers() +
                        " respuestas" + "\n" +
                        "Creditos adquiridos: "+ getCreditsIfPassed()+"\n"+
                        "Felicidades, ya podés ir por tu birra para festejar ;) ";
            } else if (life <= 0) {
                //this.student.decreaseLifeBar(lifeToSubtractStudent());
                return "No pudiste soportar el estres de ser un Semi Dios, y moriste en el intento... " +
                        "Probá en Abogacia o Filosofia.";

            } else {
                //this.student.decreaseLifeBar(25);
                return "Desaprobado, sos una desgracia para la ingeniería,ponete a estudiar y suerte en la próxima";
            }
        } else {
            return "El examen no ha sido rendido todavia, intente presentarse a rendir, cagon!";
        }
    }

}




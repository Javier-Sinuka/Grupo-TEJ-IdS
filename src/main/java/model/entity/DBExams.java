package main.java.model.entity;

import java.io.*;
import java.util.*;

public class DBExams {
    File file;
    Scanner scanner;
    Object[] matriz;
    private ArrayList<String> answers;
    private Map<String, Object[]> course;

    public DBExams(String path) throws IOException {
        this.matriz = new Object[4];
        this.course = new HashMap<>();
        this.answers = new ArrayList<>();

        this.file = new File(path);
        this.scanner = new Scanner(file);
        readerFile();
    }

    /**
     * Metodo que parsea un Archivo .TXT para leer la informacion del curso y separarla para
     * luego operarla de manera adecuada.
     */
    public void readerFile(){
        String storePhras = "";
        String keyQuestion = "";
        boolean flagQuestions = true, flag = true;
        try {
            while (scanner.hasNextLine()){
                String lineText = scanner.nextLine();
                if (lineText.startsWith("Materia:")){
                    storePhras = lineText.replaceAll("Materia: ", "");
                    flagQuestions = true;
                }
                else if
                (lineText.startsWith("Docente: ")){
                    matriz[0] = lineText.replaceFirst("Docente: ", "");
                }
                else if
                (lineText.startsWith("Cantidad de Creditos Necesarios: ")){
                    matriz[1] = lineText.replaceFirst("Cantidad de Creditos Necesarios: ", "");
                }
                else if
                (lineText.startsWith("Nombre del Item Necesario: ")){
                    matriz[2] = lineText.replaceFirst("Nombre del Item Necesario: ", "");
                }else if
                (lineText.startsWith("Preguntas:")){
                    Map<String, ArrayList<String>> questions = new HashMap<>();
                    while (flagQuestions){
                        String line = scanner.nextLine();
                        if (line.startsWith("¿")){
                            keyQuestion = line;
                            while (flag){
                                if (line.startsWith("- ")){
                                    answers.add(line.replaceFirst("- ", ""));
                                }else if ((line.startsWith("¿") && answers.size()!=0) || line.startsWith("***")){
                                    ArrayList<String> newList = new ArrayList<>(answers);
                                    questions.put(keyQuestion,newList);
                                    answers.clear();
                                    keyQuestion = line;
                                    if (line.startsWith("***")){
                                        flagQuestions = false;
                                        break;
                                    }
                                }
                                line = scanner.nextLine();
                            }
                        } else if (line.startsWith("***")){
                            flagQuestions = false;
                        }
                    }
                    matriz[3] = questions;
                    Object [] newMatriz = new Object[4];
                    for (int i = 0; i < matriz.length; i++){
                        newMatriz[i] = matriz[i];
                    }
                    course.put(storePhras, newMatriz);
                }
            }
        }catch (Exception e){}
    }

    public Map<String, Object[]> getCourse(){
        return course;
    }

    /**
     * Metodo que devuelve una lista de tipo Set con las llaves posibles,
     * dichas llaves son los nombres de los cursos disponibles
     * @return Nombre de cursos disponibles
     */
    public Set<String> getKeyCourseAvailable(){
        Set<String> claves = course.keySet();
        return claves;
    }

    /**
     * Provee el nombre del profesor asociado al curso en cuestion
     * @param nameCourse
     * @return Nombre del Profesor
     */
    public String getNameProfessor(String nameCourse){
        return this.course.get(nameCourse)[0].toString();
    }

    /**
     * Provee la cantidad de creditos necesarios para hacer el curso en cuestion
     * @param nameCourse
     * @return Creditos necesarios para la materia
     */
    public int getCreditsNecesary(String nameCourse){
        return Integer.parseInt(this.course.get(nameCourse)[1].toString());
    }

    /**
     * Provee el nombre del Item que se necesita para cursar la materia
     * @param nameCourse
     * @return Nombre del Item necesario para el curso
     */
    public String getItemNecesary(String nameCourse){
        return this.course.get(nameCourse)[2].toString();
    }

    /**
     * Metodo que devuelve un Mapa con las preguntas, y sus respuestas asociadas a dicha
     * pregunta.
     * @param nameCourse
     * @return Mapa con Preguntas como llave y de valor un ArrayList con las respuestas asociadas
     */
    public Map<String, ArrayList<String>> getQuestionsMap(String nameCourse){
        return (Map<String, ArrayList<String>>) this.course.get(nameCourse)[3];
    }

    /**
     * Metodo que devuelve un Set de tipo String, en el cual se encuentran las preguntas
     * asociadas a la materia en cuestion. Sirven como llave para el Mapa con las preguntas
     * asociada a las materias.
     * @param nameCourse
     * @return Set con las preguntas de la materia en cuestion
     */
    public Set<String> getQuestionsKeys(String nameCourse){
        Set<String> questionsKeys = this.getQuestionsMap(nameCourse).keySet();
        return questionsKeys;
    }

    /**
     * Metodo que devuelve las respuestas asociadas a una pregunta especifica de un curso especifico
     * pasado como parametro
     * @param nameCourse
     * @param question
     * @return ArrayList con las respuestas asociadas a la pregunta pasada como parametro
     */
    public ArrayList<String> getAnswers(String nameCourse, String question){
        ArrayList<String> newArrayAnswer = new ArrayList<>();
        for (String answer : getQuestionsMap(nameCourse).get(question)){
            if (answer.contains("{true}")){
            }else {
                newArrayAnswer.add(answer);
            }
        }
        return newArrayAnswer;
    }

    /**
     * Devuelve la respuesta correcta asociada a una pregunta en cuestion sobre un curso en especifico
     * @param nameCourse
     * @param question
     * @return Respuesta correccta de una pregunta especifica
     */
    public String getCorrectOption(String nameCourse, String question){
        String correctOption = "";
        for (String keyAnswer : getQuestionsMap(nameCourse).get(question)){
            if (keyAnswer.contains("{true}")){
                correctOption = keyAnswer.replace("{true}","");
            }
        }
        return correctOption;
    }
}

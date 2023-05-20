package main.java.model.entity;

import java.io.*;
import java.util.*;

public class DBExams {
    File file;
    Scanner scanner;
    Object[] matriz;
    private ArrayList<String> answers;
    private Map<String, Object[]> course;
    private Map<String, ArrayList<String>> questions;

    public DBExams(String path) throws IOException {
        this.matriz = new Object[4];
        this.course = new HashMap<>();
        this.answers = new ArrayList<>();
        this.questions = new HashMap<>();

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
     * Metodo que devuelve un arreglo de objetos en base a una llave,
     * dicha llave tiene que ser el nombre del curso al que se desea acceder.
     * @param key
     * @return Matriz de objetos con la informacion del curso
     */
    public Object[] getInfoCourse(String key){
        return this.course.get(key);
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
}

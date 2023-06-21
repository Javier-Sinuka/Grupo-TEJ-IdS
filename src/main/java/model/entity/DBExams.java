package model.entity;

import model.objects.Item;
import model.objects.Usable;

import java.io.*;
import java.util.*;

/**
 * Clase encargada de la lectura del archivo que contiene la informacion
 * de las materias, junto con su el nombre de su profesor, el item necesario
 * para rendir dicha materia, ademas de los creditos necesarios, tambien
 * se encarga de proveer la manera de poder acceder a las preguntas para
 * poder rendir el examen.
 */
public class DBExams {
    File file;
    Scanner scanner;
    Object[] matriz;
    private ArrayList<String> answers;
    private Map<String, Object[]> course;

    public DBExams() throws IOException {
        this.matriz = new Object[7];
        this.course = new HashMap<>();
        this.answers = new ArrayList<>();

        this.file = new File("src/main/assets/text/professor.txt");
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
                (lineText.startsWith("Cantidad de Creditos a aumentar si se aprueba el curso: ")){
                    matriz[2] = lineText.replaceFirst("Cantidad de Creditos a aumentar si se aprueba el curso: ", "");
                }
                else if
                (lineText.startsWith("Nombre del Item Necesario: ")){
                    String name = lineText.replaceFirst("Nombre del Item Necesario: ", "");
                    String description = "Ocupado para rendir examen en " + storePhras;
                    Item usable = new Item(name,description);
                    matriz[3] = usable;
                }else if
                (lineText.startsWith("Apodo: ")){
                    matriz[4] = lineText.replaceFirst("Apodo: ", "");
                }else if
                (lineText.startsWith("Lugar donde conseguir el Item necesario: ")){
                    matriz[5] = lineText.replaceFirst("Lugar donde conseguir el Item necesario: ", "");
                }else if
                (lineText.startsWith("Preguntas:")){
                    LinkedHashMap<String, ArrayList<String>> questions = new LinkedHashMap<>();
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
                    matriz[6] = questions;
                    Object [] newMatriz = new Object[7];
                    for (int i = 0; i < matriz.length; i++){
                        newMatriz[i] = matriz[i];
                    }
                    course.put(storePhras, newMatriz);
                }
            }
        }catch (Exception e){}
    }

    public Map<String,Object[]> getCourse(){
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
     * Cantidad de creditos que se ganan si se aprueba la materia en cuestion
     * @param nameCourse
     * @return Creditos que se ganan por aprobar la materia
     */
    public int getCreditsForAprove(String nameCourse){
        return Integer.parseInt(this.course.get(nameCourse)[2].toString());
    }

    /**
     * Provee el nombre del Item que se necesita para cursar la materia
     * @param nameCourse
     * @return Nombre del Item necesario para el curso
     */
    public Usable getItemNecesary(String nameCourse){
        return (Usable) this.course.get(nameCourse)[3];
    }

    /**
     * Metodo que retorna el Apodo del Profesor.
     * @param nameCourse
     * @return Apodo del Profesor
     */
    public String getApodoProfessor(String nameCourse){
        return this.course.get(nameCourse)[4].toString();
    }

    /**
     * Metodo que devuelve un texto que indica donde se puede econtrar el item necesario
     * para ingresar a rendir el examen.
     * @param nameCourse
     * @return Lugar donde encontrar el item necesario para el examen
     */
    public String getItemUbication(String nameCourse){
        return this.course.get(nameCourse)[5].toString();
    }

    /**
     * Metodo que devuelve un Mapa con las preguntas, y sus respuestas asociadas a dicha
     * pregunta.
     * @param nameCourse
     * @return Mapa con Preguntas como llave y de valor un ArrayList con las respuestas asociadas
     */
    public LinkedHashMap<String, ArrayList<String>> getQuestionsMap(String nameCourse){
        return (LinkedHashMap<String, ArrayList<String>>)  this.course.get(nameCourse)[6];
    }

    /**
     * Metodo que devuelve un Set de tipo String, en el cual se encuentran las preguntas
     * asociadas a la materia en cuestion. Sirven como llave para el Mapa con las preguntas
     * asociada a las materias.
     * @param nameCourse
     * @return Set con las preguntas de la materia en cuestion
     */
    public LinkedList<String> getQuestionsKeys(String nameCourse){
        LinkedList<String> questionsKeys = new LinkedList<>();
        for(String key : this.getQuestionsMap(nameCourse).keySet()){
            questionsKeys.add(key);
        }
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
        for (String answer : this.getQuestionsMap(nameCourse).get(question)){
            if (answer.contains("{true}")){
                newArrayAnswer.add(answer.replace("{true}",""));
            }else{
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

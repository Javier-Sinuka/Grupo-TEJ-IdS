package main.java.model.entity;

import java.util.ArrayList;

public class Professor {
    private String professorName;
    private ArrayList<String>questions;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<String> correctOptions;

    public Professor(){
        questions=new ArrayList<>();

        options=new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                ArrayList<String> newArrayList=new ArrayList<>();
                options.add(newArrayList);
            }
        }
        correctOptions=new ArrayList<>();
    }

    public void createExam(String subject){

        switch(subject){
            case "Introduccion a la Matematica":
                setProfessorName("Leonora el terror Vega");
                introMateExam();

            default:

        }

    }
    public  void introMateExam(){
        questions.add("question1");
        options.get(0).add("OptionA");
        options.get(0).add("OptionB");
        options.get(0).add("OptionC");
        correctOptions.add("OptionB");

        questions.add("question2");
        options.get(1).add("OptionD");
        options.get(1).add("OptionE");
        options.get(1).add("OptionF");
        correctOptions.add("OptionE");

        questions.add("question3");
        options.get(2).add("OptionG");
        options.get(2).add("OptionH");
        options.get(2).add("OptionI");
        correctOptions.add("OptionG");

        questions.add("question4");
        options.get(3).add("OptionJ");
        options.get(3).add("OptionK");
        options.get(3).add("OptionL");
        correctOptions.add("OptionL");

        questions.add("question5");
        options.get(4).add("OptionM");
        options.get(4).add("OptionN");
        options.get(4).add("OptionO");
        correctOptions.add("OptionM");
    }


    public String getProfessorName() {
        return professorName;
    }
    public void setProfessorName(String professorName) { this.professorName = professorName;}

    public ArrayList<String> getQuestions(){ return questions; }
    public ArrayList<ArrayList<String>> getOptions(){ return options;}
    public ArrayList<String> getCorrectOptions(){ return correctOptions;}

}
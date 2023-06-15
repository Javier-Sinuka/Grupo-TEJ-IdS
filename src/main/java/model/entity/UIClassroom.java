package model.entity;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIClassroom extends UIRoom {

    UIStudent uistudent;
    Classroom classroom;
    WindowButton exitButton;
    ExamStartButton examStartButton ;

    ExamButtons examButtons;

    JTextArea textArea;
    ImageIcon img;


    public UIClassroom(ImageIcon img,UIStudent uistudent,String subjectName,int roomID){
        super();
        this.img = img;
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(true);

        try{
            this.classroom = new Classroom(subjectName,roomID,uistudent.getStudent());
        }
        catch(Exception e){ System.out.println("something went wrong");}

        this.uistudent=uistudent;

        examStartButton=new ExamStartButton();
        exitButton=new WindowButton(50,100,150,50);
        examButtons=new ExamButtons();


    }
/*
    // change to setExitButton
    public void createExitButton(ArrayList<JPanel>rooms, UIStudent uiStudent, int roomID,int destinyID){

        exitButton.configureButton(rooms,uiStudent,"Salir del aula",roomID,destinyID);
    }

    public void createExamButtons(ArrayList<JPanel> rooms,String subject,int roomID,JTextArea textArea,UIStudent uistudent){

        this.textArea=textArea;

<<<<<<< HEAD
//        classroom.getProfessor().createExam(subject);
//        ArrayList<String>questions=classroom.getProfessor().getQuestions();
//        ArrayList<ArrayList<String>>options=classroom.getProfessor().getOptions();
//        ArrayList<String>correctOptions=classroom.getProfessor().getCorrectOptions();
//
//        optionMenu.setAsExamMenu(questions,options,correctOptions,rooms,textArea,roomID,uistudent,this);
=======
        classroom.getProfessor().createExam(subject);
        ArrayList<String>questions=classroom.getProfessor().getQuestions();
        ArrayList<ArrayList<String>>options=classroom.getProfessor().getOptions();
        ArrayList<String>correctOptions=classroom.getProfessor().getCorrectOptions();

        optionButtons.setAsExamButtons(questions,options,correctOptions,rooms,textArea,roomID,uistudent,this);
    }

    public void createExamStartButton(ArrayList<JPanel> roomsPanels, int roomID){
        ArrayList<String>questions=classroom.getProfessor().getQuestions();

        examStartButton=new UIButton(300,100,200,50);
        examStartButton.setAsExamStartButton(roomsPanels,roomID,questions,optionButtons,uistudent,textArea,this);
>>>>>>> feature/UIButton-UIclassroom
    }

    public void addBackgroundImage(ArrayList<JPanel>rooms,int roomID,String imagePath){
        JLabel label=new JLabel();
        label.setBounds(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        label.setIcon(image);
        label.setVisible(true);
        rooms.get(roomID).add(label);
    }


*/
public void setTextArea(JTextArea textArea,String initialText){
    textArea.setVisible(true);
    textArea.setBounds(61,540,520,150);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.white);
    textArea.setOpaque(true);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
    textArea.setText(initialText);
    this.textArea=textArea;
    this.add(textArea);
}
    public Classroom getClassroom(){ return classroom;}

    public ExamButtons getExamButtons() { return examButtons;}

    @Override
    public void setButton(WindowButton windowBt, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {

        windowBt.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom);
    }


    @Override
    public void setButton(ExamStartButton examBt,ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea){
        examBt.configureButton(rooms, roomID, uistudent, textArea, this);
    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {
        examBts.configureButton(rooms,roomID,uistudent,textArea,this);
    }

    public void addExamButton(JButton button){
       examButtons.addButton(button);
    }


    public void paintComponent(Graphics g){
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(), this);
    }



}

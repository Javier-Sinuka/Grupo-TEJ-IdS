package model.entity;


import javax.swing.*;
import java.util.ArrayList;

public class UIClassroom extends UIRoom {

    UIStudent uistudent;
    Classroom classroom;
    WindowButton exitButton;

    ExamStartButton examStartButton ;
   // UIButton examStartButton;
    JTextArea textArea;
    ImageIcon img;


    public UIClassroom(ImageIcon img,UIStudent uistudent){
        super();
        this.img = img;
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        this.setOpaque(true);

        this.classroom = new Classroom();
        this.uistudent=uistudent;

        examStartButton=new ExamStartButton(300,100,200,50);
        exitButton=new WindowButton(50,100,150,50);


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

    public void setTextArea(JTextArea textArea,String initialText){
        textArea.setVisible(true);
        textArea.setBounds(1,500,450,150);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.white);
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
        textArea.setText(initialText);
        this.textArea=textArea;
        panel.add(textArea);
    }

*/
    public Classroom getClassroom(){ return classroom;}

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {

    }

    /*
    public void paintComponent(Graphics g){
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(), this);
    } */



}

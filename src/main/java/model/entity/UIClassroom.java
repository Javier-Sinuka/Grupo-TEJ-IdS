package main.java.model.entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UIClassroom extends JPanel {

    UIStudent uistudent;
    Classroom classroom;
    UIButton exitButton;
    UIButton optionMenu;
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
    }

    public void createExitButton(ArrayList<JPanel>rooms, UIStudent uiStudent, int roomID,int destinyID){
        exitButton=new UIButton(50,100,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Salir del aula",roomID,destinyID);
    }

    public void createOptionMenu(ArrayList<JPanel> rooms,String subject,int roomID,JTextArea textArea,UIStudent uistudent){
        this.textArea=textArea;
        optionMenu=new UIButton(500,500,500,500);

//        classroom.getProfessor().createExam(subject);
//        ArrayList<String>questions=classroom.getProfessor().getQuestions();
//        ArrayList<ArrayList<String>>options=classroom.getProfessor().getOptions();
//        ArrayList<String>correctOptions=classroom.getProfessor().getCorrectOptions();
//
//        optionMenu.setAsExamMenu(questions,options,correctOptions,rooms,textArea,roomID,uistudent,this);
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
        this.add(textArea);
    }
    public void paintComponent(Graphics g){
        g.drawImage(img.getImage(),0,0,getWidth(),getHeight(), this);
    }
}
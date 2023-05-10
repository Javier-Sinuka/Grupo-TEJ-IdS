package main.java.model.entity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UIClassroom extends JPanel {

    Classroom classroom;
    UIButton exitButton;

    UIButton optionMenu;

    JTextArea textArea;


    public UIClassroom(){
        super();
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setVisible(false);
        this.setLayout(null);
        //newRoom.add(title);
    }

    public void createExitButton(ArrayList<JPanel>rooms, UIStudent uiStudent, int roomID,int destinyID){
        exitButton=new UIButton(50,100,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Salir del aula",roomID,destinyID);
    }
    public void createExam(){

        // work on this next thursday,use setAsOptionMenu()
    }

    public void addBackgroundImage(ArrayList<JPanel>rooms,int roomID,String imagePath){
        JLabel label=new JLabel();
        label.setBounds(0,0,GameWindow.WIDTH,GameWindow.HEIGHT);
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        label.setIcon(image);
        label.setVisible(true);
        rooms.get(roomID).add(label);
    }



}

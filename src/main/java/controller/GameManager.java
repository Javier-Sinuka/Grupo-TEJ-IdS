package main.java.controller;

import main.java.model.entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private UIStudent uiStudent;

    private GameWindow window;

    private ArrayList<JPanel> rooms;

    private JTextArea textArea;

    public GameManager(){

        window=new GameWindow();
        rooms=new ArrayList<>();
        textArea=new JTextArea();
        textArea=new JTextArea();
        textArea.setVisible(true);
        textArea.setBounds(1,500,450,150);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.white);
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Book Antiqua",Font.PLAIN,18));
        textArea.setText("HELLO THERE!");
        createRooms(createRoomTypeArray());
        setUpRooms();

    }

    private ArrayList<String> createRoomTypeArray(){

        ArrayList<String>roomTypes=new ArrayList<>();
        roomTypes.add("");
        //roomTypes.add("Hallway");
        roomTypes.add("Classroom");
        //roomTypes.add("Classroom");

        return roomTypes;
    }

    private void createRooms(ArrayList<String>roomType){

        for(String room:roomType){

            switch(room){

                case "Classroom":
                    UIClassroom newClassroom=new UIClassroom();
                    rooms.add(newClassroom);
                    break;
                case "Hallway":
                    UIHallway newHallway= new UIHallway();
                    rooms.add(newHallway);
                    break;
                case "Store":
                    UIStore newStore= new UIStore();
                    rooms.add(newStore);
                    break;
                default:
                    // start menu
                    JPanel menu=new JPanel();
                    menu.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
                    menu.setVisible(false);
                    menu.setLayout(null);
                    rooms.add(menu);
            }
        }
    }

    public void setUpRooms(){
        createMenu();
        roomOne();
        //roomTwo();
        //roomThree();
    }

    private void createMenu(){

        rooms.get(0).setVisible(true);

        JLabel title = new JLabel("Game name");
        title.setBounds(270,100,500,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        title.setVisible(true);

        UIButton obj1=new UIButton(350,300,150,50);
        obj1.setAsWindowButton(rooms,uiStudent,"START GAME",0,1);

        rooms.get(0).add(title);
        window.add(rooms.get(0));

    }

    private void roomOne(){

        //Se realiza downcasting para poder setear los botones
        UIClassroom classroom1=(UIClassroom) rooms.get(1);
        classroom1.add(textArea);
        classroom1.createExitButton(rooms,uiStudent,1,0);
        classroom1.createOptionMenu(rooms,"Introduccion a la Matematica",1,textArea);
        classroom1.addBackgroundImage(rooms,1,"main/assets/img/Mi proyecto.png");

        rooms.add(classroom1);
        window.add(rooms.get(1));
    }
    private void roomTwo(){

        /*
        rooms.get(2).add(textArea);
        UIButton button1= new UIButton(1000,300,150,50);
        button1.setAsWindowButton(rooms,uiStudent,"Room 1",2,1);
        UIButton button2= new UIButton(500,500,500,50);
        ArrayList<String> options= new ArrayList<>();
        options.add("text text text text text text text text");
        options.add("Option2");
        options.add("Option3");
        //options.add("Option4");
        button2.setAsOptionMenu(options,1,rooms,textArea,2);
        window.add(rooms.get(2));*/
    }

    private void roomThree(){

/*
        //roomsPanels[3].add(student.getDataPanel());
        rooms.get(3).setBackground(Color.blue); //Cambiar el fonde del room con la foto
        UIButton button1= new UIButton(50,300,150,50);
        button1.setAsWindowButton(rooms,uiStudent,"Room 1",3,1);
        //roomsPanels[3].add(student.getDataPanel());
        window.add(rooms.get(3)); */
    }
    public GameWindow getWindow(){
        return window;
    }


}

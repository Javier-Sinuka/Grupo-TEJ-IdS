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
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>();
        textArea=new JTextArea();
        ArrayList<String>roomTypes=new ArrayList<>();
        roomTypes.add("");
        createRooms(roomTypes);
        setUpRooms();
    }

    private void createRooms(ArrayList<String>roomType){

        for(String room:roomType){

            switch(room){

                case "Classroom":
                    UIClassroom newClassroom=new UIClassroom();
                    rooms.add(newClassroom);
                    break;
                case "Hallway":
                    UIHallway newHallway= new UIHallway("asd",Color.gray);
                    rooms.add(newHallway);
                    break;
                case "Store":
                    UIStore newStore= new UIStore(uiStudent,true);
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
        createMenu();   //0
        hallway1();     //1
        classRoom1();   //2
        store1();       //4
        hallway2();     //5
    }
    //Menu preincipal (inicio)
    private void createMenu(){

        rooms.get(0).setVisible(true);

        //Titulo del juego
        JLabel title = new JLabel("Game name");
        title.setBounds(270,100,500,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        rooms.get(0).add(title);

        //Boton de comienzo
        UIButton obj1=new UIButton(350,300,150,50);
        obj1.setAsWindowButton(rooms,uiStudent,"START GAME",0,1);

        window.add(rooms.get(0));

    }
    //Primer pasillo
    private void hallway1 (){
        UIHallway newHallway= new UIHallway("Hallway 1",Color.gray);
        rooms.add(newHallway);

        //Boton para ir al Hallway2
        UIButton hallway2Button = new UIButton(500,0,150,50);
        hallway2Button.setAsWindowButton(rooms,uiStudent,"Hallway 2",1,5);

        //Boton para ir al classrom 1
        UIButton classroomButton1 = new UIButton(1130,300,150,50);
        classroomButton1.setAsWindowButton(rooms,uiStudent,"Classroom1",1,2);

        //Boton para ir al classrom 2
        UIButton classroomButton2 = new UIButton(0,300,150,50);
        classroomButton2.setAsWindowButton(rooms,uiStudent,"Classroom2",1,6);

        //Boton para ir al classrom 3
        UIButton classroomButton3 = new UIButton(500,630,150,50);
        classroomButton3.setAsWindowButton(rooms,uiStudent,"Classroom3",1,7);

        window.add(rooms.get(1));
    }
    //Segundo pasillo
    private void hallway2 (){
        UIHallway newHallway= new UIHallway("Hallway 2",Color.blue);
        rooms.add(newHallway);

        //Boton para ir al store
        UIButton storeButton = new UIButton(500,0,150,50);
        storeButton.setAsWindowButton(rooms,uiStudent,"Store",5,4);

        //Boton para ir al hallway1
        UIButton hallway1Button = new UIButton(500,630,150,50);
        hallway1Button.setAsWindowButton(rooms,uiStudent,"Hallway 1",5,1);

        window.add(rooms.get(5));
    }
    //Aula 1
    private void classRoom1(){

        UIClassroom classroom = new UIClassroom();
        rooms.add(classroom);

        //rooms.get(2).setBackground(Color.BLACK);
        //Se realiza downcasting para poder setear el boton
        classroom.createExitButton(rooms,uiStudent,2,1);
        //classroom1.addBackgroundImage(rooms,2,"main/assets/img/Mi proyecto.png");
        rooms.add(classroom);
        window.add(rooms.get(2));

        //Parte del examen
        rooms.get(2).add(textArea);
        UIButton button2= new UIButton(500,500,500,50);
        ArrayList<String> options= new ArrayList<>();
        options.add("text text text text text text text text");
        options.add("Option2");
        options.add("Option3");
        //options.add("Option4");
        button2.setAsOptionMenu(options,"Option 2",rooms.get(2),textArea);

    }
    //Bar
    private void store1(){
        UIStore uiStore = new UIStore(uiStudent,true);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        UIButton exitButton = new UIButton(1100,620,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Exit",4,5);

        window.add(rooms.get(4));
    }
    public GameWindow getWindow(){
        return window;
    }


}

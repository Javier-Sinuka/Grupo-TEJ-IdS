package main.java.controller;
import main.java.model.entity.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    public UIStudent uiStudent;
    private GameWindow window;
    private ArrayList<JPanel> rooms;
    private JTextArea textArea;

    public GameManager(){
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>();
        textArea=new JTextArea();

        setUpRooms();
    }
    public void setUpRooms(){
        createMenu();   //0
        hallway1();     //1
        classRoom1();   //2
        store1();       //3
        hallway2();     //4
        store2();       //5
    }
    //Menu preincipal (inicio)
    private void createMenu(){
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/Facultad.png"));
        MainMenu mainMenu = new MainMenu(img);
        rooms.add(mainMenu);

        //Boton de comienzo
        UIButton obj1=new UIButton(440,360,400,100);
        obj1.setAsWindowButton(rooms,uiStudent,"START GAME",0,1);
        window.add(rooms.get(0));
    }
    //Primer pasillo
    private void hallway1 (){
        UIHallway newHallway= new UIHallway("Hallway 1",Color.gray);
        rooms.add(newHallway);

        //Boton para ir al Hallway2
        UIButton hallway2Button = new UIButton(500,0,150,50);
        hallway2Button.setAsWindowButton(rooms,uiStudent,"Hallway 2",1,4);

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
        storeButton.setAsWindowButton(rooms,uiStudent,"Store",4,3);

        //Boton para ir al store2
        UIButton storeButton2 = new UIButton(0,300,150,50);
        storeButton2.setAsWindowButton(rooms,uiStudent,"Store2",4,5);

        //Boton para ir al hallway1
        UIButton hallway1Button = new UIButton(500,630,150,50);
        hallway1Button.setAsWindowButton(rooms,uiStudent,"Hallway 1",4,1);

        window.add(rooms.get(4));
    }
    //Aula 1
    private void classRoom1(){

        //Se realiza downcasting para poder setear los botones
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/Facultad.png"));
        UIClassroom classroom1 = new UIClassroom(img,uiStudent);
        rooms.add(classroom1);

        classroom1.setTextArea(textArea,"HELLO THERE!");
        classroom1.createExitButton(rooms,uiStudent,2,1);
        classroom1.createOptionMenu(rooms,"Introduccion a la Matematica",2,textArea,uiStudent);
        //classroom1.addBackgroundImage(rooms,2,"main/assets/img/Mi proyecto.png");
        window.add(rooms.get(2));
    }
    private void store1(){
        UIStore uiStore = new UIStore(uiStudent,false);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        UIButton exitButton = new UIButton(1100,620,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Exit",3,4);

        window.add(rooms.get(3));
    }
    private void store2(){
        UIStore uiStore = new UIStore(uiStudent,true);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        UIButton exitButton = new UIButton(1100,620,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Exit",5,4);

        window.add(rooms.get(5));
    }
    public GameWindow getWindow(){
        return window;
    }


}

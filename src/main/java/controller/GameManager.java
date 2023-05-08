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
        //roomTypes.add("Classroom");
        //roomTypes.add("Classroom");
        //roomTypes.add("Classroom");
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
                    UIHallway newHallway= new UIHallway();
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
        uiStudent.getDataPanel().setVisible(true);
        window.add(uiStudent.getDataPanel());
        createMenu();   //0
        hallway1();     //1
        classRoom1();   //2
        store1();       //3
        //roomThree();  //4
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
        UIHallway newHallway= new UIHallway();
        rooms.add(newHallway);

        JLabel title = new JLabel("Hallway 1");
        title.setBounds(640,300,100,50);

        //Boton para ir al store
        UIButton storeButton = new UIButton(500,0,150,50);
        storeButton.setAsWindowButton(rooms,uiStudent,"Store",1,4);

        //Boton para ir al classrom 1
        UIButton classroomButton1 = new UIButton(1130,300,150,50);
        classroomButton1.setAsWindowButton(rooms,uiStudent,"Classroom1",1,2);

        //Boton para ir al classrom 2
        UIButton classroomButton2 = new UIButton(0,300,150,50);
        classroomButton2.setAsWindowButton(rooms,uiStudent,"Classroom2",1,5);

        //Boton para ir al classrom 3
        UIButton classroomButton3 = new UIButton(500,630,150,50);
        classroomButton3.setAsWindowButton(rooms,uiStudent,"Classroom3",1,6);

        rooms.get(1).setBackground(Color.gray);
        rooms.get(1).add(title);
        window.add(rooms.get(1));
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
    //Tienda
    private void store1(){
        UIStore uiStore = new UIStore(uiStudent,false);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        UIButton exitButton = new UIButton(1100,620,150,50);
        exitButton.setAsWindowButton(rooms,uiStudent,"Exit",4,1);

        window.add(rooms.get(4));
    }
    private void roomThree(){
        //roomsPanels[3].add(student.getDataPanel());
        rooms.get(3).setBackground(Color.blue); //Cambiar el fonde del room con la foto
        UIButton button1= new UIButton(50,300,150,50);
        button1.setAsWindowButton(rooms,uiStudent,"Room 1",3,1);
        //roomsPanels[3].add(student.getDataPanel());
        window.add(rooms.get(3));
    }
    public GameWindow getWindow(){
        return window;
    }


}

package controller;

import model.entity.*;
import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    public UIStudent uiStudent;
    private GameWindow window;
    private ArrayList<UIRoom> rooms;
    private JTextArea textArea;
    private ArrayList<Usable> usables;

    public GameManager(){
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>(10);
        textArea=new JTextArea();
        usables = new ArrayList<Usable>();

        setUpUsables();
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
    private void createMenu(){
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/EntradaFacultad.png");
        UIMainMenu mainMenu = new UIMainMenu(img);
        rooms.add(mainMenu);


        //Boton de comienzo

        WindowButton WB1=new WindowButton(440,360,400,100);

        mainMenu.setButton(WB1,rooms,uiStudent,"START GAME",0,1);
        window.add(rooms.get(0));

        WindowButton wb1=new WindowButton(440,360,400,100);
        mainMenu.setButton(wb1,rooms,uiStudent,"START GAME",0,1);

        mainMenu.addBackgroundImage(img);

        window.add(mainMenu);

    }
    public void hallway1(){

        String path = "src/main/assets/img/map/Lobby_Central.png";
        Consumable consumable = new Consumable("Mate","Mate amargo");
        Item item = new Item("Tablero de dibujo", "Tabala que te ayudara a rendir dibujo");

        UIHallway hallway1= new UIHallway("Hallway 1 ",Color.BLUE,null,null,path);
        rooms.add(hallway1);

        WindowButton wb1=new WindowButton(500,0,150,50);
        hallway1.setButton(wb1,rooms,uiStudent,"Classroom 1",1,2);

        WindowButton wb2=new WindowButton(0,300,150,50);
        hallway1.setButton(wb2,rooms,uiStudent,"Hallway 2",1,4);

        window.add(hallway1);

        //hallway1.add(uiStudent.getDataPanel());
    }
    private void classRoom1() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/IMG_20230608_172253307_HDR.jpg");
        UIClassroom classroom1 = new UIClassroom(img,uiStudent,"Fisica I",2);
        rooms.add(classroom1);

        classroom1.setTextArea(textArea,classroom1.getClassroom().getProfessor().getProfessorNickname()+ ": Bienvenido Víctima");

       WindowButton exitButton=new WindowButton(570,20,150,50);
       classroom1.setButton(exitButton,rooms,uiStudent,"Exit",2,1);

       classroom1.setButton(new ExamButtons(),rooms,2,uiStudent,textArea);

       classroom1.setButton(new ExamStartButton(),rooms,2,uiStudent,textArea);


       window.add(rooms.get(2));


       classroom1.addProfessorImage(640,150,230,330,"src/main/assets/img/ProfessorsImages/Vega.png");

    }
    private void store1() {
        UIStore store1 = new UIStore(uiStudent,false);
        rooms.add(store1);

        //Boton para salir de la tienda
        WindowButton exitButton=new WindowButton(1100,620,150,50);
        store1.setButton(exitButton,rooms,uiStudent,"Exit",3,4);

        window.add(rooms.get(3));

       // store1.add(uiStudent.getDataPanel());
    }
    private void hallway2() {
        String path = "src/main/assets/img/map/Playa_estacionamiento.png";
        Consumable consumable = new Consumable("Cafe","Cafe rico");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir quimica");

        UIHallway hallway2= new UIHallway("Hallway 2",Color.blue, consumable,item,path);
        rooms.add(hallway2);

        //Boton para ir al store
        WindowButton storeButton=new WindowButton(500,0,150,50);
        hallway2.setButton(storeButton,rooms,uiStudent,"Store",4,3);

        //Boton para ir al store2
        WindowButton storeButton2 = new WindowButton(0,300,150,50);
        hallway2.setButton(storeButton2,rooms,uiStudent,"Store2",4,5);

        //Boton para ir al hallway1
        WindowButton hallway1Button = new WindowButton(500,630,150,50);
        hallway2.setButton(hallway1Button,rooms,uiStudent,"Hallway 1",4,1);

        window.add(rooms.get(4));

        //hallway2.add(uiStudent.getDataPanel());

    }
    private void store2() {

        UIStore store2 = new UIStore(uiStudent,true);
        rooms.add(store2);

        //Boton para salir de la tienda
        WindowButton exitButton = new WindowButton(1100,620,150,50);
        store2.setButton(exitButton,rooms,uiStudent,"Exit",5,4);

        window.add(rooms.get(5));

        //store2.add(uiStudent.getDataPanel());

    }

    public void setUpUsables(){
        Usable drawingBoar = new Item("Tablero de dibujo", "Este tablero te ayudara a rendir Representacion Grafica");
        Usable notebook = new Item("Notebook", "Esta notebook te ayudara a rendir Informatica");
        Usable periodicTable = new Item("Tabla periodica", "Esta tabla te ayudara a rendir Quimica");
        Usable algebraBook = new Item("Libro de algebra", "Este libro te ayudara a rendir Algebra");
        Usable ieBook = new Item("Libro de introduccion a la ingenieria", "Este libro te ayudara a rendir Introduccion a la Ingenieria");

        usables.add(drawingBoar);
        usables.add(notebook);
        usables.add(periodicTable);
        usables.add(algebraBook);
        usables.add(ieBook);
    }
    public GameWindow getWindow(){
        return window;
    }


}

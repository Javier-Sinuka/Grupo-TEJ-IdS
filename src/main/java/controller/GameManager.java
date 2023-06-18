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
        hallway2();     //2
        hallway3();     //3
        //classRoom1();   //4
        store1();       //5
        store2();       //6
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
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/lobbyDeIngreso.jpg");
        String path = "src/main/assets/img/map/Lobby_Central.png";
        Consumable consumable = new Consumable("Mate","El mate te despertara");

        UIHallway hallway1= new UIHallway(uiStudent, consumable, usables, path,true,img);

        rooms.add(hallway1);

        WindowButton wb1=new WindowButton(500,0,150,50);
        hallway1.setButton(wb1,rooms,uiStudent,"Pasillo 4",1,4);

        WindowButton wb2=new WindowButton(0,300,150,50);
        hallway1.setButton(wb2,rooms,uiStudent,"Pasillo 2",1,2);

        WindowButton wb3=new WindowButton(1000,300,150,50);
        hallway1.setButton(wb3,rooms,uiStudent,"Pasillo 3",1,3);

        WindowButton wb4=new WindowButton(500,300,150,50);
        hallway1.setButton(wb4,rooms,uiStudent,"Pasillo 8",1,8);
        window.add(hallway1);

    }
    private void hallway2() {
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo2.jpg");
        String mapPath = "src/main/assets/img/map/Playa_estacionamiento.png";
        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");


        UIHallway hallway2= new UIHallway(uiStudent, consumable, usables,mapPath,false,img);
        rooms.add(hallway2);

        //Boton para ir al
        WindowButton storeButton=new WindowButton(1000,300,150,50);
        hallway2.setButton(storeButton,rooms,uiStudent,"Pasillo 1",2,1);

        //Boton para ir al store2
        WindowButton storeButton2 = new WindowButton(0,300,150,50);
        hallway2.setButton(storeButton2,rooms,uiStudent,"Patio",2,6);

        //Boton para ir al hallway1
        WindowButton hallway1Button = new WindowButton(500,630,150,50);
        hallway2.setButton(hallway1Button,rooms,uiStudent,"Aula 214",2,11);

        window.add(hallway2);
    }
    private void hallway3() {
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo3.jpg");
        String mapPath = "src/main/assets/img/map/Playa_estacionamiento.png";
        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");


        UIHallway hallway2= new UIHallway(uiStudent, consumable, usables,mapPath,false,img);
        rooms.add(hallway2);

        //Boton para ir al
        WindowButton storeButton=new WindowButton(1000,300,150,50);
        hallway2.setButton(storeButton,rooms,uiStudent,"Pasillo 1",3,1);

        //Boton para ir al store2
        WindowButton storeButton2 = new WindowButton(0,300,150,50);
        hallway2.setButton(storeButton2,rooms,uiStudent,"Aula 200",3,9);

        window.add(hallway2);
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

package controller;

import model.entity.*;
import model.objects.Consumable;
import model.objects.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    public UIStudent uiStudent;
    private GameWindow window;
    private ArrayList<UIRoom> rooms;
    private JTextArea textArea;

    public GameManager(){
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>(10);
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

        UIHallway hallway1= new UIHallway("Hallway 1 ",Color.BLUE,consumable,item,path);
        rooms.add(hallway1);

        WindowButton wb1=new WindowButton(500,0,150,50);
        hallway1.setButton(wb1,rooms,uiStudent,"Classroom 1",1,2);

        WindowButton wb2=new WindowButton(0,300,150,50);
        hallway1.setButton(wb2,rooms,uiStudent,"Hallway 2",1,4);

        window.add(hallway1);
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
        UIStore uiStore = new UIStore(uiStudent,false);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        WindowButton exitButton=new WindowButton(1100,620,150,50);
        uiStore.setButton(exitButton,rooms,uiStudent,"Exit",3,4);

        window.add(rooms.get(3));
    }
    private void hallway2() {
        String path = "src/main/assets/img/map/Playa_estacionamiento.png";
        Consumable consumable = new Consumable("Cafe","Cafe rico");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir quimica");

        UIHallway newHallway= new UIHallway("Hallway 2",Color.blue, consumable,item,path);
        rooms.add(newHallway);

        //Boton para ir al store
        WindowButton storeButton=new WindowButton(500,0,150,50);
        newHallway.setButton(storeButton,rooms,uiStudent,"Store",4,3);

        //Boton para ir al store2
        WindowButton storeButton2 = new WindowButton(0,300,150,50);
        newHallway.setButton(storeButton2,rooms,uiStudent,"Store2",4,5);

        //Boton para ir al hallway1
        WindowButton hallway1Button = new WindowButton(500,630,150,50);
        newHallway.setButton(hallway1Button,rooms,uiStudent,"Hallway 1",4,1);

        window.add(rooms.get(4));

    }
    private void store2() {

        UIStore uiStore = new UIStore(uiStudent,true);
        rooms.add(uiStore);

        //Boton para salir de la tienda
        WindowButton exitButton = new WindowButton(1100,620,150,50);
        uiStore.setButton(exitButton,rooms,uiStudent,"Exit",5,4);

        window.add(rooms.get(5));

    }
    public GameWindow getWindow(){
        return window;
    }


}

package controller;

import model.entity.*;
import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager implements Subject{

    public UIStudent uiStudent;
    private GameWindow window;
    private ArrayList<UIRoom> rooms;
    private ArrayList<Observer>observers;
    private JTextArea textArea;

    public GameManager(){
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>(10);
        textArea=new JTextArea();
        observers=new ArrayList<>();

        setUpRooms();
    }
    public void setUpRooms(){

        registerObserver(uiStudent);

        createMenu();   //0
        hallway1();     //1
        hallway2();     //2
        hallway3();     //3
        hallway4();     //4
        hallway5();     //5
        hallway6();     //6
        hallway7();     //7
        hallway8();     //8
        classRoom1();   //9
        classRoom2();   //10
        classRoom3();   //11
        classRoom4();   //12
        classRoom5();   //13
        classRoom6();   //14
        classRoom7();   //15
        classRoom8();   //16
        classRoom9();   //17
        store1();       //18
        store2();       //19

        gameOver();
    }
    private void createMenu(){
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/EntradaFacultad.png");
        UIMainMenu mainMenu = new UIMainMenu(img);
        rooms.add(mainMenu);

        //Boton de comienzo
        WindowButton WB1=new WindowButton(440,420,400,100);

        mainMenu.setButton(WB1,rooms,uiStudent,"START GAME",0,1,true);
        window.add(rooms.get(0));

        mainMenu.addBackgroundImage(img);

        window.add(mainMenu);

    }
    public void hallway1(){

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/lobbyDeIngreso.jpg");
        String path = "src/main/assets/img/map/Lobby_Central.png";
        Consumable consumable = new Consumable("Mate","Mate amargo");
        Item item = new Item("Tablero de dibujo", "Tabala que te ayudara a rendir dibujo");

        UIHallway hallway1= new UIHallway(uiStudent, null, null, path,true,img);
        rooms.add(hallway1);

        WindowButton wb1=new WindowButton(550,20,150,50);
        hallway1.setButton(wb1,rooms,uiStudent,"Pasillo 4",1,4,false);

        WindowButton wb2=new WindowButton(20,300,150,50);
        hallway1.setButton(wb2,rooms,uiStudent,"Pasillo 2",1,2,false);

        WindowButton wb3=new WindowButton(1100,300,150,50);
        hallway1.setButton(wb3,rooms,uiStudent,"Pasillo 3",1,3,false);

        WindowButton wb4=new WindowButton(550,600,150,50);
        hallway1.setButton(wb4,rooms,uiStudent,"Estacionamiento",1,8,false);

        window.add(hallway1);

        registerObserver(hallway1);
    }
    private void hallway2() {
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo2.jpg");
        String path = "src/main/assets/img/map/Pasilla_Aula_214.png";
        Consumable consumable = new Consumable("Cafe","Cafe rico");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir quimica");

        UIHallway hallway2= new UIHallway(uiStudent, consumable, item,path,false,img);
        rooms.add(hallway2);

        //Boton para ir al store
        WindowButton wb1=new WindowButton(600,20,150,50);
        hallway2.setButton(wb1,rooms,uiStudent,"Patio Central",2,6,false);

        //Boton para ir al store2
        WindowButton wb2 = new WindowButton(20,350,150,50);
        hallway2.setButton(wb2,rooms,uiStudent,"Aula 214",2,1,false);

        //Boton para ir al hallway1
        WindowButton wb3 = new WindowButton(600,610,150,50);
        hallway2.setButton(wb3,rooms,uiStudent,"Lobby Central",2,1,false);

        window.add(rooms.get(2));

        //hallway2.add(uiStudent.getDataPanel());

    }
    private void hallway3() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo3.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_200.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3= new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        //Boton para ir al
        WindowButton wb1=new WindowButton(500,600,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Lobby Central",3,1,false);

        //Boton para ir al store2
        WindowButton wb2 = new WindowButton(500,20,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 200",3,9,false);

        window.add(hallway3);

    }
    private void hallway4() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo4.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_1.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3= new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Aula 104",4,1,false);

        WindowButton wb2 = new WindowButton(20,300,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Pasillo 5",4,5,false);

        WindowButton wb3=new WindowButton(500,600,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Lobby Central",4,1,false);

        window.add(hallway3);

    }
    private void hallway5() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo5.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_2.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(550,600,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Pasillo 4",5,4,false);

        WindowButton wb2 = new WindowButton(1100,250,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 114",5,1,false);

        WindowButton wb3=new WindowButton(20,250,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Aula 107",5,1,false);

        window.add(hallway3);

    }
    private void hallway6() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/patioCentral.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_2.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Bar",6,18,false);

        WindowButton wb2 = new WindowButton(600,600,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Pasillo 2",6,2,false);

        WindowButton wb3=new WindowButton(20,300,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Pasillo 7",6,7,false);

        WindowButton wb4=new WindowButton(600,20,150,50);
        hallway3.setButton(wb4,rooms,uiStudent,"Aula 254",6,1,false);

        window.add(hallway3);

    }
    private void hallway7() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo7.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_2.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Aula 219",7,6,false);

        WindowButton wb2 = new WindowButton(600,600,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 225",7,2,false);

        WindowButton wb3=new WindowButton(1100,150,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Aula 218",7,1,false);

        WindowButton wb4=new WindowButton(600,20,150,50);
        hallway3.setButton(wb4,rooms,uiStudent,"Patio Central",7,6,false);

        window.add(hallway3);

    }
    private void hallway8() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo8.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_2.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(550,610,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Lobby Central",8,1,false);

        WindowButton wb2 = new WindowButton(1050,150,200,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Electronica Argentina",8,19,false);

        window.add(hallway3);

    }
    private void classRoom1() {

        //Aula 200 --> Analisis matematico I [Tabla de Integrales]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/IMG_20230608_172253307_HDR.jpg");
        UIClassroom classroom1 = new UIClassroom(img,uiStudent,"Fisica I",2);
        rooms.add(classroom1);

        classroom1.setTextArea(textArea,classroom1.getClassroom().getProfessor().getProfessorNickname()+ ": Bienvenido Víctima");

       WindowButton exitButton=new WindowButton(570,20,150,50);
       classroom1.setButton(exitButton,rooms,uiStudent,"Exit",9,3,false);

       classroom1.setButton(new ExamButtons(),rooms,9,uiStudent,textArea);

       classroom1.setButton(new ExamStartButton(),rooms,9,uiStudent,textArea);

       window.add(rooms.get(9));

       registerObserver(classroom1);

       classroom1.addProfessorImage(640,150,230,330,"src/main/assets/img/ProfessorsImages/Vega.png");

    }
    private void classRoom2(){
        //Aula 104 --> Algebra [Libro de Algebra]
        rooms.add(null);
    }
    private void classRoom3(){
        //Aula 214 --> Representacion Grafica [Tablero de dibujo]
        rooms.add(null);
    }
    private void classRoom4(){
        //Aula 107 --> Informatica [Notebook]
        rooms.add(null);
    }
    private void classRoom5(){
        //Aula 114 --> Taller y Laboratorio [Kit de electronicos.. algo asi se llamaba jaja]
        rooms.add(null);
    }
    private void classRoom6(){
        //Aula 254 --> Fisica I [Calculadora]
        rooms.add(null);
    }
    private void classRoom7(){
        //Aula 218 --> Introduccion a la Ingenieria [Libro de Intro]
        rooms.add(null);
    }
    private void classRoom8(){
        //Aula 219 --> Intro a la mate [Tabla de derivadas]
        rooms.add(null);
    }
    private void classRoom9(){
        //Aula 225 --> Quimica [Tabla periodica]
        rooms.add(null);
    }
    private void store1() {

        //Bar
        UIStore store2 = new UIStore(uiStudent,true);
        rooms.add(store2);

        //Boton para salir de la tienda
        WindowButton exitButton = new WindowButton(1100,620,150,50);
        store2.setButton(exitButton,rooms,uiStudent,"Exit",18,6,false);

        window.add(rooms.get(18));
    }
    private void store2() {

        //Electronica Argentica
        UIStore store2 = new UIStore(uiStudent,false);
        rooms.add(store2);

        //Boton para salir de la tienda
        WindowButton exitButton=new WindowButton(1100,620,150,50);
        store2.setButton(exitButton,rooms,uiStudent,"Exit",19,8,false);

        window.add(rooms.get(19));

        registerObserver(store2);

    }
    public void gameOver(){

        ImageIcon img = new ImageIcon("src/main/assets/img/ProfessorsImages/SadMan1.jpg");

        UIGameOver gameOverPanel=new UIGameOver(img,this,new JTextArea());

        rooms.add(gameOverPanel);

        gameOverPanel.setButton(new RestartButton(this),rooms);

        window.add(gameOverPanel);

    }
    public GameWindow getWindow(){
        return window;
    }
    @Override
    public void registerObserver(Observer O) { observers.add(O); }
    @Override
    public void removeObserver(Observer O) {
        int index= observers.indexOf(O);

        if(index>=0){
            observers.remove(index);
        }
    }
    @Override
    public void notifyObservers() {

        for(int i=0;i< observers.size();i++){

            observers.get(i).update();
        }

    }
}

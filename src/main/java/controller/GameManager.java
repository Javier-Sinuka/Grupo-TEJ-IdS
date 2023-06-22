package controller;

import model.entity.*;
import model.objects.Consumable;
import model.objects.Item;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager implements Subject{

    public UIStudent uiStudent;
    private GameWindow window;
    private ArrayList<UIRoom> rooms;
    private ArrayList<Observer>observers;

    public GameManager(){
        uiStudent = new UIStudent();
        window=new GameWindow();
        rooms=new ArrayList<>(10);
        observers=new ArrayList<>();

        setUpRooms();
    }
    public void setUpRooms(){

        registerObserver(uiStudent);

        createMenu();     //0
        hallway1();       //1
        hallway2();       //2
        hallway3();       //3
        hallway4();       //4
        hallway5();       //5
        hallway6();       //6
        hallway7();       //7
        hallway8();       //8
        classRoom200();   //9
        classRoom104();   //10
        classRoom214();   //11
        classRoom107();   //12
        classRoom115();   //13
        classRoom254();   //14
        classRoom218();   //15
        classRoom219();   //16
        classRoom225();     //17
        store1();         //18
        store2();         //19

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

        UIHallway hallway1= new UIHallway(uiStudent, null, null, path,true,img,false,"");
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

        Consumable consumable = new Consumable("Cafe","El cafe te aumenta la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir quimica");

        UIHallway hallway2= new UIHallway(uiStudent, consumable, item,path,false,img,false,"src/main/assets/img/consumable/coffe.png");
        rooms.add(hallway2);

        //Boton para ir al store
        WindowButton wb1=new WindowButton(600,20,150,50);
        hallway2.setButton(wb1,rooms,uiStudent,"Patio Central",2,6,false);

        //Boton para ir al store2
        WindowButton wb2 = new WindowButton(20,350,150,50);
        hallway2.setButton(wb2,rooms,uiStudent,"Aula 214",2,11,false);

        //Boton para ir al hallway1
        WindowButton wb3 = new WindowButton(600,610,150,50);
        hallway2.setButton(wb3,rooms,uiStudent,"Lobby Central",2,1,false);

        window.add(rooms.get(2));

        registerObserver(hallway2);

    }
    private void hallway3() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo3.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_200.png";

        Consumable consumable = new Consumable("Mate","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla periodica", "Tabla que te ayudara a rendir Quimica");

        UIHallway hallway3= new UIHallway(uiStudent, consumable, item,mapPath,false,img,false,"src/main/assets/img/consumable/mate.png");
        rooms.add(hallway3);

        //Boton para ir al
        WindowButton wb1=new WindowButton(500,600,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Lobby Central",3,1,false);

        //Boton para ir al store2
        WindowButton wb2 = new WindowButton(500,20,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 200",3,9,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void hallway4() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo4.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_1.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tabla Periodica", "Tabla que te ayudara a rendir Quimica");
        String itemPath = "src/main/assets/img/item/TablaPeriodica.png";

        UIHallway hallway3= new UIHallway(uiStudent, consumable, item,mapPath,false,img,true,itemPath);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Aula 104",4,10,false);

        WindowButton wb2 = new WindowButton(20,300,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Pasillo 5",4,5,false);

        WindowButton wb3=new WindowButton(500,600,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Lobby Central",4,1,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void hallway5() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo5.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_107.jpg";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Monografia de la UNC", "Libro que te ayudara a rendir Introduccion a la Ingenieria");
        String itemPath = "src/main/assets/img/item/monografia.png";

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img,true,itemPath);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(550,600,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Pasillo 4",5,4,false);

        WindowButton wb2 = new WindowButton(1100,250,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 115",5,13,false);

        WindowButton wb3=new WindowButton(20,250,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Aula 107",5,12,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void hallway6() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/patioCentral.jpg");
        String mapPath = "src/main/assets/img/map/Patio_Central.png";
        String itemPath = "src/main/assets/img/item/laptop.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Notebook", "Notebook que te ayudarar a rendir Informatica");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img,true,itemPath);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Bar",6,18,false);

        WindowButton wb2 = new WindowButton(600,600,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Pasillo 2",6,2,false);

        WindowButton wb3=new WindowButton(20,300,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Pasillo 7",6,7,false);

        WindowButton wb4=new WindowButton(600,20,150,50);
        hallway3.setButton(wb4,rooms,uiStudent,"Aula 254",6,14,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void hallway7() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo7.jpg");
        String mapPath = "src/main/assets/img/map/Pasillo_Aula_219.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumentara la cafeina");
        Item item = new Item("Tablero de Dibujo Tecnico", "Tablero que te ayudara a rendir Representacion Grafica");
        String itemPath = "src/main/assets/img/item/board.png";

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img,true,itemPath);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(1100,300,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Aula 219",7,16,false);

        WindowButton wb2 = new WindowButton(600,600,150,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Aula 225",7,17,false);

        WindowButton wb3=new WindowButton(1100,150,150,50);
        hallway3.setButton(wb3,rooms,uiStudent,"Aula 218",7,15,false);

        WindowButton wb4=new WindowButton(600,20,150,50);
        hallway3.setButton(wb4,rooms,uiStudent,"Patio Central",7,6,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void hallway8() {

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/pasillo8.jpg");
        String mapPath = "src/main/assets/img/map/Electronica_Argentina.png";
        String itemPath = "src/main/assets/img/item/algebraLibro.png";

        Consumable consumable = new Consumable("Cafe","El cafe te aumenta la cafeina");
        Item item = new Item("Libro de Algebra", "Libro que te ayudara a rendir Algebra");

        UIHallway hallway3 = new UIHallway(uiStudent, consumable, item,mapPath,false,img,true,itemPath);
        rooms.add(hallway3);

        WindowButton wb1 = new WindowButton(550,610,150,50);
        hallway3.setButton(wb1,rooms,uiStudent,"Lobby Central",8,1,false);

        WindowButton wb2 = new WindowButton(1050,150,200,50);
        hallway3.setButton(wb2,rooms,uiStudent,"Electronica Argentina",8,19,false);

        window.add(hallway3);

        registerObserver(hallway3);

    }
    private void classRoom200() {

        //Aula 200 --> Analisis matematico I [Tabla de Integrales]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula219.jpg");
        UIClassroom classroom200 = new UIClassroom(img,uiStudent,"Analisis Matematico I",9);
        rooms.add(classroom200);

        classroom200.setTextArea(classroom200.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom200.getClassroom().getProfessor().getProfessorNickname()+")"+": Bienvenido Víctima "+
                "esto es "+ classroom200.getClassroom().getProfessor().getAssociatedSubject());

       WindowButton exitButton=new WindowButton(570,20,150,50);
       classroom200.setButton(exitButton,rooms,uiStudent,"Exit",9,3,false);

       classroom200.setButton(new ExamButtons(),rooms,9,uiStudent,classroom200.getTextArea());

       classroom200.setButton(new ExamStartButton(),rooms,9,uiStudent,classroom200.getTextArea());

       window.add(rooms.get(9));

       registerObserver(classroom200);

      classroom200.addProfessorImage(640,90,300,330,"src/main/assets/img/ProfessorsImages/pastore.png");

    }
    private void classRoom104(){
        //Aula 104 --> Algebra [Libro de Algebra]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula104.jpg");
        UIClassroom classroom104 = new UIClassroom(img,uiStudent,"Algebra Lineal",10);
        rooms.add(classroom104);

        classroom104.setTextArea(classroom104.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom104.getClassroom().getProfessor().getProfessorNickname()+")"+": hola corazon,tome un cafecito "+
                "bienvenido sea a "+ classroom104.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom104.setButton(exitButton,rooms,uiStudent,"Exit",10,4,false);

        classroom104.setButton(new ExamButtons(),rooms,10,uiStudent,classroom104.getTextArea());

        classroom104.setButton(new ExamStartButton(),rooms,10,uiStudent,classroom104.getTextArea());

        window.add(rooms.get(10));

        registerObserver(classroom104);

        classroom104.addProfessorImage(600,220,180,300,"src/main/assets/img/ProfessorsImages/dimitroff.png");

    }
    private void classRoom214(){
        //Aula 214 --> Representacion Grafica [Tablero de dibujo]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula214.jpg");
        UIClassroom classroom214 = new UIClassroom(img,uiStudent,"Representacion Grafica",11);
        rooms.add(classroom214);

        classroom214.setTextArea(classroom214.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom214.getClassroom().getProfessor().getProfessorNickname()+"): "+
                "bienvenido alumno, saque su tablero, esto es "+ classroom214.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom214.setButton(exitButton,rooms,uiStudent,"Exit",11,2,false);

        classroom214.setButton(new ExamButtons(),rooms,11,uiStudent,classroom214.getTextArea());

        classroom214.setButton(new ExamStartButton(),rooms,11,uiStudent,classroom214.getTextArea());

        window.add(rooms.get(11));

        registerObserver(classroom214);

        classroom214.addProfessorImage(750,240,330,300,"src/main/assets/img/ProfessorsImages/representacion grafica.png");

    }
    private void classRoom107(){
        //Aula 107 --> Informatica [Notebook]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula107.jpg");
        UIClassroom classroom107 = new UIClassroom(img,uiStudent,"Informatica",12);
        rooms.add(classroom107);

        classroom107.setTextArea(classroom107.getClassroom().getProfessor().getProfessorName() + " "+
                "("+ classroom107.getClassroom().getProfessor().getProfessorNickname()+")"+": " + "bienvenido a "
                + classroom107.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom107.setButton(exitButton,rooms,uiStudent,"Exit",12,5,false);

        classroom107.setButton(new ExamButtons(),rooms,12,uiStudent,classroom107.getTextArea());

        classroom107.setButton(new ExamStartButton(),rooms,12,uiStudent,classroom107.getTextArea());

        window.add(rooms.get(12));

        registerObserver(classroom107);

        classroom107.addProfessorImage(980,220,140,250,"src/main/assets/img/ProfessorsImages/finochietto.png");
    }
    private void classRoom115(){
        //Aula 115 --> Taller y Laboratorio [Kit de electronicos.. algo asi se llamaba jaja]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula115.jpg");
        UIClassroom classroom115 = new UIClassroom(img,uiStudent,"Taller y Laboratorio",13);
        rooms.add(classroom115);

        classroom115.setTextArea(classroom115.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom115.getClassroom().getProfessor().getProfessorNickname()+")"+ "pase alumno, cuidado con los " +
                "cables, "+ "bienvenido a "+ classroom115.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom115.setButton(exitButton,rooms,uiStudent,"Exit",13,5,false);

        classroom115.setButton(new ExamButtons(),rooms,13,uiStudent,classroom115.getTextArea());

        classroom115.setButton(new ExamStartButton(),rooms,13,uiStudent,classroom115.getTextArea());

        window.add(rooms.get(13));

        registerObserver(classroom115);

        classroom115.addProfessorImage(680,210,230,300,"src/main/assets/img/ProfessorsImages/Enrico.png");

    }
    private void classRoom254(){
        //Aula 254 --> Fisica I [Calculadora]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula 254.png");
        UIClassroom classroom254 = new UIClassroom(img,uiStudent,"Fisica I",14);
        rooms.add(classroom254);

        classroom254.setTextArea(classroom254.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom254.getClassroom().getProfessor().getProfessorNickname()+")"+ " Adelante alumno, "+
                "bienvenido a "+ classroom254.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom254.setButton(exitButton,rooms,uiStudent,"Exit",14,6,false);

        classroom254.setButton(new ExamButtons(),rooms,14,uiStudent,classroom254.getTextArea());

        classroom254.setButton(new ExamStartButton(),rooms,14,uiStudent,classroom254.getTextArea());

        window.add(rooms.get(14));

        registerObserver(classroom254);

        classroom254.addProfessorImage(200,0,400,570,"src/main/assets/img/ProfessorsImages/albert-einstein-g56a210277_640.png");

    }
    private void classRoom218(){
        //Aula 218 --> Introduccion a la Ingenieria [Libro de Intro]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula218.jpg");
        UIClassroom classroom218 = new UIClassroom(img,uiStudent,"Introduccion a la Ingenieria",15);
        rooms.add(classroom218);

        classroom218.setTextArea(classroom218.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom218.getClassroom().getProfessor().getProfessorNickname()+")"+ " Adelante alumno, "+
                "bienvenido a "+ classroom218.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom218.setButton(exitButton,rooms,uiStudent,"Exit",15,7,false);

        classroom218.setButton(new ExamButtons(),rooms,15,uiStudent,classroom218.getTextArea());

        classroom218.setButton(new ExamStartButton(),rooms,15,uiStudent,classroom218.getTextArea());

        window.add(rooms.get(15));

        registerObserver(classroom218);

        classroom218.addProfessorImage(400,190,280,320,"src/main/assets/img/ProfessorsImages/Litvack.png");

    }
    private void classRoom219(){
        //Aula 219 --> Intro a la mate [Tabla de derivadas]

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula219.jpg");
        UIClassroom classroom219 = new UIClassroom(img,uiStudent,"Introduccion a la Matematica",16);
        rooms.add(classroom219);

        String extraString= " bienvenido víctima, esto es";

        classroom219.setTextArea(classroom219.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom219.getClassroom().getProfessor().getProfessorNickname()+"):"+ " bienvenido víctima, esto es "+
                classroom219.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom219.setButton(exitButton,rooms,uiStudent,"Exit",16,7,false);

        classroom219.setButton(new ExamButtons(),rooms,16,uiStudent,classroom219.getTextArea());

        classroom219.setButton(new ExamStartButton(),rooms,16,uiStudent,classroom219.getTextArea());

        window.add(rooms.get(16));

        registerObserver(classroom219);

        classroom219.addProfessorImage(600,150,280,320,"src/main/assets/img/ProfessorsImages/Vega.png");

    }
    private void classRoom225(){

        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/aula225.jpg");
        UIClassroom classroom225 = new UIClassroom(img,uiStudent,"Quimica Aplicada",17);
        rooms.add(classroom225);

        classroom225.setTextArea(classroom225.getClassroom().getProfessor().getProfessorName()+
                "("+ classroom225.getClassroom().getProfessor().getProfessorNickname()+")"+ " bienvenido forma de vida a"+
                "base de carbono, esto es "+ classroom225.getClassroom().getProfessor().getAssociatedSubject());

        WindowButton exitButton=new WindowButton(570,20,150,50);
        classroom225.setButton(exitButton,rooms,uiStudent,"Exit",17,7,false);

        classroom225.setButton(new ExamButtons(),rooms,17,uiStudent,classroom225.getTextArea());

        classroom225.setButton(new ExamStartButton(),rooms,17,uiStudent,classroom225.getTextArea());

        window.add(rooms.get(17));

        registerObserver(classroom225);

        classroom225.addProfessorImage(410,170,380,350,"src/main/assets/img/ProfessorsImages/aimarQuimica.png");

    }
    private void store1() {
        //Bar
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/bar.jpg");

        UIStore store2 = new UIStore(uiStudent,true,img);
        rooms.add(store2);

        //Boton para salir de la tienda
        WindowButton exitButton = new WindowButton(1100,620,150,50);
        store2.setButton(exitButton,rooms,uiStudent,"Exit",18,6,false);

        window.add(rooms.get(18));
    }
    private void store2() {

        //Electronica Argentica
        ImageIcon img = new ImageIcon("src/main/assets/img/background-image-u/electronicaArg2.jpg");
        UIStore store2 = new UIStore(uiStudent,false,img);
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

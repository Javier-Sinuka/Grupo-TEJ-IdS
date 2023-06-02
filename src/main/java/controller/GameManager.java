package controller;
import model.entity.*;
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
        //classRoom1();   //2
        //store1();       //3
        //hallway2();     //4
        //store2();       //5
    }


    private void createMenu(){
        ImageIcon img = new ImageIcon("src/main/assets/img/Mi proyecto.png");
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

        UIHallway hallway1= new UIHallway("Hallway 1 ",Color.BLUE);
        rooms.add(hallway1);

        WindowButton wb1=new WindowButton(500,0,150,50);
        hallway1.setButton(wb1,rooms,uiStudent,"Hallway 2",1,0);

        window.add(hallway1);

    }
    public GameWindow getWindow(){
        return window;
    }


}

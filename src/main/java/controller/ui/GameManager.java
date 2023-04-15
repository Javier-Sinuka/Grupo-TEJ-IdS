package main.java.controller.ui;

import main.java.model.Student;
import main.java.model.GameObject;

import main.java.model.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Student student;
    private Window window;
    //private JTextArea textLabel;

    private JTextArea textArea;

    private JPanel roomsPanels[] = new JPanel[5];

    public GameManager(){

        this.student = new Student("Ezequiel");
        student.setDataPanel();
        this.window = new Window();

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
        //textLabel.setVerticalTextPosition(SwingConstants.TOP);

        setRoomsPanels();
    }

    public void createStartRoom(){

        roomsPanels[0].setVisible(true);

        //Etiqueta del titulo
        JLabel title = new JLabel("Game name");
        title.setBounds(270,100,500,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        roomsPanels[0].add(title);

        //Etiqueta del textArea para agregar el nombre del jugador
        //nameText = new JTextArea("Name..");
        //nameText.setBounds(350,200,200,50);
        //roomsPanels[0].add(nameText);

        //Etiqueta de botton de start
        GameObject obj1=new GameObject(350,300,150,50);
        obj1.setAsWindowButton(roomsPanels,window,student,"START GAME",0,1);
        //createWindowButton("Start game",0,1,350,300,150,50);


        //Agrego el panel de start a la ventana
        addPanelBackground(0,"main/assets/img/EntradaFacultad.png");

    }

    public void setRoomsPanels(){
        for(int i = 0; i<5; i++){
            roomsPanels[i] = new JPanel();
            roomsPanels[i].setSize(window.getWIDTH(),window.getHEIGHT());
            roomsPanels[i].setVisible(false);
            roomsPanels[i].setLayout(null);
            window.add(roomsPanels[i]);
        }
        createStartRoom();
        roomOne();
        roomTwo();
        roomThree();
    }
    public void roomOne(){
        //roomsPanels[1].add(student.getDataPanel());
        GameObject button1= new GameObject(50,300,150,50);
        button1.setAsWindowButton(roomsPanels,window,student,"Room 2",1,2);
        GameObject button2= new GameObject(1000,300,150,50);
        button2.setAsWindowButton(roomsPanels,window,student,"Room 3",1,3);

    }
    public void roomTwo(){
        //roomsPanels[2].setBackground(Color.blue); //Cambiar el fonde del room con la foto
        //roomsPanels[2].add(student.getDataPanel());
        roomsPanels[2].add(textArea);
        GameObject button1= new GameObject(1000,300,150,50);
        button1.setAsWindowButton(roomsPanels,window,student,"Room 1",2,1);
        GameObject button2= new GameObject(500,500,500,50);
        ArrayList<String> options= new ArrayList<>();
        options.add("text text text text text text text text");
        options.add("Option2");
        options.add("Option3");
        //options.add("Option4");
        button2.setAsOptionMenu(options,"Option 2",roomsPanels[2],textArea);
    }
    public void roomThree(){
        //roomsPanels[3].add(student.getDataPanel());
        roomsPanels[3].setBackground(Color.blue); //Cambiar el fonde del room con la foto
        GameObject button1= new GameObject(50,300,150,50);
        button1.setAsWindowButton(roomsPanels,window,student,"Room 1",3,1);
        //roomsPanels[3].add(student.getDataPanel());
    }

    public void addPanelBackground(int roomID,String imagePath){
        JLabel label=new JLabel();
        label.setBounds(0,0,window.getWIDTH(),window.getHEIGHT());
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        label.setIcon(image);
        label.setVisible(true);
        roomsPanels[roomID].add(label);
        window.add(roomsPanels[roomID]);
    }



    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public main.java.model.Window getWindow() {
        return window;
    }
    public void setWindow(Window window) {
        this.window = window;
    }
}


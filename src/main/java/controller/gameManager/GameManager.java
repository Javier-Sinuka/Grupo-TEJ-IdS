package main.java.controller.gameManager;
import main.java.controller.ui.DataPanel;
import main.java.controller.ui.StartPanel;
import main.java.model.entity.Student;
import main.java.controller.ui.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameManager {
    private Student student;
    private Window window;
    private StartPanel startPanel;
    private DataPanel dataPanel;
    private JPanel roomsPanels[] = new JPanel[5];

    public GameManager(){
        this.student = new Student("");
        this.window = new Window();
        this.startPanel = new StartPanel(window,student);
        this.dataPanel = new DataPanel(window,student);

        startButtonLabel();
        window.add(startPanel.getStartPanele());
    }
    //Boton si o si en la window y no en el panle de start por la logica el el click
    public void startButtonLabel(){
        //Etiqueta de botton de start
        JButton startButton = new JButton("Start game");
        startButton.setBounds(500,300,150,50);
        window.add(startButton);
        //Logica click del boton
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = startPanel.getNameText().getText();
                student.setNameStudent(name);
                System.out.println(name);

                //Despues de apretar el boton tengo que setear los datos de los paneles
                dataPanel.setDataPanel();
                setRommsPanels();

                startPanel.getStartPanele().setVisible(false);
                roomsPanels[0].setVisible(true);
                window.add(roomsPanels[0]);
                startButton.setVisible(false);
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }
    public void setRommsPanels(){
        for(int i = 0; i<5; i++){
            roomsPanels [i] = new JPanel();
            roomsPanels[i].setSize(window.getWIDTH(),400);
            roomsPanels[i].setVisible(false);
            roomsPanels[i].setLayout(null);
        }
        roomThree();
        roomTwo();
        roomOne();
    }
    public void roomOne(){

        roomsPanels[0].setBackground(Color.red); //Cambiar el fonde del room con la foto
        roomsPanels[0].add(dataPanel.getDataPanel());
        //Etiqueta del boton a room2
        JButton buttonRoom2 = new JButton("Room 2");
        buttonRoom2.setBounds(100,300,150,50);

        //Logica click del boton
        buttonRoom2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Going to Room 2");
                roomsPanels[0].setVisible(false);
                roomsPanels[1].setVisible(true);
                roomsPanels[1].add(dataPanel.getDataPanel());
                window.add(roomsPanels[1]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //Etiqueta del boton a room3
        JButton buttonRoom3 = new JButton("Room 3");
        buttonRoom3.setBounds(600,300,150,50);

        //Logica click del boton
        buttonRoom3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Going to Room 3");
                roomsPanels[0].setVisible(false);
                roomsPanels[2].setVisible(true);
                roomsPanels[2].add(dataPanel.getDataPanel());
                window.add(roomsPanels[2]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        roomsPanels[0].add(buttonRoom2);
        roomsPanels[0].add(buttonRoom3);

    }
    public void roomTwo(){
        roomsPanels[1].setBackground(Color.blue); //Cambiar el fonde del room con la foto

        //Etiqueta del boton a room1
        JButton buttonRoom1 = new JButton("Room 1");
        buttonRoom1.setBounds(600,300,150,50);

        //Logica click del boton
        buttonRoom1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Going to Room 1");
                roomsPanels[0].setVisible(true);
                roomsPanels[1].setVisible(false);
                roomsPanels[0].add(dataPanel.getDataPanel());
                window.add(roomsPanels[0]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        roomsPanels[1].add(buttonRoom1);

    }
    public void roomThree(){
        roomsPanels[2].setBackground(Color.black); //Cambiar el fonde del room con la foto

        //Etiqueta del boton a room1
        JButton buttonRoom1 = new JButton("Room 1");
        buttonRoom1.setBounds(100,300,150,50);

        //Logica click del boton
        buttonRoom1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Going to Room 1");
                roomsPanels[0].setVisible(true);
                roomsPanels[2].setVisible(false);
                roomsPanels[0].add(dataPanel.getDataPanel());
                window.add(roomsPanels[0]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        roomsPanels[2].add(buttonRoom1);
    }
    public Student getStudent() {
        return student;
    }
    public Window getWindow() {
        return window;
    }
}

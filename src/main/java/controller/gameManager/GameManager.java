package main.java.controller.gameManager;

import main.java.model.entity.Student;
import main.java.controller.ui.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameManager {
    private Student student;
    private Window window;
    private JPanel startPanel;
    private JPanel dataPanel;
    private JPanel roomsPanels[] = new JPanel[5];

    public GameManager(){
        this.student = new Student("");
        this.window = new Window();

        setStartPanel();
        setRommsPanels();
    }
    public void setDataPlayer(String name){
        //Setear los datos del jugador
        student.setNameStudent(name);
    }
    public void setStartPanel(){

        startPanel = new JPanel();
        startPanel.setSize(window.getWIDTH(),400);
        startPanel.setBackground(Color.GRAY);
        startPanel.setVisible(true);
        startPanel.setLayout(null);
        Image background = Toolkit.getDefaultToolkit().createImage("res/fondo.jpg");
        //startPanel.drawImage(background, 0, 0, null);

        //Etiqueta del titulo
        JLabel title = new JLabel("Game name");
        title.setBounds(270,100,500,100);
        title.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        startPanel.add(title);

        //Etiqueta del textArea para agregar el nombre del jugador
        JTextArea nameText = new JTextArea("Name..");
        nameText.setBounds(350,200,200,50);
        startPanel.add(nameText);

        //Etiqueta de botton de start
        JButton startButton = new JButton("Start game");
        startButton.setBounds(350,300,150,50);
        startButton.setFocusable(false);

        //Logica click del boton
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = nameText.getText();
                setDataPlayer(name);
                System.out.println(name);
                setDataPanel();
                startPanel.setVisible(false);
                roomsPanels[0].setVisible(true);
                roomsPanels[0].add(dataPanel);
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

        startPanel.add(startButton);

        //Agrego el panel de start a la ventana
        window.add(startPanel);
    }
    public void setDataPanel(){
        dataPanel = new JPanel();
        dataPanel.setSize(window.getWIDTH(),400);
        dataPanel.setBackground(Color.gray);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);

        //Etiqueda con el nombre del jugador
        String playerName = student.getNameStudent();
        JLabel nameLabel = new JLabel(playerName);
        nameLabel.setBounds(350,270,200,200);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,50)); //(tipo de letra, estilo, tamaño)
        dataPanel.add(nameLabel);

        //Etiqueta de dogecoin
        ImageIcon dogecoin = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/dogecoin.png"));
        String coin = Integer.toString(student.getDogecoin());
        JLabel dogecoinLabel = new JLabel(coin,dogecoin,0);
        dogecoinLabel.setBounds(700,10,200,60);
        dogecoinLabel.setFont(new Font("Arial Black",Font.BOLD,50));
        dataPanel.add(dogecoinLabel);

        //Etiqueta life
        JProgressBar lifeBar = new JProgressBar(0,5);
        lifeBar.setBounds(20,20,200,20);
        dataPanel.add(lifeBar);

        //Etiqueta knowledge

    }
    public void setRommsPanels(){
        for(int i = 0; i<5; i++){
            roomsPanels [i] = new JPanel();
            roomsPanels[i].setSize(window.getWIDTH(),400);
            roomsPanels[i].setVisible(false);
            roomsPanels[i].setLayout(null);
        }
        roomOne();
        roomTwo();
        roomThree();
    }
    public void roomOne(){

        roomsPanels[0].setBackground(Color.red); //Cambiar el fonde del room con la foto

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
                roomsPanels[1].add(dataPanel);
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
                roomsPanels[2].add(dataPanel);
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
                roomsPanels[0].add(dataPanel);
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
                roomsPanels[0].add(dataPanel);
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
    public void setStudent(Student student) {
        this.student = student;
    }
    public Window getWindow() {
        return window;
    }
    public void setWindow(Window window) {
        this.window = window;
    }
}

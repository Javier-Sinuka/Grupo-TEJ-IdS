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
    private JTextArea nameText;

    private JPanel roomsPanels[] = new JPanel[5];

    public GameManager(){

        this.student = new Student("");
        this.window = new Window();
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
        nameText = new JTextArea("Name..");
        nameText.setBounds(350,200,200,50);
        roomsPanels[0].add(nameText);

        //Etiqueta de botton de start
        createWindowButton("Start game",0,1,350,300,150,50);


        //Agrego el panel de start a la ventana
        addPanelBackground(0,"main/assets/img/EntradaFacultad.png");

    }

    public void setRoomsPanels(){
        for(int i = 0; i<5; i++){
            roomsPanels[i] = new JPanel();
            roomsPanels[i].setSize(window.getWIDTH(),window.getHEIGHT());
            roomsPanels[i].setVisible(false);
            roomsPanels[i].setLayout(null);
        }
        createStartRoom();
        roomOne();
        roomTwo();
        roomThree();
    }
    public void roomOne(){
        //roomsPanels[1].setBackground(Color.DARK_GRAY);
        createWindowButton("Room 2",1,2,100,300,150,50);
        createWindowButton("Room 3",1,3,600,300,150,50);
    }
    public void roomTwo(){
        roomsPanels[2].setBackground(Color.blue); //Cambiar el fonde del room con la foto
        createWindowButton("Room1",2,1,600,300,150,50);
    }
    public void roomThree(){
        roomsPanels[3].setBackground(Color.black); //Cambiar el fonde del room con la foto
        createWindowButton("Room1",3,1,100,300,150,50);
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

    public void createWindowButton(String buttonText,int roomID,int destinyRoom,int xpos,int ypos,int width,int height){

        JButton newButton = new JButton(buttonText);
        newButton.setBounds(xpos,ypos,width,height);
        newButton.setFocusable(false);

        //Logica click del boton
        newButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(buttonText.equals("Start game")){
                    String name = nameText.getText();
                    student.setStudentName(name);
                    student.setDataPanel();
                }
                roomsPanels[roomID].setVisible(false);
                roomsPanels[destinyRoom].setVisible(true);
                roomsPanels[destinyRoom].add(student.getDataPanel());
                window.add(roomsPanels[destinyRoom]);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("NDEAH");
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        roomsPanels[roomID].add(newButton);
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

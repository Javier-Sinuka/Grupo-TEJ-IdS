package model.entity;
import model.objects.Consumable;
import model.objects.Item;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIHallway extends UIRoom implements Observer{
    private Hallway hallway;
    private String mapPath;
    private UIStudent uiStudent;
    private boolean isLobyCentral;

    public UIHallway(){
        hallway=new Hallway(new Consumable(),new Item());
    }
    public UIHallway(UIStudent uiStudent,Consumable consumable,Item item, String mapPath, boolean isLobyCentral, ImageIcon backgroundImage){
        super();
        this.mapPath = mapPath;
        this.hallway = new Hallway(consumable,item);
        this.isLobyCentral = isLobyCentral;
        this.uiStudent = uiStudent;
        this.backgroundImage =  new ImageIcon(backgroundImage.getImage().getScaledInstance(GameWindow.WIDTH,GameWindow.HEIGHT,Image.SCALE_SMOOTH));

        if(isLobyCentral){
            ceuAndAbmLabel();
        }

        LabelTitle(hallway.getNameHallway());
        randomObject();
        mapLabel();
    }
    public void ceuAndAbmLabel(){

        Usable derivateTalbe = new Item("Tabla de derivadas", "Esta tabla te ayudara a rendir Introduccion a la Matematica");
        Usable integralTable = new Item("Tabla de integrales", "Esta tabla de ayudara a rendir Analisis Matematico I");

        JLabel ceuLabel = new JLabel();
        ImageIcon ceuIcon = new ImageIcon("src/main/assets/img/imgLabels/CEU.png");
        ceuLabel.setBounds(300,50,100,100);
        ceuLabel.setIcon(new ImageIcon(ceuIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));

        ceuLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(!derivateTalbe.getIsTaken()) {
                    derivateTalbe.setTaken(true);
                    uiStudent.getStudent().addUsableInBackpack(derivateTalbe);
                    uiStudent.getInventoryPanel().getObjectPanel().removeAll();
                    uiStudent.getInventoryPanel().parameterInventoryPanel();

                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                ceuLabel.setSize(100,100);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                ceuLabel.setSize(120,120);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ceuLabel.setSize(120,120);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ceuLabel.setSize(100,100);
            }
        });

        JLabel abmLabel = new JLabel();
        ImageIcon abmIcon = new ImageIcon("src/main/assets/img/imgLabels/ABM.png");
        abmLabel.setBounds(900,50,100,100);
        abmLabel.setIcon(new ImageIcon(abmIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));

        abmLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(!integralTable.getIsTaken()) {
                    uiStudent.getStudent().addUsableInBackpack(integralTable);
                    uiStudent.getInventoryPanel().getObjectPanel().removeAll();
                    uiStudent.getInventoryPanel().parameterInventoryPanel();

                    integralTable.setTaken(true);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                abmLabel.setSize(100,100);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                abmLabel.setSize(120,120);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                abmLabel.setSize(120,120);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                abmLabel.setSize(100,100);
            }
        });

        this.add(abmLabel);
        this.add(ceuLabel);
    }
    public void randomObject(){
        Usable usable = hallway.getRandomUsable();

        if(usable != null) {
            JLabel object = new JLabel(usable.getName());
            object.setBounds(hallway.getRandomX(), hallway.getRandomY(), 100, 50);

            object.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Encontraste " + usable.getName() + usable.getDescription());
                    object.setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    object.setSize(120, 60);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    object.setSize(100, 50);
                }
            });

            object.setOpaque(true);

            this.add(object);
        }
    }
    public void LabelTitle (String hallwayName){
        JLabel title = new JLabel(hallwayName);
        title.setBounds(10,630,100,50);
        this.add(title);
    }
    public void mapLabel(){
        ImageIcon mapImg = new ImageIcon(mapPath);
        JLabel mapLable = new JLabel();
        mapLable.setBounds(1050,470,200,200);
        mapLable.setIcon(new ImageIcon(mapImg.getImage().getScaledInstance(mapLable.getWidth(),mapLable.getHeight(),Image.SCALE_SMOOTH)));
        this.add(mapLable);
    }

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {
        wb.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom,start);
    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(RestartButton restartBt, ArrayList<UIRoom> rooms) {

    }

    @Override
    public void update() {

    }

    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,GameWindow.WIDTH,GameWindow.HEIGHT, this);
    }


}

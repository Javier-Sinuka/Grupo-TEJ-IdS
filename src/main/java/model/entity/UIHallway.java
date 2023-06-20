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
    private Usable derivateTable;
    private Usable integralTable;
    private boolean hasItem;
    private String itemPath;
    private JLabel usableLabel;

    public UIHallway(){
        hallway=new Hallway(new Consumable(),new Item());
    }
    public UIHallway(UIStudent uiStudent,Consumable consumable,Item item, String mapPath, boolean isLobyCentral, ImageIcon backgroundImage, boolean hasItem, String itemPath){
        super();
        this.mapPath = mapPath;
        this.hallway = new Hallway(consumable,item);
        this.uiStudent = uiStudent;
        this.hasItem = hasItem;
        this.itemPath = itemPath;
        this.backgroundImage =  new ImageIcon(backgroundImage.getImage().getScaledInstance(GameWindow.WIDTH,GameWindow.HEIGHT,Image.SCALE_SMOOTH));
        this.derivateTable = new Item("Tabla de Derivadas", "Esta tabla te ayudara a rendir Introduccion a la Matematica");
        this.integralTable = new Item("Tabla de Integrales", "Esta tabla de ayudara a rendir Analisis Matematico I");
        this.usableLabel = new JLabel();

        if(isLobyCentral){
            ceuAndAbmLabel();
        }


        randomObject();
        mapLabel();
    }
    public void ceuAndAbmLabel(){


        JLabel ceuLabel = new JLabel();
        ImageIcon ceuIcon = new ImageIcon("src/main/assets/img/imgLabels/CEU.png");
        ceuLabel.setBounds(300,50,100,100);
        ceuLabel.setIcon(new ImageIcon(ceuIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));

        ceuLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(!derivateTable.getIsTaken()) {
                    derivateTable.setTaken(true);
                    uiStudent.getStudent().addUsableInBackpack(derivateTable);
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
                    integralTable.setTaken(true);
                    uiStudent.getStudent().addUsableInBackpack(integralTable);
                    uiStudent.getInventoryPanel().getObjectPanel().removeAll();
                    uiStudent.getInventoryPanel().parameterInventoryPanel();
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

        ImageIcon img = new ImageIcon(itemPath);
        usableLabel.setBounds(hallway.getRandomX(), hallway.getRandomY(),50,50);
        usableLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
        usableLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    usableLabel.setVisible(false);
                    if(hasItem) {
                        uiStudent.getStudent().addUsableInBackpack(hallway.getItem());
                    }else {
                        uiStudent.getStudent().addUsableInBackpack(hallway.getConsumable());
                    }

                    uiStudent.getInventoryPanel().getConsumablePanel().removeAll();
                    uiStudent.getInventoryPanel().getObjectPanel().removeAll();
                    uiStudent.getInventoryPanel().parameterInventoryPanel();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    usableLabel.setSize(50,50);

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    usableLabel.setSize(60,60);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    usableLabel.setSize(50,50);

                }
            });

            this.add(usableLabel);
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
        derivateTable.setTaken(false);
        integralTable.setTaken(false);
        usableLabel.setVisible(true);

        
    }

    public void paintComponent(Graphics g){
        g.drawImage(backgroundImage.getImage(),0,0,GameWindow.WIDTH,GameWindow.HEIGHT, this);
    }


}

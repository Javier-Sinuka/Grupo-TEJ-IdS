package model.entity;
import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIHallway extends UIRoom {
    private Hallway hallway;
    private String path;
    public UIHallway(String hallwayName, Color colorDeFondo, String nameItem, String descripcionItem,
                     String nameConsumable, String descriptionConsumable, String path){
        super();
        this.path = path;
        this.hallway = new Hallway(hallwayName,nameItem,descripcionItem,nameConsumable,descriptionConsumable);
        this.setBackground(colorDeFondo);
        LabelTitle(hallway.getNameHallway());
        randomObject();
        mapLabel();
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
        ImageIcon mapImg = new ImageIcon(path);
        JLabel mapLable = new JLabel();
        mapLable.setBounds(1050,470,200,200);
        mapLable.setIcon(new ImageIcon(mapImg.getImage().getScaledInstance(mapLable.getWidth(),mapLable.getHeight(),Image.SCALE_SMOOTH)));
        this.add(mapLable);
    }
    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {
        wb.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom);
    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

}

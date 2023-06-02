package model.entity;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UIHallway extends UIRoom {
    private String hallwayName;
    private Color colorDeFondo;
    public UIHallway(String hallwayName, Color colorDeFondo){

        super();
        this.hallwayName = hallwayName;
        this.colorDeFondo = colorDeFondo;
        this.setBackground(colorDeFondo);
        LabelTitle(this.hallwayName);
        randomObject();
    }

    public void randomObject(){
        int x = (int)(Math.random()*400+150);
        int y = (int)(Math.random()*400+150);
        //Funcion valor random x
        //Funcion valor random y
        //Funcion valor random img

        JLabel object = new JLabel();
        object.setBounds(x,y,100,50);
        object.setOpaque(true);
        object.setBackground(Color.BLACK);
        this.add(object);
    }
    public void LabelTitle (String hallwayName){
        JLabel title = new JLabel(hallwayName);
        title.setBounds(10,630,100,50);
        this.add(title);
    }

    @Override
    public void setButton(WindowButton wb, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {
        wb.configureButton(rooms,uiStudent,buttonText,roomID,destinyRoom);
    }

}

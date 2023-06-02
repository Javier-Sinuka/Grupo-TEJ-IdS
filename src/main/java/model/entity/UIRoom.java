package model.entity;

import javax.swing.*;
import java.util.ArrayList;

public abstract class UIRoom extends JPanel {

    ImageIcon backgroundImage;
    public UIRoom(){
        this.setSize(GameWindow.WIDTH,GameWindow.HEIGHT);
        this.setLayout(null);
        this.setVisible(false);
    }

   public abstract void setButton(WindowButton wb,ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom);

}

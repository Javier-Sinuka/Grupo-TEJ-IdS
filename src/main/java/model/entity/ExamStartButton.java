package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;

public class ExamStartButton implements UIButton{

    int xpos;
    int ypos;
    int width;
    int height;
    JButton button;


    public ExamStartButton(int xpos, int ypos, int width, int height) {
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;
        button=new JButton();
    }

    @Override
    public void configureButton() {}

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {}
    @Override
    public void configureButton(ArrayList<String> questions, ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt, ArrayList<UIRoom> roomsPanels, JTextArea textArea, int roomID, UIStudent uistudent, UIClassroom uiclassroom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, Set<String> questions, JButton[] buttons, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

    }

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, int roomID, ArrayList<String> questions, JButton [] buttons,
                                UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

        button=new JButton();
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText("COMENZAR EXAMEN");

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(! uiclassroom.getClassroom().getProfessor().studentHasItem()){
                    textArea.setText("Capo, te falta el objecto");
                }
                else if(! uiclassroom.getClassroom().getProfessor().studentHasCredits()){
                    textArea.setText("Capo, te faltan creditos");
                }
                else{

                    textArea.setText(questions.get(0));
                    button.setVisible(false);
                    JButton [] examButtons=buttons;
                    for(int i=0;i<3;i++){
                        examButtons[i].setVisible(true);
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        roomsPanels.get(roomID).add(button);

    }



}

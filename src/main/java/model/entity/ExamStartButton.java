package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class ExamStartButton implements UIButton{

    int xpos;
    int ypos;
    int width;
    int height;
    JButton button;


    public ExamStartButton() {
        xpos=620;
        ypos=540;
        width=200;
        height=50;
        button=new JButton();
    }

    @Override
    public void configureButton() {}

    @Override
    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar) {

    }

    @Override

    public void configureButton(JPanel inventoryPanel) {}

    @Override
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel) {}

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {}


    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea,
                                UIClassroom uiclassroom) {

        button=new JButton();
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText("COMENZAR EXAMEN");

        LinkedList<String> questions=uiclassroom.getClassroom().getQuestionsKeys();
        JButton[] buttons=uiclassroom.getExamButtons().getButtons();
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(! uiclassroom.getClassroom().getProfessor().studentHasItem()){
                    textArea.setText("Capo, te falta: "+ uiclassroom.getClassroom().getProfessor().getNecessaryItem().getName()
                            + ". Se puede conseguir en " + uiclassroom.getClassroom().getProfessor().getItemLocation());

                }
                else if(! uiclassroom.getClassroom().getProfessor().studentHasCredits()){
                    textArea.setText("Capo, necesitas "+ uiclassroom.getClassroom().getProfessor().getNecessaryCredits() +
                                    " creditos para rendir");
                }
                else if(uistudent.getStudent().getCaffeineAmount()<20){

                    textArea.setText("Capo, necesitas al menos 50 de cafeína, te vas a dormir en el examen, " +
                                    "tomate un matesuli o un coffee" );
                }
                else{
                    textArea.setText(questions.get(0));
                    button.setVisible(false);
                    for(int i=0;i<3;i++){
                        buttons[i].setVisible(true);
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


        uiclassroom.addExamStartButton(this);
        rooms.get(roomID).add(button);

    }

    @Override
    public void configureButton(ArrayList<UIRoom> rooms) {

    }


    public JButton getButton() { return button;}
}

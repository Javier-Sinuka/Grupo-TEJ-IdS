package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
    public void configureButton(ArrayList<UIRoom> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {}
    @Override
    public void configureButton(ArrayList<String> questions, ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt, ArrayList<UIRoom> roomsPanels, JTextArea textArea, int roomID, UIStudent uistudent, UIClassroom uiclassroom) {}

    @Override
    public void configureButton(ArrayList<UIRoom> roomsPanels, int roomID,ArrayList<String>questions,JButton [] buttons,
                                UIStudent uistudent,JTextArea textArea,UIClassroom uiclassroom) {

        button=new JButton();
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText("COMENZAR EXAMEN");

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(hasCredits(uistudent,uiclassroom) && hasObject(uistudent,uiclassroom)){
                    textArea.setText(questions.get(0));
                    button.setVisible(false);
                    JButton [] examButtons=buttons;
                    for(int i=0;i<3;i++){
                        examButtons[i].setVisible(true);
                    }
                }
                else if(!hasCredits(uistudent,uiclassroom)){
                    textArea.setText("Capo, te faltan creditos");
                }
                else{
                    textArea.setText("Capo, te falta el objecto");
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

    public boolean hasCredits(UIStudent uistudent,UIClassroom uiclassroom){

        if(uistudent.getStudent().getCredits()>=uiclassroom.getClassroom().getProfessor().getSubjectCreditsNeeded()){
            return true;
        }
        else {return false;}
    }

    public boolean hasObject(UIStudent uistudent,UIClassroom uiclassroom){

        ArrayList<Usable>objects=uistudent.getStudent().getBackpack();

        Usable objectNeeded=uiclassroom.getClassroom().getProfessor().getObjectNeeded();

        boolean hasObject=false;

        for(Usable U: objects){

            if(U.getName().equals(objectNeeded.getName()) && U.getDescription().equals(objectNeeded.getDescription())){
                hasObject=true;
                break;
            }
        }
        return hasObject;
    }


}

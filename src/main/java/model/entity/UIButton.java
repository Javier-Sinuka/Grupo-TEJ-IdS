package main.java.model.entity;

import main.java.model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIButton {

    private JButton button;

    private JButton buttons[];
    private int xpos;
    private int ypos;
    private int width;
    private int height;
    private int questionsCounter = 0;

    public UIButton(int xpos,int ypos,int width,int height){
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.height=height;

    }

    public void setAsWindowButton(ArrayList<JPanel> roomsPanels, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom){

        button=new JButton();
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText(buttonText);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                roomsPanels.get(roomID).setVisible(false);
                roomsPanels.get(destinyRoom).setVisible(true);
                roomsPanels.get(destinyRoom).add(uiStudent.getDataPanel());
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

    public void setAsExamButtons(ArrayList<String> questions,ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt,
                                 ArrayList<JPanel> roomsPanels, JTextArea textArea,int roomID,UIStudent uistudent,UIClassroom uiclassroom ){

        buttons=new JButton[3];
        int xpos=500;
        int ypos=500;

        for(int i = 0; i<3; i++) {
            buttons[i] = new JButton(options.get(0).get(i));
            buttons[i].setBounds(xpos,ypos,500, 50);
            buttons[i].setVisible(false);
            buttons[i].setFocusable(false);
            buttons[i].setVerticalTextPosition(JButton.TOP);
            roomsPanels.get(roomID).add(buttons[i]);
            ypos+=50;
        }


        for(int j=0;j<3;j++){
            buttons[j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }
                @Override
                public void mousePressed(MouseEvent e) {
                    Object source=e.getSource();
                    JButton button=(JButton)source;
                    String buttonText=button.getText();

                    if(buttonText.equals(correctOpt.get(questionsCounter))){
                        textArea.setText("Correct!!");
                        button.setBackground(Color.green);
                    }
                    else {
                        textArea.setText("Incorrect!");
                        // decrease lifeAmount
                        uistudent.getStudent().decreaseLifeBar(1);
                        uistudent.getDataPanel().removeAll();
                        uistudent.setDataPanel();
                        uiclassroom.repaint();
                        uiclassroom.revalidate();
                        uiclassroom.updateUI();
                    }

                }
                @Override
                public void mouseReleased(MouseEvent e){

                    try{ Thread.sleep(1000);}
                    catch(Exception E){}

                    if(questionsCounter==4){
                        for(int i=0;i<3;i++){
                            buttons[i].setVisible(false);
                        }
                    }
                    else{ setNewQuestion(buttons,questions,options,textArea); }

                    Object source=e.getSource();
                    JButton button=(JButton)source;
                    button.setBackground(null);
                }
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

        }

    }

    public void setNewQuestion(JButton[] buttons,ArrayList<String>questions,ArrayList<ArrayList<String>>options,JTextArea textArea){
        questionsCounter++;
        textArea.setText(questions.get(questionsCounter));
        buttons[0].setText(options.get(questionsCounter).get(0));
        buttons[1].setText(options.get(questionsCounter).get(1));
        buttons[2].setText(options.get(questionsCounter).get(2));
    }

    public void setAsExamStartButton(ArrayList<JPanel> roomsPanels, int roomID,ArrayList<String>questions,UIButton optionMenu,
                                     UIStudent uistudent,JTextArea textArea,UIClassroom uiclassroom){

        button=new JButton();
        button.setBounds(xpos,ypos,width,height);
        button.setFocusable(false);
        button.setText("COMENZAR EXAMEN");
        button.setFocusable(false);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(hasCredits(uistudent,uiclassroom) && hasObject(uistudent,uiclassroom)){
                    textArea.setText(questions.get(0));
                    button.setVisible(false);
                    JButton [] buttons=optionMenu.getOptionButtons();
                    for(int i=0;i<3;i++){
                        buttons[i].setVisible(true);
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

    public JButton[] getOptionButtons(){return buttons;}

    private boolean hasCredits(UIStudent uistudent,UIClassroom uiclassroom){

        if(uistudent.getStudent().getCredits()>=uiclassroom.getClassroom().getProfessor().getSubjectCreditsNeeded()){
            return true;
        }
        else {return false;}
    }

    private boolean hasObject(UIStudent uistudent,UIClassroom uiclassroom){

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

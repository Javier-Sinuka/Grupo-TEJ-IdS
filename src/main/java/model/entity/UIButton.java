package main.java.model.entity;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIButton {

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

        JButton newButton = new JButton(buttonText);
        newButton.setBounds(xpos,ypos,width,height);
        newButton.setFocusable(false);

        //Logica click del boton
        newButton.addMouseListener(new MouseListener() {
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
        roomsPanels.get(roomID).add(newButton);
    }

    public void setAsExamMenu(ArrayList<String> questions,ArrayList<ArrayList<String>> options, ArrayList<String> correctOpt,
                              ArrayList<JPanel> roomsPanels, JTextArea textArea,int roomID,UIStudent uistudent,UIClassroom uiclassroom ){

        JButton buttons[]=new JButton[3];
        int xpos=500;
        int ypos=500;

        for(int i = 0; i<3; i++) {
            buttons[i] = new JButton(options.get(0).get(i));
            buttons[i].setBounds(xpos,ypos,500, 50);
            buttons[i].setVisible(true);
            buttons[i].setFocusable(false);
            buttons[i].setVerticalTextPosition(JButton.TOP);
            roomsPanels.get(roomID).add(buttons[i]);
            ypos+=50;
        }

        //Primera pregunta
       textArea.setText(questions.get(0));

        for(int j=0;j<3;j++){
            buttons[j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object source=e.getSource();
                    JButton button=(JButton)source;
                    String buttonText=button.getText();
                    //System.out.println(buttonText);
                    //System.out.println(correctOpt.get(questionsCounter));

                    if(buttonText.equals(correctOpt.get(questionsCounter))){
                        textArea.setText("Correct!!");
                    }
                    else {
                        System.out.println("Incorrect");
                        textArea.setText("Incorrect!");
                        // decrease lifeAmount
                        uistudent.getStudent().decreaseLifeBar(1);
                        uistudent.getDataPanel().removeAll();
                        uistudent.setDataPanel();
                        uiclassroom.repaint();
                        uiclassroom.revalidate();
                        uiclassroom.updateUI();

                    }
                    setNewQuestion(buttons,questions,options,textArea);
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

        }

    }

    public void setNewQuestion(JButton[] buttons,ArrayList<String>questions,ArrayList<ArrayList<String>>options,JTextArea textArea){
        questionsCounter++;
        textArea.setText(questions.get(questionsCounter));
        buttons[0].setText(options.get(questionsCounter).get(0));
        buttons[1].setText(options.get(questionsCounter).get(1));
        buttons[2].setText(options.get(questionsCounter).get(2));
    }
}

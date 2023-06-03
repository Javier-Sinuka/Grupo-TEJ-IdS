package model.entity;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ExamButtons implements UIButton{

    private JButton [] buttons;

    private int questionsCounter=0;

    public  ExamButtons () {

        buttons=new JButton[3];

    }
    public JButton[] getButtons(){return buttons;}

    @Override
    public void configureButton() {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom) {
    }

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

        int xpos=500;
        int ypos=500;

        ArrayList<String>questions=uiclassroom.getClassroom().getQuestionsKeys();

        for(int i = 0; i<3; i++) {

            buttons[i] = new JButton(uiclassroom.getClassroom().getAnswersToTheQuestion(questions.get(0)).get(i));
            buttons[i].setBounds(xpos,ypos,500, 50);
            buttons[i].setVisible(false);
            buttons[i].setFocusable(false);
            buttons[i].setVerticalTextPosition(JButton.TOP);
            rooms.get(roomID).add(buttons[i]);
            ypos+=50;
        }

        for(int j=0;j<3;j++){
            buttons[j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {}
                @Override
                public void mousePressed(MouseEvent e) {
                    Object source=e.getSource();
                    JButton button=(JButton)source;
                    String buttonText=button.getText();

                    String correctOpt= uiclassroom.getClassroom().getCorrectOption(questions.get(questionsCounter));

                    if(buttonText.equals(correctOpt)){
                        textArea.setText("Correct!!");
                        //button.setBackground(Color.green);
                    }
                    else {
                        textArea.setText("Incorrect!!");
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

//                    if(questionsCounter==4){
//                        for(int i=0;i<3;i++){
//                            buttons[i].setVisible(false);
//                        }
//                    }
//                    else{ setNewQuestion(buttons,questions,options,textArea); }
//
//                    try{ Thread.sleep(1000);}
//                    catch(Exception E){}

                }
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

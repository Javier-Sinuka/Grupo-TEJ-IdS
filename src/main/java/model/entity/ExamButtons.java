package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class ExamButtons implements UIButton{

    private JButton[]buttons;

    private int buttonCounter=0;

    private int questionsCounter=0;

    LinkedList<String> questions;

    ArrayList<ArrayList<String>>options;



    public  ExamButtons () {

        buttons=new JButton[3];
    }

    public int getQuestionsCounter() { return questionsCounter;}


    public JButton[] getButtons(){return buttons;}

    @Override
    public void configureButton() {}

    @Override

    public void configureButton(JPanel inventoryPanel) {}

    public void configureButton(Usable usable, int ypos, UIStudent uiStudent, JLabel messageLabel, JPanel storeRoom, Boolean bar) {
    }
    @Override
    public void configureButton(UIStudent uiStudent, JPanel dataPanel, UIInventoryPanel inventoryPanel) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {}

    @Override
    public void configureButton(ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea, UIClassroom uiclassroom) {

        int xpos=580;
        int ypos=525;

        questions=uiclassroom.getClassroom().getQuestionsKeys();
        options=new ArrayList<>();

        for(String s: questions){
            options.add( uiclassroom.getClassroom().getAnswersToTheQuestion(s));
        }

        for(int i = 0; i<3; i++) {

            buttons[i] = new JButton(uiclassroom.getClassroom().getAnswersToTheQuestion(questions.get(0)).get(i));
            buttons[i].setBounds(xpos,ypos,550, 50);
            buttons[i].setVisible(false);
            buttons[i].setFocusable(false);
            buttons[i].setVerticalTextPosition(JButton.TOP);

            uiclassroom.addExamButton(buttons[i]);
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
                        uiclassroom.getClassroom().increaseCounterCorrectOption();
                    }
                    else {
                        textArea.setText("Incorrect!!");
                    }

                }

                @Override
                public void mouseReleased(MouseEvent e){

                    if(questionsCounter==4){

                        for(int i=0;i<3;i++){
                            buttons[i].setVisible(false);
                        }

                        if (uiclassroom.getClassroom().isExamPassed()){
                            //uistudent.getStudent().addCredits(uiclassroom.getClassroom().getProfessor().getCreditsIfPassed());
                            uistudent.getInventoryPanel().getGridPanel().removeAll();
                            uistudent.getInventoryPanel().getObjectPanel().removeAll();
                            uistudent.getInventoryPanel().removeAll();
                            uistudent.getInventoryPanel().parameterInventoryPanel();
                        }
                        else{
                            //uistudent.getStudent().decreaseLifeBar(uiclassroom.getClassroom().getProfessor().lifeToSubtractStudent());

                            int life=uistudent.getStudent().getLifeAmount();

                            life-=uiclassroom.getClassroom().getProfessor().lifeToSubtractStudent();

                            if(life<=0){
                                questionsCounter=0;
                                uiclassroom.getClassroom().getProfessor().resetCounterCorrectQuestions();
                                rooms.get(roomID).setVisible(false);
                                rooms.get(rooms.size()-1).setVisible(true);
                            }

                            uistudent.getStudent().decreaseLifeBar(uiclassroom.getClassroom().getProfessor().lifeToSubtractStudent());
                            uistudent.getDataPanel().removeAll();
                            uistudent.setDataPanel();
                            uiclassroom.repaint();
                            uiclassroom.revalidate();
                            uiclassroom.updateUI();
                            uiclassroom.getClassroom().getProfessor().resetCounterCorrectQuestions();

                            for(int i=0;i<3;i++){
                                buttons[i].setText(uiclassroom.getClassroom().getAnswersToTheQuestion(questions.get(0)).get(i));
                            }
                            questionsCounter=0;
                            uiclassroom.getExamStartButton().getButton().setVisible(true);

                        }

                        textArea.setText(uiclassroom.getClassroom().getProfessor().examResultInfo());
                        uiclassroom.getClassroom().getProfessor().resetCounterCorrectQuestions();
                    }

                    else{
                        setNewQuestion(buttons,questions,options,textArea);

                        try{ Thread.sleep(1000);}
                        catch(Exception E){}
                    }

                }

                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
            });

        }

    }

    @Override
    public void configureButton(ArrayList<UIRoom> rooms) {

    }

    public void setNewQuestion(JButton[] buttons,LinkedList<String>questions,ArrayList<ArrayList<String>>options,JTextArea textArea){
        questionsCounter++;
        textArea.setText(questions.get(questionsCounter));
        buttons[0].setText(options.get(questionsCounter).get(0));
        buttons[1].setText(options.get(questionsCounter).get(1));
        buttons[2].setText(options.get(questionsCounter).get(2));
    }

    public void addButton(JButton button){
        buttons[buttonCounter]=button;
        buttonCounter++;
    }


}
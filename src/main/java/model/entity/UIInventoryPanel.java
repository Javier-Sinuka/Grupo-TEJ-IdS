package model.entity;

import model.objects.Usable;
import org.mockito.internal.matchers.StartsWith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class UIInventoryPanel extends JPanel {
    private Student student;
    private JPanel gridPanel;
    private JPanel consumablePanel;
    private JPanel objectPanel;
    private HideButton hideButton;
    private JLabel imgProfileLabel;
    private JPanel confirmConsumable = new JPanel();
    public UIInventoryPanel(Student student){
        super();
        this.student = student;
        this.gridPanel = new JPanel();
        this.consumablePanel = new JPanel();
        this.objectPanel = new JPanel();
        this.hideButton = new HideButton();

        this.imgProfileLabel = new JLabel();
        this.confirmConsumable = new JPanel();

        confirmConsumable.setBounds(0,0,400,500);
        confirmConsumable.setBackground(Color.pink);
        confirmConsumable.setVisible(false);
        this.add(confirmConsumable);

        //Parameters
        parameterInventoryPanel();
    }
    public void parameterInventoryPanel(){
        //Parameters
        this.setBounds(700,100,400,500);
        this.setOpaque(true);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.lightGray);

        hideButton.configureButton(this);
        imgProfile();
        gridPanel();
    }
    public void imgProfile(){
        //Img profile
        ImageIcon imgProfile = new ImageIcon("src/main/assets/img/perfil.png");
        imgProfileLabel.setBounds(10,10,100,100);
        imgProfileLabel.setIcon(new ImageIcon(imgProfile.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        this.add(imgProfileLabel);
    }
    public void gridPanel(){
        //Object grill
        gridPanel.setBounds(10,130,380,320);
        gridPanel.setLayout(new GridLayout(2,0));

        consumablePanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        consumablePanel.setBackground(Color.red);
        objectPanel.setBackground(Color.white);

        gridPanel.add(consumablePanel);
        gridPanel.add(objectPanel);

        for(Usable usable : student.getBackpack()){

            switch (usable.getName()){
                case "Cafe":
                    ImageIcon coffe = new ImageIcon("src/main/assets/img/coffe.png");
                    JLabel coffeLabel = new JLabel();
                    coffeLabel.setIcon(new ImageIcon(coffe.getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
                    consumablePanel.add(coffeLabel);
                    coffeLabel.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            consumablePanel(coffeLabel, usable);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {                    }
                        @Override
                        public void mouseReleased(MouseEvent e) {}
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            coffeLabel.setSize(50,50);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            coffeLabel.setSize(45,45);
                        }
                    });
                    break;
                case "Mate":
                    ImageIcon mate = new ImageIcon("src/main/assets/img/mate.png");
                    JLabel mateLabel = new JLabel();
                    mateLabel.setBounds(0,0,50,50);
                    mateLabel.setIcon(new ImageIcon(mate.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
                    consumablePanel.add(mateLabel);
                    mateLabel.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {consumablePanel(mateLabel,usable);}
                        @Override
                        public void mousePressed(MouseEvent e) {}
                        @Override
                        public void mouseReleased(MouseEvent e) {}
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            mateLabel.setSize(60,60);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            mateLabel.setSize(50,50);
                        }
                    });
                    break;
                default:
                    System.out.println("No se hizo nada");
            }
        }
        this.add(gridPanel);
    }
    public void consumablePanel(JLabel label, Usable usable){
        //Agregar el panel grande del consumible

        confirmConsumable.setVisible(true);
        this.revalidate();
        this.repaint();
        this.updateUI();

        System.out.println("Consumiste " + usable.getName());
        consumablePanel.remove(label);
        student.deleteUsableInBackpack(usable);
        consumablePanel.revalidate();
        consumablePanel.repaint();
        student.printBP();
    }
    public JPanel getGridPanel(){
        return gridPanel;
    }
    public JPanel getConsumablePanel(){
        return consumablePanel;
    }
}

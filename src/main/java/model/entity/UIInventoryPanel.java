package main.java.model.entity;
import main.java.model.objects.Usable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIInventoryPanel extends JPanel {
    private Student student;
    JPanel grillPanel;
    public UIInventoryPanel(Student student){
        super();
        this.student = student;
        this.grillPanel = new JPanel();
        //Parameters
        parameterInventoryPanel();
        hideButton();
        imgProfile();
        gridPanel();
    }

    public void parameterInventoryPanel(){
        //Parameters
        this.setBounds(700,100,400,500);
        this.setOpaque(true);
        this.setVisible(false);
        this.setLayout(null);
        this.setBackground(Color.lightGray);
    }
    public void hideButton(){
        JButton hideInventoryButton = new JButton("-");
        hideInventoryButton.setBounds(340,470,50,20);
        hideInventoryButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                //inventoryPanelOpen = false;
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

        this.add(hideInventoryButton);

    }
    public void imgProfile(){
        //Img profile
        ImageIcon imgProfile = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/perfil.png"));
        JLabel imgProfileLabel = new JLabel();
        imgProfileLabel.setBounds(10,10,100,100);
        imgProfileLabel.setIcon(new ImageIcon(imgProfile.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        this.add(imgProfileLabel);
    }
    public void gridPanel(){
        //Object grill
        grillPanel.setBounds(10,130,380,320);
        grillPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        Usable obj1 = new Usable("Mate","Tomando mate");
        Usable obj2 = new Usable("Cafe","Tomando cafe");
        student.getBackpack().add(obj2);
        student.getBackpack().add(obj1);
        student.getBackpack().add(obj2);

        for(Usable usable : student.getBackpack()){
            if(usable.getName() == "Cafe"){
                ImageIcon coffe = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/coffe.png"));
                JLabel coffeLabel = new JLabel(coffe);
                coffeLabel.setBounds(0,0,50,50);
                grillPanel.add(coffeLabel);

                coffeLabel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Consumiste cafe");
                        grillPanel.remove(coffeLabel);
                        student.getBackpack().remove(usable);
                        grillPanel.revalidate();
                        grillPanel.repaint();
                        printBP(student.getBackpack());
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {}
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        coffeLabel.setSize(60,60);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        coffeLabel.setSize(50,50);
                    }
                });
            }else {
                ImageIcon mate = new ImageIcon(getClass().getClassLoader().getResource("main/assets/img/mate.png"));
                JLabel mateLabel = new JLabel();
                mateLabel.setBounds(0,0,50,50);
                mateLabel.setIcon(new ImageIcon(mate.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
                grillPanel.add(mateLabel);

                mateLabel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Consumiste mate");
                        grillPanel.remove(mateLabel);
                        student.getBackpack().remove(usable);
                        grillPanel.revalidate();
                        grillPanel.repaint();
                        printBP(student.getBackpack());
                    }
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
            }
        }

        this.add(grillPanel);
    }

    public void printBP(ArrayList<Usable> bp){
        for(Usable us : bp){
            System.out.println(us.getName());
        }
    }
}

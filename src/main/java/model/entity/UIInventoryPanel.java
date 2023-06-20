package model.entity;

import model.objects.Usable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class UIInventoryPanel extends UIRoom implements Subject{
    private Student student;
    private JPanel gridPanel;
    private JPanel consumablePanel;
    private JPanel objectPanel;
    private HideButton hideButton;
    private JLabel imgProfileLabel;
    private JProgressBar caffeineBar;
    private JProgressBar creditBar;

    private ArrayList<Observer> observers;
    public UIInventoryPanel(Student student){
        super();
        this.student = student;
        this.gridPanel = new JPanel();
        this.consumablePanel = new JPanel();
        this.objectPanel = new JPanel();
        this.hideButton = new HideButton();
        this.imgProfileLabel = new JLabel();
        this.caffeineBar = new JProgressBar(0,100);
        this.creditBar = new JProgressBar(0,100);
        observers=new ArrayList<>();
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
        caffeineBar();
        creditBar();
        dogecoin();
        nameLabel();
    }
    public void imgProfile(){
        //Img profile
        ImageIcon imgProfile = new ImageIcon("src/main/assets/img/imgLabels/perfil.png");
        imgProfileLabel.setBounds(10,10,100,100);
        imgProfileLabel.setIcon(new ImageIcon(imgProfile.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        this.add(imgProfileLabel);
    }
    public void caffeineBar(){
        caffeineBar.setBounds(120,50,250,20);
        caffeineBar.setForeground(Color.ORANGE);
        caffeineBar.setValue(student.getCaffeineAmount());
        caffeineBar.setStringPainted(true);
        caffeineBar.setString("Cafeina " + caffeineBar.getValue() + "%");
        this.add(caffeineBar);
    }
    public void creditBar(){
        creditBar.setBounds(120,80,250,20);
        creditBar.setForeground(Color.GRAY);
        creditBar.setValue(student.getCredits());
        creditBar.setStringPainted(true);
        creditBar.setString("Creditos " + creditBar.getValue() + "%");
        this.add(creditBar);
    }
    public void gridPanel(){
        //Object grill
        gridPanel.setBounds(10,140,380,320);
        gridPanel.setLayout(new GridLayout(2,0));

        consumablePanel.setLayout(new FlowLayout(FlowLayout.LEFT,15,15));
        consumablePanel.setBackground(Color.red);

        objectPanel.setLayout(new FlowLayout(FlowLayout.LEFT,15,15));
        objectPanel.setBackground(Color.white);

        gridPanel.add(consumablePanel);
        gridPanel.add(objectPanel);

        for(Usable usable : student.getBackpack()){

            switch (usable.getName()){
                case "Cafe":
                    addLabelInGridPanel(consumablePanel,usable,"src/main/assets/img/consumable/coffe.png");
                    break;
                case "Mate":
                    addLabelInGridPanel(consumablePanel,usable, "src/main/assets/img/consumable/mate.png");
                    break;
                case "Calculadora Casio FX":
                    addLabelInGridPanel(objectPanel,usable, "src/main/assets/img/item/calculator.png");
                    break;
                case "Kit de Componentes Electronicos":
                    addLabelInGridPanel(objectPanel,usable, "src/main/assets/img/item/KitComponentes.png");
                    break;
                case "Tabla de Integrales":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/tablaDeIntegrales.png");
                    break;
                case "Tabla de Derivadas":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/tablaDeDerivadas.png");
                    break;
                case "Tabla Periodica":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/TablaPeriodica.png");
                    break;
                case "Notebook":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/laptop.png");
                    break;
                case "Tablero de Dibujo Tecnico":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/board.png");
                    break;
                case "Libro de Algebra":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/algebraLibro.png");
                    break;
                case "Monografia de la UNC":
                    addLabelInGridPanel(objectPanel,usable,"src/main/assets/img/item/monografia.png");
                    break;
                    default:
            }
        }
        this.add(gridPanel);
    }
    public void addLabelInGridPanel(JPanel panel,Usable usable, String path){
        ImageIcon img = new ImageIcon(path);
        JLabel usabbleLabel = new JLabel();
        usabbleLabel.setBounds(0,0,50,50);
        usabbleLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
        panel.add(usabbleLabel);
        usabbleLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                updateConsumablePanel(usabbleLabel, usable, panel);
            }
            @Override
            public void mousePressed(MouseEvent e) {                    }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                usabbleLabel.setSize(50,50);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                usabbleLabel.setSize(45,45);
            }
        });
    }
    public void updateConsumablePanel(JLabel label, Usable usable, JPanel panel){

        //this.revalidate();
        //this.repaint();
        //this.updateUI();

        if(usable.getName() == "Cafe" || usable.getName() == "Mate"){


            if(usable.getName() == "Cafe") {

                if(student.getCaffeineAmount()==100){

                    // no se consume etiqueta de café
                }

                else if(student.getCaffeineAmount()+40>100){

                    int amountToAdd=0;
                    amountToAdd=100-student.getCaffeineAmount();
                    student.incrementCaffeine(amountToAdd);

                    caffeineBar.setValue(student.getCaffeineAmount());
                    caffeineBar.setString("Cafeina " + student.getCaffeineAmount() + "%");

                    student.deleteUsableInBackpack(usable);
                    panel.remove(label);
                    panel.revalidate();
                    panel.repaint();
                }

                else{
                    student.incrementCaffeine(40);
                    caffeineBar.setValue(student.getCaffeineAmount());
                    caffeineBar.setString("Cafeina " + student.getCaffeineAmount() + "%");

                    student.deleteUsableInBackpack(usable);
                    panel.remove(label);
                    panel.revalidate();
                    panel.repaint();
                }
            }
            else{

                if(student.getCaffeineAmount()==100){

                    // no se consume etiqueta de mate
                }

                else if(student.getCaffeineAmount()+20>100){

                    int amountToAdd=0;
                    amountToAdd=100-student.getCaffeineAmount();
                    student.incrementCaffeine(amountToAdd);

                    caffeineBar.setValue(student.getCaffeineAmount());
                    caffeineBar.setString("Cafeina " + student.getCaffeineAmount() + "%");

                    student.deleteUsableInBackpack(usable);
                    panel.remove(label);
                    panel.revalidate();
                    panel.repaint();
                }
                else{
                    student.incrementCaffeine(20);
                    caffeineBar.setValue(student.getCaffeineAmount());
                    caffeineBar.setString("Cafeina " + student.getCaffeineAmount() + "%");

                    student.deleteUsableInBackpack(usable);
                    panel.remove(label);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        }
    }
    public void dogecoin(){
        //Dogecoin label
        ImageIcon aux = new ImageIcon("src/main/assets/img/imgLabels/dogecoin.png");
        String coin = Integer.toString(student.getDogeCoinInWallet());
        ImageIcon imageDogecoin = new ImageIcon(aux.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        JLabel dogecoinLabel = new JLabel(coin,imageDogecoin,0);
        dogecoinLabel.setBounds(220,7,200,30);
        dogecoinLabel.setFont(new Font("Arial Black",Font.BOLD,30));
        this.add(dogecoinLabel);
    }
    public void nameLabel(){
        JLabel nameLabel = new JLabel(student.getNameStudent());
        nameLabel.setBounds(120,5,130,30);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,20)); //(tipo de letra, estilo, tamaño)
        this.add(nameLabel);
    }
    public JPanel getGridPanel(){
        return gridPanel;
    }
    public JPanel getConsumablePanel(){
        return consumablePanel;
    }
    public JPanel getObjectPanel(){
        return objectPanel;
    }

    @Override
    public void registerObserver(Observer O) {}

    @Override
    public void removeObserver(Observer O) {}

    @Override
    public void notifyObservers() {}


    @Override
    public void setButton(WindowButton windowBt, ArrayList<UIRoom> rooms, UIStudent uiStudent, String buttonText, int roomID, int destinyRoom,boolean start) {

    }

    @Override
    public void setButton(ExamStartButton startBt, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(ExamButtons examBts, ArrayList<UIRoom> rooms, int roomID, UIStudent uistudent, JTextArea textArea) {

    }

    @Override
    public void setButton(RestartButton restartBt, ArrayList<UIRoom> rooms) {

    }
}

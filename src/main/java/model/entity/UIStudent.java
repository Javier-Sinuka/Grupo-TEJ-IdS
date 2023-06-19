package model.entity;
import model.objects.Usable;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class UIStudent implements Observer{
    private Student student;
    private JPanel dataPanel;
    private JProgressBar lifeBar;
    private InventoryButton inventoryButton;
    private UIInventoryPanel inventoryPanel;
    private HideButton hideButton;
    private boolean inventoryPanelOpen;
    public UIStudent(){
        this.inventoryPanelOpen = false;
        this.student=new Student("Tomas Brigido",1,20,20,500);
        this.dataPanel = new JPanel();
        this.lifeBar = new JProgressBar(0,100);
        this.inventoryButton = new InventoryButton();
        this.inventoryPanel = new UIInventoryPanel(student);
        this.hideButton = new HideButton();
        setDataPanel();
    }
    public void setDataPanel(){
        dataPanel.setSize(1280,720);
        dataPanel.setOpaque(false);
        dataPanel.setVisible(true);
        dataPanel.setLayout(null);
        inventoryButton.configureButton(this,dataPanel,inventoryPanel);

        playerNameLabel();
        lifeBarLabel();
        setInventoryPanel();
    }
    public void playerNameLabel(){
        JLabel nameLabel = new JLabel(student.getNameStudent());
        nameLabel.setBounds(10,10,130,30);
        nameLabel.setFont(new Font("Arial Black", Font.BOLD,20)); //(tipo de letra, estilo, tamaño)
        dataPanel.add(nameLabel);
    }
    public void lifeBarLabel(){
        this.lifeBar.setBounds(10,50,210,20);
        this.lifeBar.setForeground(Color.red);
        this.lifeBar.setValue(student.getLifeAmount());
        this.lifeBar.setStringPainted(true);
        this.lifeBar.setString("Vida " + lifeBar.getValue() + "%");
        dataPanel.add(this.lifeBar);
    }
    public void setInventoryPanel(){
        hideButton.configureButton(inventoryPanel);
        dataPanel.add(inventoryPanel);
    }
    public Student getStudent(){return student;}
    public JPanel getDataPanel(){
        //aumentar paso
        student.modifyWalkCaffeine(); //modifica el cafe dependiendo de cuanto se camine
        return dataPanel;
    }
    public int getDogeCoin(){
        return student.getDogeCoinInWallet();
    }
    public UIInventoryPanel getInventoryPanel() {
        return inventoryPanel;
    }
    public boolean isInventoryPanelOpen() {
        return inventoryPanelOpen;
    }
    public void setInventoryPanelOpen(boolean inventoryPanelOpen) {
        this.inventoryPanelOpen = inventoryPanelOpen;
    }

    @Override
    public void update() {

        this.getDataPanel().removeAll();
        this.setDataPanel();

        // Ask tom for help

        //uiclassroom.repaint();
        //uiclassroom.revalidate();
        //uiclassroom.updateUI();

    }
}


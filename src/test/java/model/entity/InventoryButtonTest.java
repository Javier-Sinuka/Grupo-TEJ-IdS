package model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static org.junit.jupiter.api.Assertions.*;

class InventoryButtonTest {
    private InventoryButton inventoryButtonTest;
    private UIInventoryPanel inventoryPanelTest;
    private UIStudent uiStudent;
    private JPanel dataPaneltest;

    @BeforeEach
    void initialization(){

        inventoryPanelTest = new UIInventoryPanel(new Student());
        uiStudent = new UIStudent();
        dataPaneltest = new JPanel();
        inventoryPanelTest.setVisible(true);
        inventoryButtonTest = new InventoryButton();

    }

    @Test
    void configureButtonTest(){
        inventoryButtonTest.configureButton(uiStudent,dataPaneltest,inventoryPanelTest);

        JButton showPanel = inventoryButtonTest.getInventoryButton();

        MouseEvent ME1= new MouseEvent(showPanel,MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        for(MouseListener ML: showPanel.getMouseListeners()){ ML.mouseClicked(ME1); }

        assertTrue(inventoryPanelTest.isVisible());
    }


}
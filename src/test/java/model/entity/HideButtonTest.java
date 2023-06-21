package model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static org.junit.jupiter.api.Assertions.*;


class HideButtonTest {

    private HideButton hideButtonTest;
    JPanel inventoryPanelTest;

    @BeforeEach
    void initialization(){

        inventoryPanelTest=new JPanel();
        inventoryPanelTest.setVisible(true);
        hideButtonTest=new HideButton();

    }

    @Test
    void configureButtonTest(){
        hideButtonTest.configureButton(inventoryPanelTest);

        JButton hideButton=hideButtonTest.getButton();

        MouseEvent ME1= new MouseEvent(hideButton,MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 1, false);

        for(MouseListener ML: hideButton.getMouseListeners()){ ML.mouseClicked(ME1); }

        assertFalse(inventoryPanelTest.isVisible());
    }
}
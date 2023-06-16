package model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


class HideButtonTest {

    private HideButton hideButtonTest;
    JPanel inventoryPanelTest;

    @BeforeEach
    void initialization(){

        inventoryPanelTest=new JPanel();
        inventoryPanelTest.setVisible(false);

        hideButtonTest=new HideButton();

    }

    @Test
    void configureButtonTest(){
        hideButtonTest.configureButton(inventoryPanelTest);
        assertTrue(hideButtonTest.getButton().isVisible());
    }










}
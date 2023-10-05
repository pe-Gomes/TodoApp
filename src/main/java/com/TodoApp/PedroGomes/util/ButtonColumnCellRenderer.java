/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TodoApp.PedroGomes.util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pedro
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {
    private String buttonType;
    
    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));
        
        return label;
    }
    
    
    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
}
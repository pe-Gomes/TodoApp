package com.TodoApp.PedroGomes.util;

import com.TodoApp.PedroGomes.model.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pedro
 */
public class TaskTableModel extends AbstractTableModel {
    
    String[] col = {"Name", "Description", "Deadline", "Completed", "Edit", "Delete"};
    List<Task> tasks = new ArrayList<>();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                return date.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isCompleted();                
            case 4, 5:
                return "";
            default:
                return "Data not found";
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return colIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int colIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }
        
        return this.getValueAt(0, colIndex).getClass();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return col[columnIndex];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int colIndex) {
        tasks.get(rowIndex).setCompleted((boolean) aValue);
    }

    public String[] getCol() {
        return col;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }    
        
}

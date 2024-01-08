package com.EdgeSistemas.Teste.View;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer{
	
	private static Set<Object> firstClickSet = new HashSet<>();
	
	public CheckBoxRenderer() {
        setHorizontalAlignment(JCheckBox.CENTER);
    }

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		 setEnabled(table.isCellEditable(row, column));
	        setSelected(value != null && (boolean) value);
	        Object cellValue = table.getValueAt(row, 0);
	        if (cellValue != null ) {
	            putClientProperty("id", cellValue);
	            firstClickSet.add(cellValue);
	        } else {
	            putClientProperty("id", cellValue);
	        }

	        return this;
	    }
	
	
}
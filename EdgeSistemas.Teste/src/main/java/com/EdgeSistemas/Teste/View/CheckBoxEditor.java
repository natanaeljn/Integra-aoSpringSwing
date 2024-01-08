package com.EdgeSistemas.Teste.View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

@SuppressWarnings("serial")
public class CheckBoxEditor extends AbstractCellEditor implements TableCellEditor, ActionListener{
	
	private JCheckBox checkBox;
	private Object cellValue;

    public CheckBoxEditor() {
        checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
        checkBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        JCheckBox sourceCheckBox = (JCheckBox) e.getSource();
        cellValue = sourceCheckBox.getClientProperty("id");
        if (checkBox.isSelected()) {
            System.out.println("ID selecionado: " + cellValue);
            FormTelaView.idSel=cellValue;
            FormTelaEdit.idSelEdit= cellValue;
        } else {
            System.out.println("ID desselecionado: " + cellValue);
        }
    }

    @Override
    public Object getCellEditorValue() {
    	return checkBox.isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    	 checkBox.setSelected(value != null && (boolean) value);

    	    // Obtenha o valor diretamente do modelo da tabela
    	    Object cellValue = table.getValueAt(row, 0);
    	    checkBox.putClientProperty("id", cellValue);

    	    checkBox.setEnabled(table.isCellEditable(row, column));
    	    return checkBox;
    }
}
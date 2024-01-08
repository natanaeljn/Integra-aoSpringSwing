package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JFrame {
	
	
	private static final long serialVersionUID = 1L;


	
	
	
	private JTable table;
	private JTextField txtProcurar;
	 
	 private int paginaAtual = 1;
	 private int itensPorPagina = 5;

	
	public Tabela() {
		
       initComponentes();
	}
		
	private void initComponentes() {
		  setSize(900, 600);
	        
	        setVisible(true);
	        setLocationRelativeTo(null);
	        setResizable(false);
			
			
			getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
			getContentPane().setLayout(null);
			
			/*panel onde fica a tabela*/
			JPanel panel = new JPanel();
			panel.setBackground(new Color(88, 105, 220));
			panel.setBounds(68, 59, 759, 450);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			PanelTabela panelTabela =  new PanelTabela();
			panel.add(panelTabela);
			
			CriadorTabela tabela =  new CriadorTabela();
			panel.add(tabela);
			
			/*panel barra de cima, pesquisa , editar e ver
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(88, 105, 220));
			panel_1.setBounds(0, 0, 759, 51);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtProcurar = new JTextField();
			addPlaceholder(txtProcurar, "Buscar Produto");
			txtProcurar.setBounds(10, 13, 288, 24);
			panel_1.add(txtProcurar);
			txtProcurar.setColumns(10);
			
			JButton btnBotaoVer = new JButton("Ver");
			btnBotaoVer.setBounds(462, 14, 89, 23);
			panel_1.add(btnBotaoVer);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.setBounds(561, 14, 89, 23);
			panel_1.add(btnEditar);
			
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.setBounds(660, 14, 89, 23);
			panel_1.add(btnExcluir);
			*/
			
			/*botoes de paginação*/
			JPanel panelBotoes = new JPanel();
			panelBotoes.setBounds(308, 394, 174, 23);
			
			panel.add(panelBotoes);
			panelBotoes.setLayout(new GridLayout(0, 2, 0, 0));
			
			JButton btnNewButton = new JButton("Anterior");
			panelBotoes.add(btnNewButton);
			
			JButton btnProximo = new JButton("Proximo");
			panelBotoes.add(btnProximo);
			
			
			/*Tabela
			table = new JTable();
			table.setBounds(0, 52, 759, 313);
			panel.add(table);
			table.setBackground(new Color(255, 255, 255));
			table.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Teste", "teste", "teste", "teste", null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"ID", "Nome Produto", "Preco R$", "Marca", "CheckBox"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(1).setPreferredWidth(126);
			table.getColumnModel().getColumn(3).setPreferredWidth(146);
			table.getColumnModel().getColumn(4).setPreferredWidth(53);
			table.setRowHeight(50);
			table.getColumnModel().getColumn(4).setCellRenderer(new CheckBoxRenderer());
		    table.getColumnModel().getColumn(4).setCellEditor(new CheckBoxEditor());
		    */
	}
	
	/*
		private static void addPlaceholder(JTextField textField, String placeholder) {
	        textField.setForeground(Color.GRAY);
	        textField.setText(placeholder);

	        textField.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (textField.getText().equals(placeholder)) {
	                    textField.setText("");
	                    textField.setForeground(Color.BLACK);
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (textField.getText().isEmpty()) {
	                    textField.setForeground(Color.GRAY);
	                    textField.setText(placeholder);
	                }
	            }
	        });
		*/
		
	}


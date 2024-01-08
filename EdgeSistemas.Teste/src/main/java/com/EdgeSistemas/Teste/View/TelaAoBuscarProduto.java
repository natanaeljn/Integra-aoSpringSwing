package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaAoBuscarProduto extends JFrame {

	private JPanel contentPane;

	
	public static String nomeBuscado;
	

	/**
	 * Create the frame.
	 */
	public TelaAoBuscarProduto() {
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
			
			CriadorTabela tabela =  new CriadorTabela(nomeBuscado);
			panel.add(tabela);
			
			
			
			/*botoes de paginação*/
			JPanel panelBotoes = new JPanel();
			panelBotoes.setBounds(308, 394, 174, 23);
			
			panel.add(panelBotoes);
			panelBotoes.setLayout(new GridLayout(0, 2, 0, 0));
			
			JButton btnNewButton = new JButton("Anterior");
			panelBotoes.add(btnNewButton);
			
			JButton btnProximo = new JButton("Proximo");
			panelBotoes.add(btnProximo);
			
			
			
	}
	
	
		
	}
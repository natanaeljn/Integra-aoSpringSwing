package com.EdgeSistemas.Teste.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static final Color AZUL_EDGE = new Color(66,101,207);
	
	public Principal() {
		inicializarComponentes();
	}
	
	
	
	public void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EdgeSistemas");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		/*Logo da empresa*/
		PanelLogo panelLogo =  new PanelLogo();
		add(panelLogo, BorderLayout.NORTH);
		
		/*botoes */
		PanelBotoes botoes =  new PanelBotoes();
		
		int espacamentoSuperiorBotoes = 40; // espaçamento
        botoes.setBorder(new EmptyBorder(espacamentoSuperiorBotoes, 0, 0, 0));
		add(botoes,BorderLayout.CENTER);
		
	}

}

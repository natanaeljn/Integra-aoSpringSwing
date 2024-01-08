package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton{

	private static final long serialVersionUID = 1L;
	
	
	
	public Botao(String descricao ,  Color cor) {
		setText(descricao);
		setBackground(cor);
		setFont(new Font("consolas", Font.PLAIN ,  20));
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		/*cor da fonte*/
		setForeground(Color.WHITE);
		setAlignmentX(Component.CENTER_ALIGNMENT);
	}

}

package com.EdgeSistemas.Teste.View;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel{

	
	private static final long serialVersionUID = 1L;


	public PanelLogo() {
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
        ImageIcon imagem =  new ImageIcon(getClass().getResource("/Imagens/logo.png")); 
		JLabel logo =  new JLabel(imagem);
		add(logo);
		setPreferredSize(new Dimension(imagem.getIconWidth(), imagem.getIconHeight()));
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
}

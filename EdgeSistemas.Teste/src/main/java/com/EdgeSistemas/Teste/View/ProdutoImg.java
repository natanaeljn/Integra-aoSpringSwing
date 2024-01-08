package com.EdgeSistemas.Teste.View;

import java.lang.reflect.Constructor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProdutoImg extends JPanel{
	
	public ProdutoImg() {
		initComp();
	}
	
	public void initComp() {
		ImageIcon imagem =  new ImageIcon(getClass().getResource("/Imagens/imgTeste.jpg")); 
		JLabel logoImg =  new JLabel(imagem);
		add(logoImg);
		logoImg.setBounds(0, 0, 286, 263);
		
	}
}

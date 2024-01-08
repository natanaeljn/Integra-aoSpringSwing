package com.EdgeSistemas.Teste.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class TelaVerProduto extends JFrame {

	private JPanel contentPane;
	


	/**
	 * Create the frame.
	 */
	public TelaVerProduto() {
		
		setBounds(100, 100, 567, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ProdutoImg imgTeste =  new ProdutoImg();
		imgTeste.setBounds(0, 0, 250, 257);
		getContentPane().add(imgTeste);
		imgTeste.setLayout(null);
		
		FormTelaView form = new FormTelaView();
        // Ajuste os valores de setBounds conforme necessário
        form.setBounds(249, 114, 302, 100);
        contentPane.add(form);
		
		/*
		ImageIcon imagem =  new ImageIcon(getClass().getResource("/Imagens/imgTeste.jpg")); 
		JLabel logoImg =  new JLabel(imagem);
		logoImg.setBounds(0, 0, 286, 263);
		getContentPane().add(logoImg);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		*/
		
		
		/*
		Nome = new JTextField();
		Nome.setBounds(320, 190, 86, 20);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(187, 20, 0, 0);
		contentPane.add(label);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(379, 15, 27, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(310, 15, 27, 14);
		contentPane.add(lblPreco);
		
		textField = new JTextField();
		textField.setBounds(397, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(347, 13, 11, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(521, 15, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setBounds(454, 13, 29, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(521, 52, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		*/
		
		JLabel lblNewLabel_2 = new JLabel("Edge Sistemas , transformando vidas desde 2003");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(249, 225, 302, 17);
		contentPane.add(lblNewLabel_2);
		PanelLogo logo =  new PanelLogo();
		logo.setBounds(249, 0, 302, 115);
		getContentPane().add(logo);
	}
}

package com.EdgeSistemas.Teste.View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCadastro extends JPanel{

	
	private static final long serialVersionUID = 1L;

	public PanelCadastro() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		/*logo acima e centralizado manualmente*/
		PanelLogo logo =  new PanelLogo();
		add(logo);
		logo.setVisible(true);
		logo.setLocation(280,60);
		logo.setSize(300, 150);
		
		/*label de mensagem*/
	     JLabel	title =  new JLabel("Bem Vindo ao Cadastro de produtos");
	     title.setFont(new Font("Arial", Font.PLAIN, 30));
	     title.setSize(600,30);
	     title.setLocation(200,220);
	     add(title);
		
	     /*label e textId*/
	     JLabel idLabel =  new JLabel("ID:");
	     idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     idLabel.setSize(100, 20);
	     idLabel.setLocation(100, 400);
	     add(idLabel);
	     
	     JTextField idText =  new JTextField("Gerado automaticamente");
	     idText.setFont(new Font("Arial", Font.PLAIN, 17));
	     idText.setSize(150,20);
	     idText.setLocation(150, 400);
	     add(idText);
	     
	     /*label e textNome*/
	     JLabel nomeLabel =  new JLabel("Nome:");
	     nomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     nomeLabel.setSize(100, 20);
	     nomeLabel.setLocation(480, 400);
	     add(nomeLabel);
	     
	     JTextField nomeText =  new JTextField("Nome do Produto");
	     nomeText.setFont(new Font("Arial", Font.PLAIN, 17));
	     nomeText.setSize(300,20);
	     nomeText.setLocation(550, 400);
	     add(nomeText);
	     
	     /*label e textPreço*/
	     
	     JLabel precoLabel =  new JLabel("Preço:");
	     precoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     precoLabel.setSize(100, 20);
	     precoLabel.setLocation(70, 480);
	     add(precoLabel);
	     
	     JTextField precoText =  new JTextField("Valor");
	     precoText.setFont(new Font("Arial", Font.PLAIN, 17));
	     precoText.setSize(150,20);
	     precoText.setLocation(150, 480);
	     add(precoText);
	     
	     
	     JLabel marcaLabel =  new JLabel("Marca:");
	     marcaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     marcaLabel.setSize(100, 20);
	     marcaLabel.setLocation(480, 480);
	     add(marcaLabel);
	     
	     JTextField marcaText =  new JTextField("Nome da Marca");
	     marcaText.setFont(new Font("Arial", Font.PLAIN, 17));
	     marcaText.setSize(300,20);
	     marcaText.setLocation(550, 480);
	     add(marcaText);
	     
	     /*botao Limpar*/
	     Botao botaoLimpar =  new Botao("Limpar", TelaCadastro.AZUL_EDGE);
	     add(botaoLimpar);
	     botaoLimpar.setVisible(true);
	     botaoLimpar.setLocation(310, 540);
	     botaoLimpar.setSize(100, 40);
	     /*botao Cadastro*/
	     Botao botaoCad =  new Botao("Cadastro", TelaCadastro.VERDE_CADASTRO);
	     add(botaoCad);
	     botaoCad.setVisible(true);
	     botaoCad.setLocation(440, 540);
	     botaoCad.setSize(100, 40);
	}
}

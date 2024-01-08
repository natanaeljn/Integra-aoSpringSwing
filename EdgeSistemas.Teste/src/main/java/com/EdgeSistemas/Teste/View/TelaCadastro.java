package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.EdgeSistemas.Teste.Util.NumeroUtil;

public class TelaCadastro extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final Color AZUL_EDGE = new Color(66,101,207);
	public static final Color VERDE_CADASTRO = new Color(62,163,74);
	
	private JTextField nomeText =  new JTextField("Nome do Produto");
    private JTextField precoText =  new JTextField("Valor R$");
    private JTextField marcaText= new JTextField("Marca");
	
	public TelaCadastro() {
		inicializaComponentes();
	}
	
	public void inicializaComponentes() {
		setTitle("Cadastro de Produtos");
		setBounds(300, 90, 900, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		
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
	     idText.setEditable(false);
	     add(idText);
	     
	     /*label e textNome*/
	     JLabel nomeLabel =  new JLabel("Nome:");
	     nomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     nomeLabel.setSize(100, 20);
	     nomeLabel.setLocation(480, 400);
	     add(nomeLabel);
	     
	     
	     nomeText.setFont(new Font("Arial", Font.PLAIN, 17));
	     nomeText.setSize(300,20);
	     nomeText.setLocation(550, 400);
	     add(nomeText);
	     
	     /*label e textPreço*/
	     JLabel precoLabel = new JLabel("Preço");
	     precoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     precoLabel.setSize(100, 20);
	     precoLabel.setLocation(70, 480);
	     add(precoLabel);
	     
	    
	     precoText.setFont(new Font("Arial", Font.PLAIN, 17));
	     precoText.setSize(150,20);
	     precoText.setLocation(150, 480);
	     add(precoText);
	     
	     
	     JLabel marcaLabel =  new JLabel("Marca:");
	     marcaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	     marcaLabel.setSize(100, 20);
	     marcaLabel.setLocation(480, 480);
	     add(marcaLabel);
	     
	     
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
	     
	     botaoLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoLimparForm();
				
			}
		});
	     
	     /*botao Cadastro*/
	     Botao botaoCad =  new Botao("Cadastro", TelaCadastro.VERDE_CADASTRO);
	     add(botaoCad);
	     botaoCad.setVisible(true);
	     botaoCad.setLocation(440, 540);
	     botaoCad.setSize(100, 40);
	     
	     botaoCad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				metodoCadastro();
			}
		});
	     
	    
       
       
	}
	
	private void metodoCadastro() {
		
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			
			/*URI do ENDPOINT*/
			URI uri = new URI("http://localhost:8080/produtos");
			/*formatação caso  o numero venha com ,*/
			NumeroUtil.trocaVirgula(precoText.getText());
			String precoFormatado = NumeroUtil.trocaVirgula(precoText.getText());
			System.out.println(precoFormatado);
			
			/*corpo da requisição*/
			String requestBody = String.format(
					"{\"nome\":\"%s\", \"preco\":%s, \"marca\":\"%s\"}",
					nomeText.getText() , precoFormatado , marcaText.getText()
					);
			
			/*criando requisição POST com o corpo*/
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.build();
			
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(response.statusCode() == 200) {
			JOptionPane.showMessageDialog(this,"Produto Adicionado com Sucesso" ,  response.body() ,  JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this,"Erro ao adicionar produto, verifique todas"
						+ "as credenciais se estao corretas. Erro :"+ response.body() ,  response.body() ,  JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void metodoLimparForm() {
		nomeText.setText("");
		precoText.setText("");
		marcaText.setText("");
	}

}

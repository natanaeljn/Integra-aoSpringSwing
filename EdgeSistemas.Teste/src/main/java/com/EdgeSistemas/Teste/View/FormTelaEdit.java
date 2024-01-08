package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.EdgeSistemas.Teste.Model.Produto;
import com.EdgeSistemas.Teste.Util.NumeroUtil;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class FormTelaEdit extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textNome;
	
	public static Object idSelEdit;

	public FormTelaEdit() {
		setBackground(new Color(83, 94, 223));
		initComp();
		carregarProdutoPorCodigo();
	}

	
	public void initComp() {
        setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(10, 11, 24, 24);
		add(lblID);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setBounds(10, 46, 37, 24);
		add(lblPreco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(91, 11, 37, 24);
		add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setBounds(117, 46, 37, 24);
		add(lblMarca);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(44, 48, 63, 20);
		add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBounds(157, 48, 133, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setBounds(44, 13, 37, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNome.setBounds(131, 13, 159, 20);
		add(textNome);
		textNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(201, 79, 89, 23);
		add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvarBtn();
				
			}
		});

	}
	
	private void salvarBtn() {
		
		String precoFormatado = NumeroUtil.trocaVirgula(textField.getText());
		Double precoAtt =  Double.parseDouble(precoFormatado);
		Long idParse =  Long.parseLong(textField_2.getText());
		Produto prodAtt = new Produto(idParse, textNome.getText(), precoAtt, textField_1.getText());
		
		attProd(idParse, prodAtt);
		carregarProdutoPorCodigo();
		
	}
	/*conversor Object para Long*/
	 private Long converterParaLong(Object valor) {
	        if (valor instanceof Long) {
	            return (Long) valor;
	        } else if (valor instanceof Integer) {
	            return ((Integer) valor).longValue();
	        } else if (valor instanceof String) {
	            try {
	                return Long.parseLong((String) valor);
	            } catch (NumberFormatException e) {
	                
	                e.printStackTrace();
	            }
	        }
	        return null; 
	    }
	 
	public void carregarProdutoPorCodigo() {
		Long codigo =  converterParaLong(idSelEdit);
        Produto produto = getProdutoPorCodigo(codigo);

        if (produto != null) {
            // Preencha os campos com os dados do produto
            textField_2.setText(String.valueOf(produto.getId()));
            textField.setText(String.valueOf(produto.getPreco()));
            textNome.setText(produto.getNome());
            textField_1.setText(produto.getMarca());
        }
    }
	
	private Produto getProdutoPorCodigo(Long codigo) {
		try {
			
			HttpClient httpClient =  HttpClient.newHttpClient();
			URI uri =  new URI("http://localhost:8080/produtos/buscaPorCodigo/" + codigo);
			
			HttpRequest httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.GET()
					.build();
			HttpResponse<String>httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				 Gson gson = new Gson();
	             return gson.fromJson(httpResponse.body(), Produto.class);
			}
			else {
			System.out.println("erro na chamada"+ httpResponse.statusCode());
			return null;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void attProd(Long codigo,Produto produto) {
try {
			
	
	        Gson gson =  new Gson();
	        String produtoJson =  gson.toJson(produto);
	        
	
			HttpClient httpClient =  HttpClient.newHttpClient();
			URI uri =  new URI("http://localhost:8080/produtos/alterarProduto/" + codigo);
			
			HttpRequest httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.PUT(HttpRequest.BodyPublishers.ofString(produtoJson))
					.build();
			HttpResponse<String>httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				JOptionPane.showMessageDialog(this,"Produto Alterado com Sucesso" ,  httpResponse.body() ,  JOptionPane.INFORMATION_MESSAGE);
	             
			}
			else {
			JOptionPane.showMessageDialog(this,"Erro ao adicionar produto, verifique todas"
					+ "as credenciais se estao corretas. Erro :"+ httpResponse.body() ,  httpResponse.body() ,  JOptionPane.WARNING_MESSAGE);
			}
					
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}



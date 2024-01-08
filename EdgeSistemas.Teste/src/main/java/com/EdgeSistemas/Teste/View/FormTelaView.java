package com.EdgeSistemas.Teste.View;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.EdgeSistemas.Teste.Model.Produto;
import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class FormTelaView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textNome;
	
	public static Object idSel;

	public FormTelaView() {
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
		textField.setEditable(false);
		textField.setBounds(44, 48, 63, 20);
		add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setEditable(false);
		textField_1.setBounds(157, 48, 133, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setEditable(false);
		textField_2.setBounds(44, 13, 37, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNome.setEditable(false);
		textNome.setBounds(131, 13, 159, 20);
		add(textNome);
		textNome.setColumns(10);

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
		Long codigo =  converterParaLong(idSel);
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
			System.out.println("erro na chamada"+ httpResponse.statusCode());
			return null;
					
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

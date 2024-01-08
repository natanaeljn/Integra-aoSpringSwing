package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Font;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.EdgeSistemas.Teste.Dto.ProdutoDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

@SuppressWarnings("serial")
public class CriadorTabela extends JTable{
	private JTable table;
	
	public CriadorTabela() {
		initComponentes();
		setVisible(true);
		setEnabled(true);
		atttTabelaProdutos();
	}
	public CriadorTabela(String nomeBuscar) {
		initComponentes();
		setVisible(true);
		setEnabled(true);
		atttTabelaProdutosMarcaNome(nomeBuscar);
	}
	
	public void  initComponentes() {
		
		setBounds(0, 52, 759, 313);
		setBackground(new Color(255, 255, 255));
		setFont(new Font("Times New Roman", Font.PLAIN, 25));
		setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Nome Produto", "Preco R$", "Marca", "CheckBox"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getColumnModel().getColumn(1).setPreferredWidth(126);
		getColumnModel().getColumn(3).setPreferredWidth(146);
		getColumnModel().getColumn(4).setPreferredWidth(53);
		setRowHeight(50);
		getColumnModel().getColumn(4).setCellRenderer(new CheckBoxRenderer());
	    getColumnModel().getColumn(4).setCellEditor(new CheckBoxEditor());
	    
	    
	}
	
	private void atttTabelaProdutosMarcaNome(String nome) {
	    SwingUtilities.invokeLater(() -> {
	        DefaultTableModel model = (DefaultTableModel) getModel();

	        if (model != null) {
	            List<ProdutoDto> produtos = getListaProdutosNome(nome);
	            List<ProdutoDto> produtosMarca = getListaProdutosMarca(nome);
	            if(produtos!= null) {
	            	produtos.addAll(produtosMarca);
	            }
	            if(produtosMarca!=null) {
	            	produtosMarca.addAll(produtos);
	            }

	            for (ProdutoDto produtoDto : produtos) {
	                model.addRow(new Object[]{
	                        produtoDto.id(),
	                        produtoDto.nome(),
	                        produtoDto.preco(),
	                        produtoDto.marca(),
	                        null
	                });
	            }
	        } else {
	            System.out.println("Model nulo");
	        }
	    });
	}
	
	private void atttTabelaProdutos() {
	    SwingUtilities.invokeLater(() -> {
	        DefaultTableModel model = (DefaultTableModel) getModel();

	        if (model != null) {
	            List<ProdutoDto> produtos = getListaProdutosDoEndpoit();
	            System.out.println("Número de produtos: " + produtos.size());

	            for (ProdutoDto produtoDto : produtos) {
	                model.addRow(new Object[]{
	                        produtoDto.id(),
	                        produtoDto.nome(),
	                        produtoDto.preco(),
	                        produtoDto.marca(),
	                        null
	                });
	            }
	        } else {
	            System.out.println("Model nulo");
	        }
	    });
	}
	
	private List<ProdutoDto> getListaProdutosDoEndpoit(){
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			
			URI uri =  new URI("http://localhost:8080/produtos/todosProdutos");
			
			HttpRequest  httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.GET()
					.build();
			
			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				String responseBody = httpResponse.body();
				List<ProdutoDto> listaProdutos = converterJsonParaLista(responseBody);

                return listaProdutos;
			}
			
				System.out.println("Erro na chamada ao endpoint: " + httpResponse.statusCode());
                return List.of();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private List<ProdutoDto> getListaProdutosNome(String nomeTes){
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			String nome= URLEncoder.encode(nomeTes, StandardCharsets.UTF_8);
			
			URI uri =  new URI("http://localhost:8080/produtos/buscaPorNome/"+nome);
			
			HttpRequest  httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.GET()
					.build();
			
			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				String responseBody = httpResponse.body();
				List<ProdutoDto> listaProdutos = converterJsonParaLista(responseBody);

                return listaProdutos;
			}
			
				System.out.println("Erro na chamada ao endpoint: " + httpResponse.statusCode());
                return List.of();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private List<ProdutoDto> getListaProdutosMarca(String marcaTes){
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			String marca = URLEncoder.encode(marcaTes, StandardCharsets.UTF_8);
			URI uri =  new URI("http://localhost:8080/produtos/buscaPorMarca/"+marca);
			
			HttpRequest  httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.GET()
					.build();
			
			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				String responseBody = httpResponse.body();
				List<ProdutoDto> listaProdutos = converterJsonParaLista(responseBody);

                return listaProdutos;
			}
			
				System.out.println("Erro na chamada ao endpoint: " + httpResponse.statusCode());
                return List.of();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/*conversao da lista que vira em JSON para Java*/
	public List<ProdutoDto>converterJsonParaLista(String json){
		Gson gson = new Gson();
        Type tipoListaProdutos = new TypeToken<List<ProdutoDto>>() {}.getType();

        return gson.fromJson(json, tipoListaProdutos);
	}
}

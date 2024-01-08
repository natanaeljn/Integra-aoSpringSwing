package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaExclusaoProd extends JFrame {

	private JPanel contentPane;

	
	
	

	
	public TelaExclusaoProd() {
		
		setBounds(100, 100, 417, 135);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 75, 207));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setVisible(true);

		fecharTela();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tem certeza que deseja Excluir este Produto?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 11, 359, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(null);
		btnExcluir.setBounds(59, 54, 89, 23);
		contentPane.add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Long codigo =  converterParaLong(FormTelaEdit.idSelEdit);
				excluirProduto(codigo);
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(250, 54, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTabela();
				
				
			}
		});
		
		

	}
	
	private void abrirTabela() {
        SwingUtilities.invokeLater(() -> {
        	dispose();
        	new Tabela();
        });
    }
	
	private String excluirProduto(Long codigo) {
		try {
			
			HttpClient httpClient =  HttpClient.newHttpClient();
			URI uri =  new URI("http://localhost:8080/produtos/deletarProduto/" + codigo);
			
			HttpRequest httpRequest =  HttpRequest.newBuilder()
					.uri(uri)
					.header("Content-Type", "application/json")
					.DELETE()
					.build();
			HttpResponse<String>httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
			if(httpResponse.statusCode()==200) {
				JOptionPane.showMessageDialog(this,"Produto Excluido com Sucesso" ,  httpResponse.body() ,  JOptionPane.OK_OPTION);
				dispose();
				abrirTabela();
			}
			else {
				JOptionPane.showMessageDialog(this,"Erro ao excluir o produto, verifique se o "
						+ "Id foi selecionado" ,  httpResponse.body() ,  JOptionPane.ERROR_MESSAGE);
				dispose();
			    abrirTabela();
			    
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void fecharTela() {
		addWindowListener(new WindowAdapter() {
			 @Override
	            public void windowClosing(WindowEvent e) {
	                // Chama o método para abrir a outra tela ao fechar esta
	                abrirTabela();
	            }
		});
	}
	
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
	
}

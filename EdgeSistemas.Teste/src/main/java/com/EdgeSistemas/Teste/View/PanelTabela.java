package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PanelTabela extends JPanel{
	private JTextField txtProcurar;
	
	public PanelTabela() {
		initComponentes();
	}
	
	private void initComponentes() {
		setBackground(new Color(88, 105, 220));
		setBounds(0, 0, 759, 51);
		setLayout(null);
		
		txtProcurar = new JTextField();
		addPlaceholder(txtProcurar, "Buscar Produto");
		txtProcurar.setBounds(10, 13, 288, 24);
		add(txtProcurar);
		txtProcurar.setColumns(10);
		
		
		JButton btnBotaoBuscar = new JButton("Buscar");
		btnBotaoBuscar.setBounds(300, 14, 89, 23);
		add(btnBotaoBuscar);
		btnBotaoBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaAoBuscarProduto.nomeBuscado= txtProcurar.getText();
				abrirTelaBuscar();
				
			}
		});
		
		
		JButton btnBotaoVer = new JButton("Ver");
		btnBotaoVer.setBounds(462, 14, 89, 23);
		add(btnBotaoVer);
		btnBotaoVer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTelaVerProduto();
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(561, 14, 89, 23);
		add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTelaEditarProduto();
				
				 
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(660, 14, 89, 23);
		add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTelaExcluirProduto();
				
			}
		});
	}
	private void abrirTelaVerProduto() {
        SwingUtilities.invokeLater(() -> {
            new TelaVerProduto();
        });
    }
	private void abrirTelaEditarProduto() {
        SwingUtilities.invokeLater(() -> {
            new TelaEditProd();
            /*fecha a janela da tabela, para reabri-la apos salvar o produto e ja atualizada*/
            Window window = SwingUtilities.getWindowAncestor(this);
	        window.dispose();
        });
    }
	
	private void abrirTelaExcluirProduto() {
        SwingUtilities.invokeLater(() -> {
            
            
            Window window = SwingUtilities.getWindowAncestor(this);
	        window.dispose();
	        new TelaExclusaoProd();
        });
    }
	private void abrirTelaBuscar() {
        SwingUtilities.invokeLater(() -> {
            
            
            Window window = SwingUtilities.getWindowAncestor(this);
	        window.dispose();
	        new TelaAoBuscarProduto();
        });
    }
	
	private static void addPlaceholder(JTextField textField, String placeholder) {
        textField.setForeground(Color.GRAY);
        textField.setText(placeholder);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
	

}}

package com.EdgeSistemas.Teste.View;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaEditProd extends JFrame {

	private JPanel contentPane;

	

	
	public TelaEditProd() {
		addWindowListener(new WindowAdapter() {
			 @Override
	            public void windowClosing(WindowEvent e) {
	                // Chama o método para abrir a outra tela ao fechar esta
	                abrirTabela();
	            }
		});
		
		
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
		
		FormTelaEdit form = new FormTelaEdit();
        // Ajuste os valores de setBounds conforme necessário
        form.setBounds(249, 114, 302, 100);
        contentPane.add(form);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Edge Sistemas , transformando vidas desde 2003");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(249, 225, 302, 17);
		contentPane.add(lblNewLabel_2);
		PanelLogo logo =  new PanelLogo();
		logo.setBounds(249, 0, 302, 115);
		getContentPane().add(logo);
	}
	
	private void abrirTabela() {
		Tabela tabela =  new Tabela();
		
	}

}

package com.EdgeSistemas.Teste.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelBotoes  extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private final Color AZUL_EDGE = new Color(66,101,207);
	
	public PanelBotoes () {
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		criadorRedirecionador(new Botao("Cadastrar Produto", AZUL_EDGE), "cadastrar");
		add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento de 10 pixels
		criadorRedirecionador(new Botao("Listar Produtos", AZUL_EDGE), "listar");
		add(Box.createRigidArea(new Dimension(0, 10)));
		}
	
	private void criadorRedirecionador(Botao botaoRed , String tipo) {
		add(botaoRed);
		botaoRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tipo.equals("cadastrar")) {
					abrirTelaCadastroProduto();
				}
				else if(tipo.equals("listar")) {
					abrirTelaListagem();
				}
				else if(tipo.equals("deletar")) {
					
				}
				else {
					
				}
				
			}
		});
	}

	private void abrirTelaCadastroProduto() {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastro();
        });
    }
	
	private void abrirTelaListagem() {
		SwingUtilities.invokeLater(()->{
			new Tabela();
		});
	}
}

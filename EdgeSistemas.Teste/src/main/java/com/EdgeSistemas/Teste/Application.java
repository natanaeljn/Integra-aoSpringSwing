package com.EdgeSistemas.Teste;

import javax.swing.SwingUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EdgeSistemas.Teste.View.Principal;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 SwingUtilities.invokeLater(() -> {
	            Principal telaInicial = new Principal();
	            telaInicial.setVisible(true);
	        });
	}

}

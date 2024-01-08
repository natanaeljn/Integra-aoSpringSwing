package com.EdgeSistemas.Teste.Configuration;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class AplicativoConfiguracao {

	
	 @PostConstruct
	    public void configureHeadlessMode() {
	        System.setProperty("java.awt.headless", "false");
	    }
}

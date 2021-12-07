package br.com.controle.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.controle.config.AppConfiguration;
import br.com.controle.config.DynamoDbConfig;


@SpringBootApplication
public class MainMensalApplicationApi {

	public static void main(String[] args) {
	    new SpringApplicationBuilder(
	   		MainMensalApplicationApi.class,
	   		AppConfiguration.class,
	   		DynamoDbConfig.class
	    ).run();
	}
}

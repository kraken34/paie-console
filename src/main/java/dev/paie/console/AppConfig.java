package dev.paie.console;

import java.util.Scanner;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// option => je définie exactement ce qu'il y aura dans le contexte
// @Import({Menu.class, CotisationServiceMemoire.class})
@ComponentScan({"dev.paie.ihm", "dev.paie.service"})
public class AppConfig {
	
	private Scanner scanner;
	
	@Bean
	public Scanner scanner() {
		scanner = new Scanner(System.in);
		return scanner;
	}
	
	@PreDestroy
	public void onDestroy() {
		System.out.println("On détruit " + scanner);
		scanner.close();
	}

}

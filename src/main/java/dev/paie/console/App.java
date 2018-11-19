package dev.paie.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.ihm.Menu;

/**
 *1 Ajouter dépendance Maven
 *2 Créer contexte spring
 *
 */
public class App {
	
	
	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) { // créer contexte Spring
			
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
			
		}
		
		/*Scanner scanner = new Scanner(System.in);
		CotisationService cotisService = new CotisationServiceMemoire();
		
		Menu menu = new Menu(scanner, cotisService);
		menu.demarrer();
	
		scanner.close();*/
	}
}

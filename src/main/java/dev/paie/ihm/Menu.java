package dev.paie.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;
@Controller
public class Menu {
	
	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;
	

	@Autowired
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService,context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		
		//recherches des beans Spring de type OptionMenu
		Map<String,OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);
		
		//création d'un incrément, remplace le i++ à cause de la lambda
		AtomicInteger index = new AtomicInteger();
		
		beansTrouves.forEach((cle,valeur)->{
			this.options.put(index.incrementAndGet(), valeur);
		});
	}
	
	public void demarrer() {
		
		while(true) {
			this.options.forEach((key, option) -> {
				System.out.println(key + ". " + option.getLibelle());
			});
			
			int optionMenuChoisie = this.scanner.nextInt();
			
			this.options.get(optionMenuChoisie).executer();
			
		}
		// Afficher les libellés des options
		
	}
	

	
	
	


}

package dev.paie.ihm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import dev.paie.domain.Cotisation;
import dev.paie.service.CotisationService;

@Controller
public class Menu {

	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;

	@Autowired
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService, context);
		this.scanner = scanner;
	}

	private void init2(Scanner scanner, CotisationService cotisService, ApplicationContext context) {

		// recherche dans le contexte des beans Spring de type OptionMenu
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		// création d'un incrément
		// remplace le i++ à cause de la lambda
		AtomicInteger increment = new AtomicInteger();

		beansTrouves.forEach((idSpring, valeur) -> {
			this.options.put(increment.incrementAndGet(), valeur);
		});
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {

		// recherche dans le contexte des beans Spring de type OptionMenu
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		Collection<OptionMenu> optionsTrouve = beansTrouves.values();
		
		int i = 1;
		
		for(OptionMenu opt : optionsTrouve) {
			this.options.put(i, opt);
			i++;
		}
	}

	public void demarrer() {

		// Afficher les libellés des options
		this.options.forEach((key, option) -> {
			System.out.println(key + ". " + option.getLibelle());
		});

		int optionMenuChoisie = this.scanner.nextInt();

		this.options.get(optionMenuChoisie).executer();

	}
	

}

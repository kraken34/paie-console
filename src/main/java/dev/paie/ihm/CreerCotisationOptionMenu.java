package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;
@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private Scanner scanner;

	@Autowired
	private CotisationService cotisService;
	
	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");
		String codeSaisie = this.scanner.next();
		
		System.out.println("Veuillez saisir le libelle : ");
		String libelleSaisie = this.scanner.next();
		
		System.out.println("Veuillez saisir s'il est imposable : ");
		boolean imposable = this.scanner.nextBoolean();
		
		System.out.println("Veuillez saisir le taux patronal : ");
		BigDecimal tauxPatronal = this.scanner.nextBigDecimal();
		
		System.out.println("Veuillez saisir le taux salarial : ");
		BigDecimal tauxSalarial = this.scanner.nextBigDecimal();
		
	
		
		cotisService.sauver(codeSaisie, libelleSaisie, imposable, tauxPatronal, tauxSalarial);
		System.out.println("on a sauvé");
		
		
	}
	
}

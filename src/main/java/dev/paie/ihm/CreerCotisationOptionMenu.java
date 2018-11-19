package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private Scanner scanner;

	public CreerCotisationOptionMenu() {
		super("Créer une cotisation");
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");

		String codeSaisie = this.scanner.next();
		
		System.out.println("Vous avez saisie :" + codeSaisie);
		
		
		
	}

}

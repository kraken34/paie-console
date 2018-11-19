package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired Scanner scanner;
	
	public SupprimerCotisationOptionMenu() {
		super("Supprimer cotisation");
	}

	@Override
	public void executer() {
		
		int idCotis = scanner.nextInt();
		
		System.out.println("idCotis" + idCotis);

	}

}

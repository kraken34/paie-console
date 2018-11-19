package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired Scanner scanner;
	
	@Autowired CotisationService service; 
	
	public SupprimerCotisationOptionMenu() {
		super("Supprimer cotisation");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executer() {
		// TODO Auto-generated method stub
		System.out.println("Quelle cotisation voulez-vous supprimer ?");
		int idCotis = scanner.nextInt();
		System.out.println("idCotis "+ idCotis);
		
		service.supprimer(idCotis);
	}

}

package dev.paie.ihm;

import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class ListerCotisationsOptionMenu extends OptionMenu {

	private CotisationService cotisService;

	public ListerCotisationsOptionMenu(CotisationService cotisService) {
		super("Lister les cotisations");
		this.cotisService = cotisService;
	}

	@Override
	public void executer() {
		System.out.println("Listage en cours");
		this.cotisService.lister().forEach(cotis -> System.out.println(cotis.getCode()));
		
	}

}

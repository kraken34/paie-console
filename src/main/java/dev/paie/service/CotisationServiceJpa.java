package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class CotisationServiceJpa implements CotisationService {

	@Autowired
	private CotisationRepository cotisationRepository;
	
	//private List<Cotisation> cotisations = new ArrayList<>();
	
	@Override
	public List<Cotisation> lister() {
		return cotisationRepository.findAll();
	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		Cotisation cotis = new Cotisation();
		cotis.setCode(code);
		cotis.setLibelle(libelle);
		cotis.setTauxPatronal(tauxPatronal);
		cotis.setTauxSalarial(tauxSalarial);
		cotis.setImposable(imposable);
		
		cotisationRepository.save(cotis);
		
	
		return cotis;
	}
	
	@Override
	public void supprimer(int id) {
		cotisationRepository.delete(id);
		
	}

}

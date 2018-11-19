package dev.paie.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cotisation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	
	private String code;
	private String libelle;
	private BigDecimal tauxSalarial;
	private BigDecimal tauxPatronal;
	private Boolean imposable = false;
	
	
	public Cotisation() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}


	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}


	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}


	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}


	public Boolean getImposable() {
		return imposable;
	}


	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}
	
	


	
	
	

}

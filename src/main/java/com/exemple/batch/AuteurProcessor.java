package com.exemple.batch;

import org.springframework.batch.item.ItemProcessor;

import com.exemple.beans.Auteur;

public class AuteurProcessor implements ItemProcessor<Auteur, Auteur> {

	@Override
	public Auteur process(Auteur auteur) throws Exception {
		auteur.setCategorie(this.getCategory(auteur.getPrenom(), auteur.getNom()));
		return auteur;
	}
	
	/**
	 * mock un webservice
	 * @param prenom
	 * @param nom
	 * @return
	 */
	public String getCategory(String prenom, String nom){
		
		if(prenom.equals("Jean Christophe") && nom.equals("Grange")){
			return "policier";
		}else{
			return "fantastique";
		}
	}
}

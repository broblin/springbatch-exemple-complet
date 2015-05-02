package com.exemple.beans;

public class Livre {
	String titre;
	int auteurId;
	String prenomAuteur;
	String nomAuteur;
	String editeur;
	float prix;
	
	public Livre() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAuteurId() {
		return auteurId;
	}

	public void setAuteurId(int auteurId) {
		this.auteurId = auteurId;
	}

	public String getPrenomAuteur() {
		return prenomAuteur;
	}

	public void setPrenomAuteur(String prenomAuteur) {
		this.prenomAuteur = prenomAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteurId=" + auteurId
				+ ", prenomAuteur=" + prenomAuteur + ", nomAuteur=" + nomAuteur
				+ ", editeur=" + editeur + ", prix=" + prix + "]";
	}
}

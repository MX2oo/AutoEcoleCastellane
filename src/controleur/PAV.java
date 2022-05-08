package controleur;

public class PAV {
	private String nom, prenom, voiture, cours, datecours, heurecours;

	public PAV(String nom, String prenom, String voiture, String cours, String datecours, String heurecours) {
		 
		this.nom = nom;
		this.prenom = prenom;
		this.voiture = voiture;
		this.cours = cours;
		this.datecours = datecours;
		this.heurecours = heurecours;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVoiture() {
		return voiture;
	}

	public void setVoiture(String voiture) {
		this.voiture = voiture;
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}

	public String getDatecours() {
		return datecours;
	}

	public void setDatecours(String datecours) {
		this.datecours = datecours;
	}

	public String getHeurecours() {
		return heurecours;
	}

	public void setHeurecours(String heurecours) {
		this.heurecours = heurecours;
	} 
	
	
}

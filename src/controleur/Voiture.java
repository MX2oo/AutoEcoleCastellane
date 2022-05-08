package controleur;

public class Voiture {
	private int idvoiture ; 
	private String designation, constructeur; 
	private int nbplaces ;
	public Voiture(int idvoiture, String designation, String constructeur, int nbplaces) {
		 
		this.idvoiture = idvoiture;
		this.designation = designation;
		this.constructeur = constructeur;
		this.nbplaces = nbplaces;
	} 
	
	public Voiture(  String designation, String constructeur, int nbplaces) {
		 
		this.idvoiture = 0;
		this.designation = designation;
		this.constructeur = constructeur;
		this.nbplaces = nbplaces;
	}

	public int getIdvoiture() {
		return idvoiture;
	}

	public void setIdvoiture(int idvoiture) {
		this.idvoiture = idvoiture;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public int getNbplaces() {
		return nbplaces;
	}

	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	} 
	
	
}

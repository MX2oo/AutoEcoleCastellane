package controleur;

public class Candidat {
	private int idcandidat ; 
	private String nom, prenom, adresse; 
	private int forfait; 
	private String bip;
	
	public Candidat(int idcandidat, String nom, String prenom, String adresse, int forfait, String bip) {
		this.idcandidat = idcandidat;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.forfait = forfait;
		this.bip = bip;
	} 
	public Candidat( String nom, String prenom, String adresse, int forfait, String bip) {
		this.idcandidat = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.forfait = forfait;
		this.bip = bip;
	}
	
	public int getIdcandidat() {
		return idcandidat;
	}
	public void setIdcandidat(int idcandidat) {
		this.idcandidat = idcandidat;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getForfait() {
		return forfait;
	}
	public void setForfait(int forfait) {
		this.forfait = forfait;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	} 
	
	
}

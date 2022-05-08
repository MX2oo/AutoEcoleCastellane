package controleur;

public class Cours {
	private int idcours; 
	private String designation; 
	private String datecours, heurecours; 
	private int idcandidat1, idcandidat2, idvoiture ;
	
	public Cours(int idvol, String designation, String datecours, String heurecours, int idcandidat1, int idcandidat2,
			int idvoiture) {
		
		this.idcours = idvol;
		this.designation = designation;
		this.datecours = datecours;
		this.heurecours = heurecours;
		this.idcandidat1 = idcandidat1;
		this.idcandidat2 = idcandidat2;
		this.idvoiture = idvoiture;
	} 
	
	public Cours(  String designation, String datecours, String heurecours, int idcandidat1, int idcandidat2,
			int idvoiture) {
		
		this.idcours = 0;
		this.designation = designation;
		this.datecours = datecours;
		this.heurecours = heurecours;
		this.idcandidat1 = idcandidat1;
		this.idcandidat2 = idcandidat2;
		this.idvoiture = idvoiture;
	}

	public int getIdcours() {
		return idcours;
	}

	public void setIdcours(int idcours) {
		this.idcours = idcours;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public int getIdcandidat1() {
		return idcandidat1;
	}

	public void setIdcandidat1(int idcandidat1) {
		this.idcandidat1 = idcandidat1;
	}

	public int getIdcandidat2() {
		return idcandidat2;
	}

	public void setIdcandidat2(int idcandidat2) {
		this.idcandidat2 = idcandidat2;
	}

	public int getIdvoiture() {
		return idvoiture;
	}

	public void setIdvoiture(int idvoiture) {
		this.idvoiture = idvoiture;
	} 
	
	
}

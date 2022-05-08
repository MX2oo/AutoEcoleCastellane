package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Voiture;
import controleur.PAV;
import controleur.Voiture;
import controleur.Candidat;
import controleur.User;
import controleur.Cours;

public class Modele {

	private static Bdd uneBdd=new Bdd("localhost","auto_ecole_castellane","root","");

	
	public static int countCandidats() {
		int nbcandidats=0;
		String requete ="select count(*) as nb from candidat ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbcandidats = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbcandidats;
	}
	
	public static int countVoitures() {
		int nbvoitures=0;
		String requete ="select count(*) as nb from voiture ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbvoitures = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbvoitures;
	}
	
	public static int countCours() {
		int nbcours=0;
		String requete ="select count(*) as nb from cours ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbcours = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbcours;
	}
	
	public static void insertCandidat (Candidat unCandidat)
	{
		String requete ="insert into candidat values (null, '"
				+ unCandidat.getNom()+"','" + unCandidat.getPrenom()+"','"
				+ unCandidat.getAdresse()+"','" + unCandidat.getForfait()+"','"
				+ unCandidat.getBip()+"');"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static void updateCandidat (Candidat unCandidat)
	{
		String requete ="update candidat set nom = '"
				+ unCandidat.getNom()+"', prenom='" + unCandidat.getPrenom()+"',adresse='"
				+ unCandidat.getAdresse()+"',forfait='" + unCandidat.getForfait()+"',bip='"
				+ unCandidat.getBip()+"'  where idcandidat="+unCandidat.getIdcandidat()+";"; 
		 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static ArrayList<Candidat> selectAllCandidats ()
	{
		ArrayList<Candidat> lesCandidats = new ArrayList<Candidat>(); 
		String requete = "select * from candidat ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);

			while (desResultats.next())
			{
				Candidat unCandidat = new Candidat (
						desResultats.getInt("idcandidat"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"),
						desResultats.getString("adresse"), 
						desResultats.getInt("forfait"), 
						desResultats.getString("bip")
						);

				lesCandidats.add(unCandidat); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesCandidats; 
	}
	
	public static Candidat selectWhereCandidat (int idcandidat)
	{
		Candidat unCandidat = null;  
		String requete = "select * from candidat where idcandidat =" +idcandidat+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
 
			if (unResultat.next()) 
			{
				 unCandidat = new Candidat (
						 unResultat.getInt("idcandidat"), 
						 unResultat.getString("nom"), 
						 unResultat.getString("prenom"),
						 unResultat.getString("adresse"), 
						 unResultat.getInt("forfait"), 
						 unResultat.getString("bip")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unCandidat; 
	}
	
	public static void insertVoiture (Voiture uneVoiture)
	{
		String requete ="insert into voiture values (null, '"
				+ uneVoiture.getDesignation()+"','" + uneVoiture.getConstructeur()+"','"
				+ uneVoiture.getNbplaces()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static Voiture selectWhereVoiture (int idvoiture) {
		Voiture uneVoiture = null;
		String requete = "SELECT * FROM voiture WHERE idvoiture = "+idvoiture+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				uneVoiture = new Voiture (
						unResultat.getInt("idvoiture"),
						unResultat.getString("designation"),
						unResultat.getString("constructeur"),
						unResultat.getInt("nbplaces")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return uneVoiture;
	}
	
	public static Voiture selectWhereVoiture (String designation, String constructeur) {
		Voiture uneVoiture = null;
		String requete = "SELECT * FROM voiture WHERE designation ='"+designation +"' and constructeur='"+constructeur+"';";
			try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				uneVoiture = new Voiture (
						unResultat.getInt("idvoiture"),
						unResultat.getString("designation"),
						unResultat.getString("constructeur"),
						unResultat.getInt("nbplaces")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return uneVoiture;
	}

	public static void updateVoiture (Voiture uneVoiture) {
		String requete = "UPDATE voiture SET designation = '"
				+ uneVoiture.getDesignation() + "', constructeur = '" 
				+ uneVoiture.getConstructeur() + "', nbplaces = '"
				+ uneVoiture.getNbplaces() + "' WHERE idvoiture = "+uneVoiture.getIdvoiture()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	public static ArrayList<Voiture> selectAllVoitures ()
	{
		ArrayList<Voiture> lesVoitures = new ArrayList<Voiture>(); 
		String requete = "select * from voiture ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
	 
			while (desResultats.next())
			{
				Voiture uneVoiture = new Voiture (
						desResultats.getInt("idvoiture"), 
						desResultats.getString("designation"), 
						desResultats.getString("constructeur"),
						desResultats.getInt("nbplaces")
						);

				lesVoitures.add(uneVoiture); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesVoitures; 
	}
	
	
	public static Cours selectWhereCours(String designation, String datecours, String heurecours) {
		Cours unCours = null;
		String requete = "SELECT * FROM cours WHERE "
				+ " designation = '"+designation+"' and datecours = '"+datecours+"' and heurecours = '"+heurecours+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unCours = new Cours (
						unResultat.getInt("idcours"),
						unResultat.getString("designation"),
						unResultat.getString("datecours"),
						unResultat.getString("heurecours"),
						unResultat.getInt("idcandidat1"),
						unResultat.getInt("idcandidat2"),
						unResultat.getInt("idvoiture")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unCours;
	}

	
	public static void insertCours (Cours unCours)
	{
		String requete ="insert into cours values (null, '"
				+ unCours.getDesignation()+"','" + unCours.getDatecours()+"','"
				+ unCours.getHeurecours()+"','" + unCours.getIdcandidat1()+"','"
				+ unCours.getIdcandidat2()+"','" + unCours.getIdvoiture()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static void updateCours (Cours unCours) {
		String requete = "UPDATE cours SET designation = '"
				+ unCours.getDesignation() + "', datecours = '" 
				+ unCours.getDatecours() + "', heurecours = '"
				+ unCours.getHeurecours() + "', idcandidat1 = '"
				+ unCours.getIdcandidat1() + "', idcandidat2 = '"
				+ unCours.getIdcandidat2() + "', idvoiture = '"
				+ unCours.getIdvoiture() + "' WHERE idvoiture = "+unCours.getIdcours()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	public static ArrayList<Cours> selectAllCours ()
	{
		ArrayList<Cours> lesCours = new ArrayList<Cours>(); 
		String requete = "select * from cours ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
 
			while (desResultats.next())
			{
				Cours unCours = new Cours (
						desResultats.getInt("idcours"), 
						desResultats.getString("designation"), 
						desResultats.getString("datecours"),
						desResultats.getString("heurecours"),
						desResultats.getInt("idcandidat1"), 
						desResultats.getInt("idcandidat2"), 
						desResultats.getInt("idvoiture") 
						);

				lesCours.add(unCours); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesCours; 
	}
	public static void deleteCandidat (int idcandidat)
	{
		String requete ="delete from candidat where idcandidat = " + idcandidat; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}
	public static void deleteVoiture (int idvoiture)
	{
		String requete ="delete from voiture where idvoiture = " + idvoiture; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}
	public static void deleteCours (int idcours)
	{
		String requete ="delete from cours where idcours = " + idcours; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
	}

	public static ArrayList<PAV> selectAllPAV ()
	{
		ArrayList<PAV> lesPAVs = new ArrayList<PAV>(); 
		String requete = "select * from pav;"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);

			while (desResultats.next()) 
			{
				PAV unPAV = new PAV (
						desResultats.getString("nom"),
						desResultats.getString("prenom"),
						desResultats.getString("voiture"),
						desResultats.getString("cours"),
						desResultats.getString("datecours"), 
						desResultats.getString("heurecours") 
						);

				lesPAVs.add(unPAV); 
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesPAVs; 
	}
	
	/******************** Gestion des users **************/
	public static User selectWhereUser (String email, String mdp)  {
		User unUser = null;  
		String requete = "select * from user where email='"+email
				+"'   and  mdp ='" + mdp + "' ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);

			if (unResultat.next()) 
			{
				 unUser = new User (
					unResultat.getInt("iduser"), unResultat.getString("nom"), 
					unResultat.getString("prenom"),unResultat.getString("email"), 
					unResultat.getString("mdp"), unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unUser; 
	}

	public static Candidat selectWhereCandidat(String nom, String prenom, String bip) {
		
		Candidat unCandidat = null;  
		String requete = "select * from candidat where "
				+ " nom = '"+nom+"' and prenom ='" + prenom 
				+ "'  and bip ='"+bip + "'; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un pilote : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				 unCandidat = new Candidat (
						 unResultat.getInt("idcandidat"), 
						 unResultat.getString("nom"), 
						 unResultat.getString("prenom"),
						 unResultat.getString("adresse"), 
						 unResultat.getInt("forfait"), 
						 unResultat.getString("bip")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unCandidat;
	}

	public static ArrayList<Candidat> selectLikeCandidats(String mot) {
		
		ArrayList<Candidat> lesCandidats = new ArrayList<Candidat>(); 
		String requete = "select * from candidat where "
				+ " nom like '%"+mot+"%' or "
				+ " prenom like '%"+mot+"%' or "
				+ " adresse like '%"+mot+"%' or "
				+ " bip like '%"+mot+"%' ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
 
			while (desResultats.next()) 
			{
				Candidat unCandidat = new Candidat (
						desResultats.getInt("idcandidat"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"),
						desResultats.getString("adresse"), 
						desResultats.getInt("forfait"), 
						desResultats.getString("bip")
						);

				lesCandidats.add(unCandidat); 
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesCandidats; 
		
	}
	
}//fin de la classe













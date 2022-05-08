package controleur;


import modele.Modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class AutoEcole {
	private static VueConnexion uneConnexion ; 
	private static VueGenerale uneVueGenerale ; 
	
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneConnexion.setVisible(action);
	}
	public static void rendreVisibleVueGenerale (boolean action)
	{
		uneVueGenerale.setVisible(action);
	}
	
	public static void instancierVueGenerale (User unUser)
	{
		uneVueGenerale = new VueGenerale(unUser); //construire la vue
	}
	
	public static void fermerVueGenerale ()
	{
		uneVueGenerale.dispose(); //detruire la vue
	}
	public static void main(String[] args) {
		uneConnexion = new VueConnexion(); 
	}
 
	/********** Gestion des Users ******************/
	public static User selectWhereUser (String email, String mdp)
	{
	
		User unUser = Modele.selectWhereUser(email, mdp); 
		
		return unUser; 
	}
}













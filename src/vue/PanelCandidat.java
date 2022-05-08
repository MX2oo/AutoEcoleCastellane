package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Candidat;
import controleur.Tableau;

import modele.Modele;

public class PanelCandidat extends PanelDeBase implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	private JPanel panelTable = new JPanel(); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtAdresse = new JTextField();
	private JTextField txtForfait = new JTextField();
	private JTextField txtBip= new JTextField();
	
	private JTable uneTable = null; 
	
	private static Tableau unTableau  = null ; 
	
	//zone de recherche - par requete like 
	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher"); 
	
	public PanelCandidat() {
		
		super(Color.gray);
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom Candidat :")); 
		this.panelForm.add(this.txtNom); 
		
		this.panelForm.add(new JLabel("Prénom Candidat :")); 
		this.panelForm.add(this.txtPrenom); 
		this.panelForm.add(new JLabel("Adresse :")); 
		this.panelForm.add(this.txtAdresse);
		
		this.panelForm.add(new JLabel("Forfait :")); 
		this.panelForm.add(this.txtForfait);
		this.panelForm.add(new JLabel("Age Candidat :")); 
		this.panelForm.add(this.txtBip);
		
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		
		this.panelForm.setBackground(Color.gray);
		
		this.panelForm.setBounds(20, 20, 300, 320);
		this.add(this.panelForm);
		
		//contruction du panel Table 
		this.panelTable.setBounds(340, 20, 380, 320);
		this.panelTable.setBackground(Color.gray);
		this.panelTable.setLayout(null);
		String entetes[] = {"ID Candidat","Nom","Prénom","Adresse","Age","Forfait"};
		Object donnees [][] = this.getLesDonnees (""); 
		unTableau = new Tableau (entetes, donnees);
				
		this.uneTable = new JTable(unTableau); 
		JScrollPane uneScroll = new JScrollPane(this.uneTable); 
		uneScroll.setBounds(0, 60, 380, 200);

		this.panelTable.add(uneScroll); 
		//placement de la zone de recherche 
		this.txtMot.setBounds(50, 20, 120, 20);
		this.panelTable.add(this.txtMot); 
		this.btRechercher.setBounds(190, 20, 120, 20);
		this.panelTable.add(this.btRechercher); 
		
		this.add(this.panelTable); 
		//gestion de la JTABLE avec MouseListener
		this.uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int nbclic = e.getClickCount(); 
				if (nbclic==2)
				{
					int numLigne = uneTable.getSelectedRow(); 
					int retour = JOptionPane.showConfirmDialog(null, 
							"Voulez-vous supprimer ce candidat ?", "Suppression Candidat",
							JOptionPane.YES_NO_OPTION); 
					if (retour == 0)
					{
						//suppression du candidat
						int idcandidat = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteCandidat(idcandidat);
						
						//actualiser l'affichage 
						unTableau.supprimerLigne(numLigne);
					}
				}else if (nbclic==1)
				{
					int numLigne = uneTable.getSelectedRow(); 
					String nom = unTableau.getValueAt(numLigne,1).toString(); 
					txtNom.setText(nom);
					String prenom = unTableau.getValueAt(numLigne,2).toString(); 
					txtPrenom.setText(prenom);
					String adresse = unTableau.getValueAt(numLigne,3).toString(); 
					txtAdresse.setText(adresse);
					String forfait = unTableau.getValueAt(numLigne,4).toString(); 
					txtForfait.setText(forfait);
					String bip = unTableau.getValueAt(numLigne,5).toString(); 
					txtBip.setText(bip);
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		
		//rendre les boutons ecoutables 
		this.btEnregistrer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btRechercher.addActionListener(this);
	}

	public Object [][]  getLesDonnees (String mot) {
		ArrayList<Candidat> lesCandidats = null; 
		if (mot.equals("")) {
			lesCandidats = Modele.selectAllCandidats(); 
		} else {
			lesCandidats = Modele.selectLikeCandidats(mot);
		}
		Object [][] matrice = new Object[lesCandidats.size()][6];
		int i =0; 
		for (Candidat unCandidat : lesCandidats)
		{
			matrice[i][0] = unCandidat.getIdcandidat();
			matrice[i][1] = unCandidat.getNom();
			matrice[i][2] = unCandidat.getPrenom();
			matrice[i][3] = unCandidat.getAdresse();
			matrice[i][4] = unCandidat.getBip();
			matrice[i][5] = unCandidat.getForfait();
			i++; 
		}
		return matrice ; 
	}
	
	public void viderChamps()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtForfait.setText("");
		this.txtBip.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	
	public Candidat saisirCandidat ()
	{
		Candidat unCandidat = null; 
		String nom = this.txtNom.getText(); 
		String prenom = this.txtPrenom.getText(); 
		String adresse = this.txtAdresse.getText(); 
		String bip = this.txtBip.getText(); 
		int Forfait = 0;
		try{
			Forfait = Integer.parseInt(this.txtForfait.getText()); 
		}
		catch(NumberFormatException exp)
		{
			JOptionPane.showMessageDialog(this, 
					"Attention au format du nombre");
			this.txtForfait.setBackground(Color.red);
		}
		if(nom.equals("")) {
			this.txtNom.setBackground(Color.red);
		}else {
			this.txtNom.setBackground(Color.white);
		}
		if(prenom.equals("")) {
			this.txtPrenom.setBackground(Color.red);
		}else {
			this.txtPrenom.setBackground(Color.white);
		}
		if(adresse.equals("")) {
			this.txtAdresse.setBackground(Color.red);
		}else {
			this.txtAdresse.setBackground(Color.white);
		}
		if(bip.equals("")) {
			this.txtBip.setBackground(Color.red);
		}else {
			this.txtBip.setBackground(Color.white);
		}
		if( Forfait > 0)
		{
			this.txtForfait.setBackground(Color.white);
		}
		if ( ! nom.equals("") && ! prenom.equals("") && ! adresse.equals("")
				&& ! bip.equals("") && Forfait > 0)
		{
			 unCandidat = new Candidat (nom, prenom, adresse, Forfait, bip);
		}else {
			return null; 
		}
		return unCandidat ; 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}else if( e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")){
			
			{
				Candidat unCandidat = this.saisirCandidat(); 
				Modele.insertCandidat(unCandidat);
				
	 
				unCandidat = Modele.selectWhereCandidat(unCandidat.getNom(), 
						unCandidat.getPrenom(), unCandidat.getBip()); 
				
	 
				Object ligne[] = {unCandidat.getIdcandidat(), unCandidat.getNom(), 
						unCandidat.getPrenom(), unCandidat.getAdresse(), 
						unCandidat.getBip(), unCandidat.getForfait()}; 
				unTableau.ajouterLigne(ligne);
				
				JOptionPane.showMessageDialog(this, "Insertion Réussie");
				this.viderChamps();
			}
			
		}
		else if( e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier")){
		
			Candidat unCandidat = this.saisirCandidat(); 
			
			JOptionPane.showMessageDialog(this, "Modification effectuee");
			
			int numLigne = this.uneTable.getSelectedRow(); 
			 
			int idcandidat = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString()); 
			 
			unCandidat.setIdcandidat(idcandidat);
			Modele.updateCandidat(unCandidat);
			
			Object ligne[] = {unCandidat.getIdcandidat(), unCandidat.getNom(), 
					unCandidat.getPrenom(), unCandidat.getAdresse(), 
					unCandidat.getBip(), unCandidat.getForfait()}; 
			unTableau.modifierLigne(numLigne, ligne); 
			this.btEnregistrer.setText("Enregistrer");
			this.viderChamps();
		}
		else if (e.getSource() == this.btRechercher)
		{
			String mot = this.txtMot.getText(); 
			

			Object matrice [][] = this.getLesDonnees(mot); 
			
			unTableau.setDonnees (matrice); 
		}
		
	}

}










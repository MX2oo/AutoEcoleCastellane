package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controleur.Voiture;
import controleur.Candidat;
import controleur.Tableau;
import controleur.Cours;
import modele.Modele;

public class PanelCours extends PanelDeBase implements ActionListener {

	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtDesignation = new JTextField();
	private JTextField txtDateCours = new JTextField();
	private JTextField txtHeureCours = new JTextField();
	
	private JComboBox<String> cbxIdcandidat1 = new JComboBox<String>();
	private JComboBox<String> cbxIdcandidat2 = new JComboBox<String>();
	private JComboBox<String> cbxIdVoiture = new JComboBox<String>();

	private JTable uneTable = null;

	private static Tableau unTableau = null;

	public PanelCours() {
		super(Color.gray);

		this.panelForm.setLayout(new GridLayout(7, 2));

		this.panelForm.add(new JLabel("Désignation Cours : "));
		this.panelForm.add(this.txtDesignation);

		this.panelForm.add(new JLabel("Date Cours (AAAA-MM-JJ) : "));
		this.panelForm.add(this.txtDateCours);

		this.panelForm.add(new JLabel("Heure Cours (HH:MM) : "));
		this.panelForm.add(this.txtHeureCours);

		this.panelForm.add(new JLabel("ID Candidat 1 : "));
		this.panelForm.add(this.cbxIdcandidat1);

		this.panelForm.add(new JLabel("ID Candidat 2 : "));
		this.panelForm.add(this.cbxIdcandidat2);

		this.panelForm.add(new JLabel("ID Voiture : "));
		this.panelForm.add(this.cbxIdVoiture);

		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);

		// this.panelForm.setBackground(Color.gray);

		this.panelForm.setBounds(40, 20, 300, 300);
		this.add(this.panelForm);

		// Construction du panel Table
		this.panelTable.setBounds(345, 20, 400, 320);
		this.panelTable.setBackground(Color.gray);
		this.panelTable.setLayout(null);
		String entetes[] = { "ID", "Désignation", "Date Cours", "Heure Cours", "ID Candidat 1", "ID Candidat 2", "ID Voiture" };
		Object donnees[][] = this.getLesDonnees();
		unTableau = new Tableau(entetes, donnees); // Appel du constructeur Tableau
		this.uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(10, 10, 380, 280);
		this.panelTable.add(uneScroll);
		
		this.add(this.panelTable);
		
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
				if (nbclic == 2) {
					int numLigne = uneTable.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce cours ?", "Suppression d'un Cours", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idcours = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteCours(idcours);
						unTableau.supprimerLigne(numLigne);
						viderChamps();
					}
				} else if (nbclic == 1) {
					int numLigne = uneTable.getSelectedRow();
					
					String designation = unTableau.getValueAt(numLigne, 1).toString();
					txtDesignation.setText(designation);
					
					String datecours = unTableau.getValueAt(numLigne, 2).toString();
					txtDateCours.setText(datecours);
					
					String heurecours = unTableau.getValueAt(numLigne, 3).toString();
					txtHeureCours.setText(heurecours);
					
					String idcandidat1 = unTableau.getValueAt(numLigne, 4).toString();
					cbxIdcandidat1.setSelectedItem(idcandidat1);
					
					String idcandidat2 = unTableau.getValueAt(numLigne, 5).toString();
					cbxIdcandidat2.setSelectedItem(idcandidat2);
					
					String idvoiture = unTableau.getValueAt(numLigne, 6).toString();
					cbxIdVoiture.setSelectedItem(idvoiture);
					
					btEnregistrer.setText("Modifier");
				}
			}
		});
		
		// Remplir les CBX ID
		this.remplirCBX();

		// Rendre les boutons écoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	
	public void remplirCBX () {
		ArrayList<Candidat> lesCandidats = Modele.selectAllCandidats();
		for (Candidat unCandidat : lesCandidats) {
			this.cbxIdcandidat1.addItem(unCandidat.getIdcandidat()+"-"+unCandidat.getNom());
			this.cbxIdcandidat2.addItem(unCandidat.getIdcandidat()+"-"+unCandidat.getNom());
		}
		ArrayList<Voiture> lesVoitures = Modele.selectAllVoitures();
		for (Voiture uneVoiture : lesVoitures) {
			this.cbxIdVoiture.addItem(uneVoiture.getIdvoiture()+"-"+uneVoiture.getDesignation());
		}
	}

	public Object[][] getLesDonnees() {
		ArrayList<Cours> lesCours = Modele.selectAllCours();
		Object[][] matrice = new Object[lesCours.size()][7];
		int i = 0;
		for (Cours unCours : lesCours) {
			matrice[i][0] = unCours.getIdcours();
			matrice[i][1] = unCours.getDesignation();
			matrice[i][2] = unCours.getDatecours();
			matrice[i][3] = unCours.getHeurecours();
			matrice[i][4] = unCours.getIdcandidat1();
			matrice[i][5] = unCours.getIdcandidat2();
			matrice[i][6] = unCours.getIdvoiture();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps () {
		this.txtDesignation.setText("");
		this.txtDateCours.setText("");
		this.txtHeureCours.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	
	public Cours saisirCours () {
		Cours unCours = null;
		
		String designation = this.txtDesignation.getText();
		String datecours = this.txtDateCours.getText();
		String heurecours = this.txtHeureCours.getText();
		
		String tab[] = this.cbxIdcandidat1.getSelectedItem().toString().split("-");
		int idcandidat1 = Integer.parseInt(tab[0]);
		tab = this.cbxIdcandidat2.getSelectedItem().toString().split("-");
		int idcandidat2 = Integer.parseInt(tab[0]);
		tab = this.cbxIdVoiture.getSelectedItem().toString().split("-");
		int idvoiture = Integer.parseInt(tab[0]);

		if (designation.equals("")) {
			this.txtDesignation.setBackground(Color.red);
		} else {
			this.txtDesignation.setBackground(Color.white);
		}

		if (datecours.equals("")) {
			this.txtDateCours.setBackground(Color.red);
		} else {
			this.txtDateCours.setBackground(Color.white);
		}

		if (heurecours.equals("")) {
			this.txtHeureCours.setBackground(Color.red);
		} else {
			this.txtHeureCours.setBackground(Color.white);
		}

		if (!designation.equals("") && !datecours.equals("") && !heurecours.equals("")) {
			unCours = new Cours(designation, datecours, heurecours, idcandidat1, idcandidat2, idvoiture);
		} else {
			return null;
		}
		return unCours;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equalsIgnoreCase("Enregistrer")) {
			Cours unCours = this.saisirCours();
			Modele.insertCours(unCours);
			
			// Récupérer l'ID auto_increment de la BDD
			unCours = Modele.selectWhereCours(unCours.getDesignation(), unCours.getDatecours(), unCours.getHeurecours());

			// Mettre à jour l'affichage
			Object ligne[] = { unCours.getIdcours(), unCours.getDesignation(), unCours.getDatecours(), unCours.getHeurecours(),
					unCours.getIdcandidat1(), unCours.getIdcandidat2(), unCours.getIdvoiture() };
			unTableau.ajouterLigne(ligne);

			JOptionPane.showMessageDialog(this, "Insertion du cours réussi !");
			unTableau.fireTableDataChanged();
			this.viderChamps();
		} else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equalsIgnoreCase("Modifier")) {
			Cours unCours = this.saisirCours();
			int numLigne = this.uneTable.getSelectedRow();
			int idcours = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
			unCours.setIdcours(idcours);
			Modele.updateCours(unCours);
			JOptionPane.showMessageDialog(this, "Modification effectuée !");
			Object ligne[] = { unCours.getIdcours(), unCours.getDesignation(), unCours.getDatecours(), unCours.getHeurecours(),
					unCours.getIdcandidat1(), unCours.getIdcandidat2(), unCours.getIdvoiture() };
			unTableau.modifierLigne(numLigne, ligne);
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}
	}

}

package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.AutoEcole;
import controleur.User;

public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btQuitter = new JButton("Déconnexion"); 
	private JButton btProfil = new JButton("Mon Profil"); 
	private JButton btCandidats = new JButton("Gestion Candidats"); 
	private JButton btVoitures = new JButton("Gestion Voitures"); 
	private JButton btCours = new JButton("Gestion Cours");
	private JButton btStats= new JButton("Statistiques"); 
	private JButton btBord = new JButton("Tableau de bord");
	
	/********************* Les Panels ********************/
	private JPanel panelMenu = new JPanel(); 
	private JPanel panelProfil = new JPanel(); 
	private static PanelCandidat unPanelCandidat= new PanelCandidat(); 
	private static PanelVoiture unPanelVoiture= new PanelVoiture();
	private static PanelCours unPanelCours= new PanelCours();
	private static PanelStats unPanelStats= new PanelStats();
	private static PanelBord unPanelBord= new PanelBord();
	
	public VueGenerale(User unUser)
	{
		this.setTitle("Auto Ecole Castellane Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.gray);
		this.setBounds(300, 200, 900, 500);
		this.setLayout(null);
		
		//construction du panel menu 
		this.panelMenu.setLayout(new GridLayout(1,7));
		this.panelMenu.setBounds(20, 10, 860, 40);
		this.panelMenu.setBackground(Color.gray);
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btCandidats);
		this.panelMenu.add(this.btVoitures);
		this.panelMenu.add(this.btCours);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btBord);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu); 
		
		//construction du panel Profil 
		this.panelProfil.setLayout(new GridLayout(4, 1));
		this.panelProfil.setBounds(250, 100, 400, 300);
		this.panelProfil.setBackground(Color.gray);
		this.panelProfil.setVisible(false);
		this.panelProfil.add(new JLabel("Nom de l'user : " +unUser.getNom()));
		this.panelProfil.add(new JLabel("Prénom de l'user : " +unUser.getPrenom()));
		this.panelProfil.add(new JLabel("Email de l'user : " +unUser.getEmail()));
		this.panelProfil.add(new JLabel("Rôle de l'user : " +unUser.getRole()));
		
		this.add(this.panelProfil);
	
		this.add(unPanelCandidat); 
		this.add(unPanelVoiture); 
		this.add(unPanelCours);
		this.add(unPanelStats);
		this.add(unPanelBord); 
		
		//rendre les boutons cliquables 
		this.btQuitter.addActionListener(this); 
		this.btCandidats.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btVoitures.addActionListener(this);
		this.btCours.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btBord.addActionListener(this);
		
		this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter)
		{
			AutoEcole.fermerVueGenerale();
			AutoEcole.rendreVisibleVueConnexion(true);
		}
		else if (e.getSource() == this.btProfil)
		{
			this.panelProfil.setVisible(true);
			unPanelCandidat.setVisible(false);
			unPanelVoiture.setVisible(false);
			unPanelCours.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		}
		else if (e.getSource() == this.btCandidats)
		{
			this.panelProfil.setVisible(false);
			unPanelCandidat.setVisible(true);
			unPanelVoiture.setVisible(false);
			unPanelCours.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		}
		else if (e.getSource() == this.btVoitures)
		{
			this.panelProfil.setVisible(false);
			unPanelCandidat.setVisible(false);
			unPanelVoiture.setVisible(true);
			unPanelCours.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		}
		else if (e.getSource() == this.btCours)
		{
			this.panelProfil.setVisible(false);
			unPanelCandidat.setVisible(false);
			unPanelVoiture.setVisible(false);
			unPanelCours.setVisible(true);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		}
		else if (e.getSource() == this.btStats)
		{
			this.panelProfil.setVisible(false);
			unPanelCandidat.setVisible(false);
			unPanelVoiture.setVisible(false);
			unPanelCours.setVisible(false);
			unPanelStats.setVisible(true);
			unPanelBord.setVisible(false);
		}
		else if (e.getSource() == this.btBord)
		{
			this.panelProfil.setVisible(false);
			unPanelCandidat.setVisible(false);
			unPanelVoiture.setVisible(false);
			unPanelCours.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(true);
		}
		
	}
}













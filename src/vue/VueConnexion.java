package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import controleur.AutoEcole;
import controleur.User;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel panelConnexion = new JPanel();
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JTextField txtEmail = new JTextField("maxime@gmail.com");
	private JPasswordField txtMdp = new JPasswordField("123"); 
	
	public VueConnexion()
	{
		this.setTitle("Auto Ecole Castellane Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.panelConnexion.setBackground(Color.white);
		this.setBounds(300, 300, 600, 250);
		this.setLayout(null);
		
		//construction du panel connexion 
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.setBounds(300, 40, 260, 150);
		this.panelConnexion.setBackground(Color.white);
		this.panelConnexion.add(new JLabel("Email :")); 
		this.panelConnexion.add(this.txtEmail); 
		
		this.panelConnexion.add(new JLabel("MDP :")); 
		this.panelConnexion.add(this.txtMdp); 
		
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter);
		
		this.add(this.panelConnexion); 
		
		//installation du logo 
		ImageIcon leLogo = new ImageIcon("src/images/auto-ecole-a9-formation.jpg"); 
		JLabel lbLogo = new JLabel(leLogo); 
		lbLogo.setBounds(20, 40, 250, 150);
		this.add(lbLogo); 
		

		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		

		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			traitement(); 
		}
	}
	public void traitement () {
		String email = this.txtEmail.getText(); 
		String mdp = new String (this.txtMdp.getPassword()); 

		
		User unUser = AutoEcole.selectWhereUser(email, mdp);
		if(unUser == null) 
		{
			JOptionPane.showMessageDialog(this, 
					"Veuillez vérifier vos identifiants");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else
		{
			JOptionPane.showMessageDialog(this, 
			"Bienvenue M./MM " + unUser.getNom()
			+ "\n Vous avez le role : " +unUser.getRole());

			AutoEcole.instancierVueGenerale(unUser);
			
			//cacher la vue connexion. 
			AutoEcole.rendreVisibleVueConnexion(false);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			traitement (); 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}




















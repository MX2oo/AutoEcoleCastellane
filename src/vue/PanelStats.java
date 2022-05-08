package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.jdbc.log.Jdk14Logger;

import controleur.Tableau;
import modele.Modele;

public class PanelStats extends PanelDeBase
{
	private JPanel unPanel = new JPanel(); 
	
	public PanelStats() {
		super(Color.gray);
		
		this.unPanel.setBackground(Color.gray);
		this.unPanel.setBounds(50, 50, 400, 200);
		this.unPanel.setLayout(new GridLayout(3,1));
		
		int nbCandidats = Modele.countCandidats(); 
		int nbVoitures = Modele.countVoitures(); 
		int nbCours = Modele.countCours(); 
		String entetes [] = {"Nombre de Candidats", 
				"Nombre de Voitures", "Nombre de Cours" }; 
		Object matrice [][]= {{nbCandidats,nbVoitures,nbCours}}; 
		Tableau unTableau = new Tableau (entetes, matrice); 
		JTable uneTable = new JTable(unTableau);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); 
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); 
		for (int i =0; i < uneTable.getColumnCount() ; i++)
		{
			uneTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); 
		}
		
		JScrollPane uneScroll = new JScrollPane(uneTable); 
		uneScroll.setBounds(40, 40, 350, 100);
		this.unPanel.add(uneScroll);
		
		this.add(this.unPanel); 
	}
}







package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import controleur.PAV;
import controleur.Tableau;
import modele.Modele;

public class PanelBord extends PanelDeBase
{
	private JPanel unPanel = new JPanel(); 
	
	public PanelBord() {
		super(Color.gray);
	
		this.unPanel.setBackground(Color.gray);
		this.unPanel.setBounds(20, 50, 750, 200);
		this.unPanel.setLayout(null);
		
		String entetes [] = {"Nom", "Prénom", "Voiture", "Cours",
				"Date", "Heure" }; 
		Object matrice [][]= this.getDonnees (); 
		Tableau unTableau = new Tableau (entetes, matrice); 
		JTable uneTable = new JTable(unTableau);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); 
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); 
		for (int i =0; i < uneTable.getColumnCount() ; i++)
		{
			uneTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); 
		}
		
		JScrollPane uneScroll = new JScrollPane(uneTable); 
		uneScroll.setBounds(20, 40, 700, 300);
		this.unPanel.add(uneScroll);
		
		this.add(this.unPanel); 
	}
	
	public Object [][] getDonnees()
	{
		ArrayList<PAV> lesPAVs = Modele.selectAllPAV(); 
		Object matrice [][] = new Object[lesPAVs.size()][6]; 
		int i = 0; 
		for (PAV unPAV : lesPAVs)
		{
			matrice[i][0] = unPAV.getNom(); 
			matrice[i][1] = unPAV.getPrenom(); 
			matrice[i][2] = unPAV.getVoiture(); 
			matrice[i][3] = unPAV.getCours(); 
			matrice[i][4] = unPAV.getDatecours(); 
			matrice[i][5] = unPAV.getHeurecours();
			i++; 
		}
		return matrice; 
	}
	
}

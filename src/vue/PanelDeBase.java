package vue;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelDeBase extends JPanel
{
	public PanelDeBase(Color uneCouleur)
	{
		this.setBounds(100, 70, 750, 360);
		this.setLayout(null);
		this.setBackground(uneCouleur);
		this.setVisible(false);
	}
}

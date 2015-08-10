package fr.web_en_royans.lebarajus.POS.GUI;

import charva.awt.Color;
import charva.awt.FlowLayout;
import charvax.swing.JPanel;
import charvax.swing.JTextArea;

public class CurrentCustomerGUI extends JPanel{
	private GUIManager gui;
	private FlowLayout mgr;
	private int hauteur;
	private int largeur;
	public CurrentCustomerGUI(GUIManager gui_, int largeur_, int hauteur_) {
		  super();
		  gui = gui_;
		  this.hauteur = hauteur_;
		  this.largeur = largeur_;
	      mgr = new FlowLayout();
		  setForeground(Color.yellow);
	      setBackground(Color.green);
	      setSize(largeur, hauteur);
	      setLocation(0,0);
	      setLayout(mgr);
	      gui.getContentPane().add(this);
	}

}

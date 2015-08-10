package fr.web_en_royans.lebarajus.POS.GUI;

import charva.awt.Color;
import charva.awt.FlowLayout;
import charvax.swing.JPanel;
import charvax.swing.JTextField;
import charvax.swing.text.JTextComponent;

public class DailyListGUI extends JPanel{
	private GUIManager gui;
	private FlowLayout mgr;
	private int hauteur;
	private int largeur;
	private int x;
	
	public DailyListGUI(GUIManager gui_, int largeur_ , int hauteur_, int x_) {
		  super();  
		  gui = gui_;
		  this.hauteur = hauteur_;
		  this.largeur = largeur_;
		  x = x_;
	      mgr = new FlowLayout(); 
		  setForeground(Color.black);
		  setBackground(Color.cyan);
		  setSize(largeur,hauteur);
		  setLocation(x,0); 
		  setLayout(mgr);
		  JTextField tett = new JTextField("toto");
		  tett.setEnabled(false);
		  add(tett);
	      gui.getContentPane().add(this);
           
	}

}

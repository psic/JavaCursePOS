package fr.web_en_royans.lebarajus.POS.GUI;

import charva.awt.Color;
import charva.awt.FlowLayout;
import charva.awt.BorderLayout;
import charvax.swing.BoxLayout;
import charvax.swing.JPanel;
import charvax.swing.JLabel;
import charvax.swing.JTextArea;
import charvax.swing.JTable;
import charvax.swing.border.TitledBorder;
import charvax.swing.BorderFactory;
import charvax.swing.JTextField;
import charvax.swing.text.JTextComponent;
import charva.awt.Dimension;
import charva.awt.Point;

public class DailyListGUI extends JPanel{
	private GUIManager gui;
	private BoxLayout mgr;
	private int hauteur;
	private int largeur;
	private int x;
    JLabel total = new JLabel("0.0");
	public DailyListGUI(GUIManager gui_, int largeur_ , int hauteur_, int x_) {
        super();  
        gui = gui_;
        this.hauteur = hauteur_;
        this.largeur = largeur_;
        x = x_;
        // 	      mgr = new FlowLayout(); 
        setForeground(Color.black);
        setBackground(Color.cyan);

//         mgr = new BorderLayout();
        mgr = new BoxLayout(this,BoxLayout.Y_AXIS);

        TitledBorder border= new TitledBorder(BorderFactory.createLineBorder(Color.green,1),"Today");

        setBorder(border);
        JTable tableau = new JTable(gui.getEngine().getDaily());
        tableau.setPreferredScrollableViewportSize(new Dimension(largeur-2, hauteur-2 ));
        tableau.setBounds(new Point(x,2),new Dimension(largeur-2, hauteur -2));
        add(tableau,BorderLayout.CENTER);
        add (total,BorderLayout.SOUTH);
        add (total);
        setSize(largeur,hauteur);
        setLocation(x,0); 
        setLayout(mgr);
        mgr.doLayout(this);
        gui.getContentPane().add(this);
	}
	
	public void setTotal(String total_){
        total.setText(total_);
        mgr.doLayout(this);
	}

}

package fr.web_en_royans.lebarajus.POS.GUI;

import java.util.ArrayList;
import java.util.List;

import charva.awt.Color;
import charva.awt.Component;
import charva.awt.FlowLayout;
import charvax.swing.BoxLayout;
import charvax.swing.JLabel;
import charvax.swing.JPanel;
import charvax.swing.JTextField;

import fr.web_en_royans.lebarajus.POS.menu.MenuItem;
import fr.web_en_royans.lebarajus.POS.menu.Price;

public class ShortcutListGUI extends JPanel{
	private GUIManager gui;
	private BoxLayout mgr;
	private int hauteur;
	private int largeur;
	JLabel titre = new JLabel("Liste des Raccourcis caca");
	private List<JLabel> shortcutLabelList = new ArrayList<JLabel>();

	public ShortcutListGUI(GUIManager gui_, int largeur_, int hauteur_) {
		super();
		gui = gui_;
		this.hauteur = hauteur_;
		this.largeur = largeur_;
		setLayout(mgr);
        mgr = new BoxLayout(this,BoxLayout.Y_AXIS);
       // mgr.setAlignment(FlowLayout.CENTER);
        add(titre);
        setSize(largeur,hauteur);
        setLocation(0,hauteur+1);
        setForeground(Color.black);
        setBackground(Color.white);

        init();
       for(JLabel key:shortcutLabelList){
			add(key);
		}
        mgr.doLayout(this);
        gui.getContentPane().add(this);
	}

	private void init() {
		List<MenuItem> levelMenuItem = gui.getEngine().getMenu().getMenuTree().getChildren();
		for(MenuItem item:levelMenuItem){
			JLabel key = new JLabel(item.getDesc() + " " + item.getKey());
			shortcutLabelList.add(key);
			if(item.hasPrice()){
					for(Price price:item.getPrice()){
						JLabel priceLabel = new JLabel("└── " + price.getDesc()+ " " + price.getKey() + " : " + price.getPrice());
						shortcutLabelList.add(priceLabel);
					}
			}
		}
	}

	public void refresh() {
		refreshList();
		refreshGUI();

	}

	private void refreshList(){
		Component[] comp = getComponents();
		//for (int i =0; i<=getComponentCount(); i++){
		for(int i =0;i<comp.length;i++){
			remove(comp[i]);
		}

		add(titre);

		shortcutLabelList = new ArrayList<JLabel>();
		List<MenuItem> levelMenuItem = gui.getEngine().getMenu().getCurrentLevel().getChildren();
		// Get and print parent list
		MenuItem parent = gui.getEngine().getMenu().getCurrentLevel();
		List<MenuItem> parentList = new ArrayList<MenuItem>();
		while(parent !=null){
			parentList.add(parent);
			parent = parent.getParent();
		}
		int k=0;
		String prefix="";
		for (int i = parentList.size();i>0;i--){
			if(parentList.get(i-1).getDesc()!=null){
				k=0;
				for(int j=parentList.size();j-i>0;j--){
					prefix+="\t";
					k++;
				}
//				prefix += "└── ";
				JLabel parentLabel = new JLabel(prefix+ "└── " + parentList.get(i-1).getDesc());
				add (parentLabel);
			}
		}
		//JLabel parent = new JLabel(gui.getEngine().getMenu().getCurrentLevel().getDesc());
		//add(parent);
		for(MenuItem item:levelMenuItem){
			JLabel key = new JLabel(prefix+"\t└──"+item.getDesc() + " " + item.getKey());
			shortcutLabelList.add(key);
			add(key);
			if(item.hasPrice()){
				for(Price price:item.getPrice()){
					JLabel priceLabel = new JLabel(prefix+"\t└── " + price.getDesc()+ " " + price.getKey() + " : " + price.getPrice());
					shortcutLabelList.add(priceLabel);
					add(priceLabel);
				}
			}
		}
		mgr.doLayout(this);
	}

	private void refreshGUI(){

	}

}

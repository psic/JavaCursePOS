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
import charvax.swing.BorderFactory;
import charvax.swing.border.TitledBorder;
import charvax.swing.border.LineBorder;
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
        TitledBorder border= new TitledBorder(BorderFactory.createTitledBorder("Menu Shortcut"));
//             border.setTitleJustification(TitledBorder.LEFT_ALIGNMENT);
//     border.setTitlePosition(TitledBorder.TOP_ALIGNMENT);    
    setBorder(border);
    
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
		String prefix="";
		boolean prems=false;
		for (int i = parentList.size();i>0;i--){
			if(parentList.get(i-1).getDesc()!=null){
			   	JLabel parentLabel;
			   if(i == parentList.size()-1){
			   	 parentLabel = new JLabel( parentList.get(i-1).getDesc());
			   	 prems=true;
			   }
			   else{
		      	 if(i != parentList.size()-2){
					prefix+="\t";
					prems=true;
		      	 }
		      	 prems=false;
//				prefix += "└── ";
				 parentLabel = new JLabel(prefix+ "└── " + parentList.get(i-1).getDesc());
			   }
				add (parentLabel);
				if(parentList.get(i-1).hasPrice() && !parentList.get(i-1).hasChild() ){
					for(Price price:parentList.get(i-1).getPrice()){
						JLabel priceLabel = new JLabel(prefix+"\t└── " + price.getDesc()+ " " + price.getKey() + " : " + price.getPrice());
						shortcutLabelList.add(priceLabel);
						add(priceLabel);
					}
				}
			  }
		}
		//JLabel parent = new JLabel(gui.getEngine().getMenu().getCurrentLevel().getDesc());
		//add(parent);
		JLabel key;
		for(MenuItem item:levelMenuItem){
		   if(prems==true)
			key = new JLabel(prefix+"└── "+item.getDesc() + " " + item.getKey());
		 else
		 	 key = new JLabel(prefix+"\t└── "+item.getDesc() + " " + item.getKey());
		shortcutLabelList.add(key);
		add(key);
		}
		mgr.doLayout(this);
	}

	private void refreshGUI(){

	}
	
	public void reset(){
        shortcutLabelList = new ArrayList<JLabel>();
        Component[] comp = getComponents();
		//for (int i =0; i<=getComponentCount(); i++){
		for(int i =0;i<comp.length;i++){
			remove(comp[i]);
		}

		add(titre);
        init();
        for(JLabel key:shortcutLabelList){
			add(key);
		}
		mgr.doLayout(this);
//         refreshList();
	}

}

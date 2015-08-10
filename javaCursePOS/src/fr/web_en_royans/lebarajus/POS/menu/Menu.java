package fr.web_en_royans.lebarajus.POS.menu;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import fr.web_en_royans.lebarajus.POS.Engine;

public class Menu {
	   static org.jdom2.Document document;
	   static Element racine;
	   private MenuItem menu;
	   private MenuItem currentLevel;
	   private Engine engine;
	   
	public Menu(Engine engine_) throws MenuParserException {
		//On crée une instance de SAXBuilder
		
		menu=new MenuItem();
		engine = engine_;
		SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est terminé ;)
	         document = sxb.build(new File("/home/psic/workspace/javacursesPOS/menu.xml"));
	      }
	      catch(Exception e){throw new MenuParserException(e);}
	    //On initialise un nouvel élément racine avec l'élément racine du document.
	      racine = document.getRootElement();
	      CreateMenuItem(racine, menu);
	      currentLevel=menu;
	      print();

	}
	
	private void CreateMenuItem(Element racine, MenuItem menu) throws MenuParserException {
		
		
	   //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
	   List<Element> listMenuItem = racine.getChildren("menuItem");
	   //On crée un Iterator sur notre liste
	   Iterator<Element> i = listMenuItem.iterator();
	   while(i.hasNext())
	   {
	      //On recrée l'Element courant à chaque tour de boucle afin de
	      //pouvoir utiliser les méthodes propres aux Element comme :
	      //sélectionner un nœud fils, modifier du texte, etc...
	      Element courant = (Element)i.next();
	      //On affiche le nom de l’élément courant
	      //System.out.println(courant.getChild("nom").getText());
	      //System.out.println(courant.getChild("key").getText());
	      List<Element> listDesc = courant.getChildren("desc");
	      List<Element> listKey = courant.getChildren("key");
	      List<Element> listPrice = courant.getChildren("priceDesc");
	      String desc="";
	      if (listDesc.isEmpty()){
	    	  System.out.println("air");
	    	  //throw new MenuParserException();
	      }
	      else{
	    	  desc=((Element) listDesc.get(0)).getText();
	      }
	      
	      char key;
	      if (listKey.isEmpty()){
	    	  throw new MenuParserException();
	      }
	      else{
	    	  key =((Element) listKey.get(0)).getText().charAt(0);
	    	  key =  java.lang.Character.toLowerCase(key);
	      }
	      
	      List<Price> priceList=null;
	      if (!(listPrice.isEmpty())){
	    	  priceList = CreatePriceItem(((Element) listPrice.get(0)));
	      }
	      else{// Get the parent PriceList if not
	    	  if (menu.hasPrice())
	    		  priceList = menu.getPrice();	    	  
	      }
	      MenuItem current = new MenuItem(priceList,desc,key,menu);
	      menu.addChild(current);
	      CreateMenuItem(courant, current);
	   }
	}

	private List<Price> CreatePriceItem(Element element) throws MenuParserException {
		List<Element> listPrices = element.getChildren("category");
		List<Price> priceList=new ArrayList<Price>();
		for (Element  priceElement :listPrices ){
			  List<Element> listDesc = priceElement.getChildren("desc");
		      List<Element> listKey = priceElement.getChildren("key");
		      List<Element> listPrice = priceElement.getChildren("price");
		      String desc="";
		      if (listDesc.isEmpty()){
		    	  System.out.println("air");
		    	  //throw new MenuParserException();
		      }
		      else{
		    	  desc=((Element) listDesc.get(0)).getText();
		      }
		      
		      char key;
		      if (listKey.isEmpty()){
		    	  throw new MenuParserException();
		      }
		      else{
		    	  key =((Element) listKey.get(0)).getText().charAt(0);
		    	  key =  java.lang.Character.toLowerCase(key);
		      }
	      
		      float price;
		      if (!(listPrice.isEmpty())){
		    	  price = Float.parseFloat(((Element)listPrice.get(0)).getText());
		    	  Price pricetoAdd = new Price(price,  desc,  key);
		    	  priceList.add(pricetoAdd);
		      }
			
		}
		return priceList;
	}
	
	//Sers à rien ??
	public List<MenuItem> getLevelChildren(MenuItem level){
		Stack<MenuItem> itemLevel = new Stack<MenuItem>();
		itemLevel.push(level);
		while(!itemLevel.empty() ){
			MenuItem item = itemLevel.pop();
			if(item.hasChild()){
				List<MenuItem> currentLevelItem = item.getChildren();			
				for(MenuItem currentItem : currentLevelItem){
					if (currentItem == level){
					 return currentItem.getChildren();
					}
					else{
						itemLevel.push(currentItem);
					}
				}
			}
		}		
		return null;
	}
	
	public MenuItem getMenuTree(){
		return menu;
	}
	
	public MenuItem getCurrentLevel(){
		return currentLevel;
	}

	public void nextLevel(char c) {
		if(currentLevel.hasChild()){
			List<MenuItem> currentChild = currentLevel.getChildren();
			for(MenuItem item:currentChild){
				if(item.getKey() == c){
					currentLevel = item;
					engine.refreshCurrentLevel();
					return;
				}		
		    }
		}//else
		//	engine.refreshCurrentLevel();		
	}
	
	public void print() {
        menu.print("", true);
    }

   
}

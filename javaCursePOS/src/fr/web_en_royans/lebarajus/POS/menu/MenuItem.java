package fr.web_en_royans.lebarajus.POS.menu;

import java.util.ArrayList;
import java.util.List;

import charvax.swing.JLabel;


public class MenuItem  {
	
	private List<Price> price;
	private Price selectedPrice;
	private String desc;
	private String fullDesc;
	private String sep = " / ";
	private char key;
	private boolean isRoot;
	private MenuItem parent;
    private List<MenuItem> children;
	
   public MenuItem(List<Price> price_, String desc_, char key_, MenuItem parent_){
	   price = price_;
	   desc = desc_;
	   key = key_;
	   isRoot=false;
	   if (!parent_.isRoot())
            fullDesc = parent_.getFullDesc() + sep + desc;
        else 
            fullDesc = desc;
	   setParent(parent_);
       children = new ArrayList<MenuItem>();
	   
   }
    
	public MenuItem() {
		parent = null;
		isRoot=true;
		 children = new ArrayList<MenuItem>();
		 price = new ArrayList<Price>();
}
    public boolean isRoot(){return isRoot;}
    public String getFullDesc(){
        return fullDesc;
    }
	/**
	 * @return the price
	 */
	public List<Price> getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(List<Price> price) {
		this.price = price;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the key
	 */
	public char getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(char key) {
		this.key = key;
	}

	public void addChild(MenuItem current) {
		children.add(current);
		
	}
	
	public boolean hasChild(){
		if (children == null)return false;
	 if(children.size() == 0)
		 return false;
	 else return true;
	}

	/**
	 * @return the parent
	 */
	public MenuItem getParent() {
		return parent;
	}
	
	/**
	 * @return the Children
	 */
	public List<MenuItem> getChildren() {
		return children;
	}
	
	public char[] getChildrenKeys(){
		int i=0;
		int size = children.size();
		if (size > 0){
		char[] keys = new char[size];
			for(MenuItem item:children){
				keys[i] = item.getKey();
				i++;
			}	
			return keys;
		}
		return null;		
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(MenuItem parent) {
		this.parent = parent;
	}
	
	 void print(String prefix, boolean isTail) {
		 	String prices = "";
		 	if (price != null){
		 		for (Price oneprice : price){
		 			prices += "/  " + oneprice.getDesc() + " (" + oneprice.getKey() + ") :" + oneprice.getPrice() ; 
		 		}
		        System.out.println(prefix + (isTail ? "└── " : "├── ") + desc + " " + key +  prices + " -- " + fullDesc);
		 	}
		 	else{
		        System.out.println(prefix + (isTail ? "└── " : "├── ") + desc + " " + key + " -- " + fullDesc);
		 	}
		 
	        for (int i = 0; i < children.size() - 1; i++) {
	            children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
	        }
	        if (children.size() > 0) {
	            children.get(children.size() - 1).print(prefix + (isTail ?"    " : "│   "), true);
	        }
	    }

	public boolean hasPrice() {
		if (price==null) return false;
		return !price.isEmpty();
	}

	public char[] getPriceKeys() {
		int i=0;
		int size =  price.size();
		if (size > 0){
		char[] keys = new char[size];
			for(Price priceItem : price){
				keys[i] = priceItem.getKey();
				i++;
			}
			return keys;
		}
		return null;	
	}
	
	public void selectPrice(char c)
	{
        for(Price priceItem : price)
        {
            if (priceItem.getKey() == c)
                selectedPrice = priceItem;
        }
	}
	
	public Price getSelectedPrice(){
        return selectedPrice;
	}

}

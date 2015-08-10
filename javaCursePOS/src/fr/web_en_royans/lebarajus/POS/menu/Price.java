package fr.web_en_royans.lebarajus.POS.menu;

public class Price{
	private float price;
	private String desc;
	private char key;
	
	public Price (float price_, String desc_, char key_){
		price = price_;
		desc=desc_;
		key=key_;		
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
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

}

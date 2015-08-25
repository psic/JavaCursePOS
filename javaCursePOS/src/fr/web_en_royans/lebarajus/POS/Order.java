package fr.web_en_royans.lebarajus.POS;
import fr.web_en_royans.lebarajus.POS.menu.Price;

public class Order {
	private Price price;
	private String desc;
	private String descPrice;

	public Order(String desc_, Price price_){
	  price = price_;
	  descPrice = price_.getDesc();
	  desc = desc_;
	}
}

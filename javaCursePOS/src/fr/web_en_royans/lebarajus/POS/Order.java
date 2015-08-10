package fr.web_en_royans.lebarajus.POS;

public class Order {
	private Price price;
	private String desc;
	private String descPrice;

	public Order(String desc_; Price price_){
	  price = price_.getPrice();
	  descPrice = price_.getDesc();
	  desc = desc_;
	}
}

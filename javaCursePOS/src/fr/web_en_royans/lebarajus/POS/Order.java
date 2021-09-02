package fr.web_en_royans.lebarajus.POS;
import fr.web_en_royans.lebarajus.POS.menu.Price;

public class Order {
	private Price price;
	private String desc;
	private String descPrice;
	private int number;

	public Order(String desc_, Price price_, int number_){
	  price = price_;
	  descPrice = price_.getDesc();
	  desc = desc_;
	  number=number_;
	}
	
		public Order(String desc_, int price_, int number_){
// 	  price = price_;
// 	  descPrice = price_.getDesc();
	  desc = desc_;
	  number=number_;
	}
	
	public String getString(){
        return (desc + " -> " + descPrice +  " : " +Float.toString(price.getPrice()) + " x " + Integer.toString(number) + " = " + Float.toString(price.getPrice() * number));
	
	}
	
	public String getDesc(){
        return desc;
    }
    
    public String getPriceLib(){
        return descPrice;
    }
    
    public String getPrice(){
        return Float.toString(price.getPrice());
    }
    
    public String getNumber(){
        return Integer.toString(number);
    }
    
    public String getTotal(){
        return Float.toString (price.getPrice() * number);
    }
}

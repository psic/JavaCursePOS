package fr.web_en_royans.lebarajus.POS;
import fr.web_en_royans.lebarajus.POS.Order;
import java.util.List;
import java.util.ArrayList;

public class CurrentCustomer {
   private List<Order> orders;


   public CurrentCustomer(){
      orders = new ArrayList<Order>();
   }

}

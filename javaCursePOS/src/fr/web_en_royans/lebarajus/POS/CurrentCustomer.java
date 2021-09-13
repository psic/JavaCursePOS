package fr.web_en_royans.lebarajus.POS;
import fr.web_en_royans.lebarajus.POS.Order;
import java.util.List;
import java.util.ArrayList;
import charvax.swing.table.AbstractTableModel;

public class CurrentCustomer extends AbstractTableModel {
   private ArrayList<Order> orders;
   private float total=0;
   private final String[] entetes = {"                  Article                   ", "   Prix Lib    ", "    Prix    ", "Qté", "    Total  "};
 
  
   public CurrentCustomer(){
        super();
      orders = new ArrayList<Order>();
   }

    public boolean isCellEditable(int row, int col)
    { return false; }
   
   public void addOrder(Order order){
    orders.add(order);
    total += order.getTotalAsFloat();
    fireTableRowsInserted(orders.size() -1, orders.size() -1);
   }
   
   public float getTotal()
   {
        return total;
   }
   
   public int getRowCount() {
        return orders.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return orders.get(rowIndex).getDesc();
            case 1:
                return orders.get(rowIndex).getPriceLib();
            case 2:
                return orders.get(rowIndex).getPrice();
            case 3:
                return orders.get(rowIndex).getNumber();
            case 4:
                return orders.get(rowIndex).getTotal();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public ArrayList<Order> getOrders(){
        return orders;
    }
 
    public void reset(){
        total = 0;
        orders.clear();
    
    }
//     public void addAmi(Ami ami) {
//         amis.add(ami);
//  
//         fireTableRowsInserted(amis.size() -1, amis.size() -1);
//     }
//  
//     public void removeAmi(int rowIndex) {
//         amis.remove(rowIndex);
//  
//         fireTableRowsDeleted(rowIndex, rowIndex);
//     }
   
}

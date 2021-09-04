package fr.web_en_royans.lebarajus.POS;
import fr.web_en_royans.lebarajus.POS.Order;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import charvax.swing.table.AbstractTableModel;

public class DailyList extends AbstractTableModel {
   private ArrayList<ArrayList<Order>> orders;
   private float total=0;
   private LocalTime timestamp;
   private final String[] entetes = {"#", "Heure", "Total"};
   private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
 
  
   public DailyList(){
        super();
      orders = new ArrayList<ArrayList<Order>>();
      timestamp = LocalTime.now();
   }

    public boolean isCellEditable(int row, int col)
    { return false; }
   
   public void addOrders(ArrayList<Order> orders_){
    orders.add(orders_);
    for (int i=0; i < orders_.size();i++)
    {
        total += orders_.get(i).getTotalAsFloat();
    }
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
                return rowIndex +1;
            case 1:
                String formattedDate = timestamp.format(myFormatObj);
                return formattedDate;
            case 2:
                float tot=0;
                for(int j=0; j< orders.get(rowIndex).size(); j++){
                    tot += orders.get(rowIndex).get(j).getTotalAsFloat();
                }
                return tot;
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 



}

package fr.web_en_royans.lebarajus.POS.GUI;

import charva.awt.Color;
import charva.awt.FlowLayout;
import charvax.swing.BoxLayout;
import charva.awt.BorderLayout;
import charvax.swing.JPanel;
import charvax.swing.JLabel;
import charvax.swing.JTextArea;
import charvax.swing.JTable;
import charvax.swing.border.TitledBorder;
import charvax.swing.border.LineBorder;
import charvax.swing.JScrollPane;
import charvax.swing.BorderFactory;
import charva.awt.Dimension;
import charva.awt.Point;
import fr.web_en_royans.lebarajus.POS.Order;

public class CurrentCustomerGUI extends JPanel{
	private GUIManager gui;
	private BorderLayout mgr;
	private int hauteur;
	private int largeur;
	JLabel titre = new JLabel("Le Client!");
	JLabel total = new JLabel("0.0");
	public CurrentCustomerGUI(GUIManager gui_, int largeur_, int hauteur_) {
		  super();
		  gui = gui_;
		  this.hauteur = hauteur_;
		  this.largeur = largeur_;
// 	      mgr = new FlowLayout();
//          mgr = new BoxLayout(this,BoxLayout.Y_AXIS);
          mgr = new BorderLayout();
		  setForeground(Color.red);
	      setBackground(Color.yellow);
	      
//         TitledBorder border = new TitledBorder("Le Client");//(new LineBorder(Color.red),"Le Client!",0, 0,null, Color.red);
        TitledBorder border= new TitledBorder(BorderFactory.createLineBorder(Color.green,1),"CurrentCustomer");
// //             border.setTitleJustification(TitledBorder.LEFT_ALIGNMENT);
//             border.setTitlePosition(TitledBorder.TOP_ALIGNMENT);

            
            setBorder(border);

            JTable tableau = new JTable(gui.getEngine().getCurrentCustomer());
//             tableau.setPreferredScrollableViewportSize(new Dimension(largeur, hauteur));
            add(tableau,BorderLayout.CENTER);
//             tableau.setBounds(new Point(0,0),new Dimension(90, 50));
//             tableau.setFillsViewportHeight(true);
//             JScrollPane scroll =new JScrollPane(tableau);
//              scroll.setSize(largeur, hauteur);
//              add(scroll,BorderLayout.CENTER);
             add (total,BorderLayout.SOUTH);
//             add(scroll);
//              add (total);
//             add(new JScrollPane(tableau));//, BorderLayout.CENTER);
//             add(tableau);
            
// 	      add(titre);
	      
// 	      private class  AbstractTableModel() {
//             public String getColumnName(int col) {
//                 return columnNames[col].toString();
//             }
//             public int getRowCount() { return rowData.length; }
//             public int getColumnCount() { return columnNames.length; }
//             public Object getValueAt(int row, int col) {
//                 return rowData[row][col];
//             }
//             public boolean isCellEditable(int row, int col)
//                 { return false; }
//             public void setValueAt(Object Order, int row, int col) {
//                 rowData[row][col] = value;
//                 fireTableCellUpdated(row, col);
//             }
//         }
	      
	      setSize(largeur, hauteur);
	      setLocation(0,0);
	      setLayout(mgr);
// pack();
          mgr.doLayout(this);
	      gui.getContentPane().add(this);
	}
	
	public void setTotal(String total_){
        total.setText(total_);
	}
	
	public void  addOrder(Order order){
//         JLabel orderLabel = new JLabel( order.getString());
//         JLabel orderLabel = new JLabel("Totot");
//         add(orderLabel);
//         mgr.doLayout(this);
	}

}

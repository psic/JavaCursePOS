package fr.web_en_royans.lebarajus.POS.GUI;

import charva.awt.Color;
import charva.awt.Toolkit;
import charva.awt.event.ActionEvent;
import charva.awt.event.KeyEvent;
import charva.awt.event.KeyListener;
import charvax.swing.JButton;
import charvax.swing.JFrame;
import charvax.swing.JPanel;
import charvax.swing.JTextField;
import fr.web_en_royans.lebarajus.POS.Engine;
import fr.web_en_royans.lebarajus.POS.CommandInterpreter;
import fr.web_en_royans.lebarajus.POS.Order;

public class GUIManager extends JFrame {
	private int largeur;
	private int hauteur;
	private DailyListGUI daily;
	private CurrentCustomerGUI current;
	private ShortcutListGUI keys;
	private CommandGUI command;
	private Engine engine;
	
	
	
	public  Engine getEngine(){
		return engine;
	}
	
	public void printCommand(String command){
	//	this.command.printCommand(command);
	
	}
	
	public void printError(String error){
        command.handleError(error);
	}
	public void appendToCurrentCommand(char c){
        command.addChar(c);
	}

	JPanel contentPane;
	
    JTextField test2 = new JTextField("test2"); 
   
    public GUIManager(Engine engine_) {
    	engine = engine_;
    	largeur = Toolkit.getDefaultToolkit().getScreenSize().width;
        hauteur = Toolkit.getDefaultToolkit().getScreenSize().height;
     
    	int largeur_3 = largeur/3;
        int hauteur_2 = (hauteur-2)/2;
        
        this.setTitle(" Bar a Jus -- Caisse enregistreuse ");
        command = new CommandGUI(this, (largeur_3*2)-3, hauteur);
        keys = new ShortcutListGUI(this,(largeur_3*2)-3, hauteur_2-1);
        current = new CurrentCustomerGUI(this, (largeur_3*2)-3, hauteur_2);
        daily = new DailyListGUI(this, largeur_3+1, hauteur-2,(largeur_3*2)-3);  
        contentPane = (JPanel) this.getContentPane();    
        contentPane.setLayout(null); 
        
        
        
       // validate();
//        requestFocus();
        setSize(largeur,hauteur);
        adjustLocation();
        doLayout();
        repaint();
       /** Toolkit.getDefaultToolkit().redrawWin();
        Toolkit.getDefaultToolkit().startColors();
        Toolkit.getDefaultToolkit().sync();**/

    }

    public void addOrder(Order order)
    {
        current.addOrder(order);
    }
    
    public void setTotalCurrentCustomer(float total)
    {
        current.setTotal(Float.toString(total));
    }
    
    public void startOrder(){
        command.changeState("On going Order");
    }
    
    public void addToDaily(){
        command.changeState("Add To Daily");
    }
    
    public void terminate() {
        System.exit(0);
    }

	public void refreshCurrentLevel() {
		keys.refresh();
		
	}
	
	public void clean(){
        command.clean();
        keys.reset();
	}
}

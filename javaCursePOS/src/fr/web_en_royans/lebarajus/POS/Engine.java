package fr.web_en_royans.lebarajus.POS;
import charva.awt.event.KeyEvent;
import fr.web_en_royans.lebarajus.POS.GUI.GUIManager;
import fr.web_en_royans.lebarajus.POS.menu.Menu;
import fr.web_en_royans.lebarajus.POS.menu.MenuItem;
import fr.web_en_royans.lebarajus.POS.menu.MenuParserException;
import charvax.swing.AbstractAction;
import charva.awt.event.ActionEvent;
import charvax.swing.JComponent;
// import charvax.swing.KeyStroke;
import javax.swing.KeyStroke;

/**
 *
 *
 * @package
 * @author
 * @version 1.0
 */
public class Engine  {

	private Menu menu;
	private GUIManager gui;
	private CommandInterpreter interpret;
	private CurrentCustomer customer;



	public Engine(){
        	try {
				this.menu = new Menu(this);
			} catch (MenuParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             this.customer=new CurrentCustomer();
        	 this.gui = new GUIManager(this);
        	 this.interpret=new CommandInterpreter (this);
        	 char[] shortcut = interpret.getAllowedShortcut();
        	 
             this.gui.addKeyListener(new charva.awt.event.KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    this_keyPressed(e);
                }
            });
        	 
        	 
//         	 this.gui.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "validatecommad");
//             this.gui.getActionMap().put("validatecommad", new validateCommandAction());
//         	 
// //         	 gui,getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESC, 0), "resetcommad");
// //             gui.getActionMap().put("resetcommad", new resetCommandAction());
//         	 
//             this.gui.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(':'), "begincommad");
//             this.gui.getActionMap().put("begincommad", new beginCommandAction());
//             
//              for (int i=0; i<shortcut.length;i++){
//                 this.gui.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(shortcut[i]), "handlekey");
//                 this.gui.getActionMap().put("handlekey", new interpretAction(this.interpret));
//             }
        }

     void this_keyPressed(KeyEvent e) {
        
   		try {
			interpret.handleKey(e);
		} catch (CommandException ex) {
			this.gui.printError(ex.getError());
		}
    }
    
    void appendToCurrentCommand(char c)
    {
        this.gui.appendToCurrentCommand(c);
    
    }
    public Menu getMenu(){
        	return menu;
        }

    public static void main(String[] args) {
    	Engine engine;
		engine = new Engine();
	    //engine.gui.pack();
	    engine.gui.setVisible(true);
    }

// 	public boolean handleKey(char c) throws CommandException {
// // 		return interpret.handleKey(c);
// 	}

	public void refreshCurrentLevel() {
		gui.refreshCurrentLevel();

	}

	public void startOrder(){
        gui.startOrder();
	}
	
	public void validateCommand(int number){
        Order current_order = new Order(getMenu().getCurrentLevel().getFullDesc() ,getMenu().getCurrentLevel().getSelectedPrice() , number);
//         Order current_order = new Order(getMenu().getCurrentLevel().getDesc() ,4 , number);
        customer.addOrder(current_order);
        gui.addOrder(current_order);

	}
	
	public CurrentCustomer getCurrentCustomer(){
        return customer;
	}
	
// 	private class interpretAction extends AbstractAction {
//         
//         private CommandInterpreter interpret;
//         
//         interpretAction(CommandInterpreter interpret_){
//             interpret = interpret_;
//         }
// 	
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             interpret.handleKey(e.getActionCommand());
//         }
//     }
//     
//     private class beginCommandAction extends AbstractAction {
//                
//         beginCommandAction(){
// 
//         }
// 	
//         @Override
//         public void actionPerformed(ActionEvent e) {
//                 return;        
//         }
//     }
//     
//     private class validateCommandAction extends AbstractAction {
//                
//         validateCommandAction(){
// 
//         }
// 	
//         @Override
//         public void actionPerformed(ActionEvent e) {
//                 return;        
//         }
//     }
	
	

}

package fr.web_en_royans.lebarajus.POS;
import charva.awt.event.KeyEvent;
import fr.web_en_royans.lebarajus.POS.GUI.GUIManager;
import fr.web_en_royans.lebarajus.POS.menu.Menu;
import fr.web_en_royans.lebarajus.POS.menu.MenuParserException;

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



	public Engine(){
        	try {
				this.menu = new Menu(this);
			} catch (MenuParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 this.gui = new GUIManager(this);
        	 this.interpret=new CommandInterpreter (this);
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

	public boolean handleKey(char c) throws CommandException {
		return interpret.handleKey(c);
	}

	public void refreshCurrentLevel() {
		gui.refreshCurrentLevel();

	}

	public void validateCommand(){

	}

}

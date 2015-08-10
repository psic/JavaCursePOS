package fr.web_en_royans.lebarajus.POS;

import org.apache.commons.lang.ArrayUtils;

import charva.awt.event.KeyEvent;

public class CommandInterpreter {
	private Engine engine;
	private boolean isOnGoingCommand = false;
	private char[] nextShortcutList ;
	private static char commandbeginner =':';
	private static char[] commandShortcutList = new char[]{'e','q'};
	private boolean isEndingCommand = false;

	public CommandInterpreter(Engine engine_) {
		engine = engine_;
		getAllowedShortcut();
	}

    public boolean handleKey(char c) throws CommandException{
		//ErrorMessage(String.valueOf(c));
		if (isOnGoingCommand){
			boolean found=false;
			for (int i=0; i<nextShortcutList.length;i++){
				if (nextShortcutList[i] == c)
					found = true;
			}
			if (found == false){
				throw new CommandException("Bad Command");

			}
			else{
				if(! isShortcutCommand(c)){
					engine.getMenu().nextLevel(c);
					getAllowedShortcut();
				}
			}
		}
		else{
			if(commandbeginner == c)
				isOnGoingCommand = true;
			else{
				throw new CommandException(commandbeginner + "to begin a new command");
			}
		}
		return true;
	}

	private boolean isShortcutCommand(char c) {
					switch (c){
					case 'e':
						return true;
					case 'q' :
						return true;
					default :
						return false;
					}
	}

	private void getAllowedShortcut() {
		nextShortcutList = commandShortcutList;
	if (engine.getMenu().getCurrentLevel().hasChild()){
			 char[] shortcutlevellist= engine.getMenu().getCurrentLevel().getChildrenKeys();
			 nextShortcutList = ArrayUtils.addAll(nextShortcutList, shortcutlevellist);
		}
		else{
				if(engine.getMenu().getCurrentLevel().hasPrice()){
					char[] shortcutprice = engine.getMenu().getCurrentLevel().getPriceKeys();
					nextShortcutList = ArrayUtils.addAll(nextShortcutList, shortcutprice);
					isEndingCommand = true;
				}
		}
			/** nextShortcutList = new char[shortcutlevellist.length + commandShortcutList.length ];
			 int i=0;
		/**	for (; i<commandShortcutList.length;i++){
				 nextShortcutList[i] = commandShortcutList[i];
			 }
			 //i++;
			 for (int j=0;j<shortcutlevellist.length;j++){
				 nextShortcutList[i+j]=shortcutlevellist[j];
			 }**/
		 //print allowed shortculist to command
		 //error.setText(new String (nextShortcutList));
	}

}

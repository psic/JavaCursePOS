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
	private boolean yesNoQuestion = false;
	private char lastChar ;

	public CommandInterpreter(Engine engine_) {
		engine = engine_;
		getAllowedShortcut();
	}

    public boolean handleKey(KeyEvent e) throws CommandException{
        char c= (char)e.getKeyCode();

		//ErrorMessage(String.valueOf(c));
		if (yesNoQuestion)
		{
            if(c =='n')
            {
                yesNoQuestion = false;
                return true;
            }
            if(c =='y')
            {
                if(lastChar == 'a'){
                    yesNoQuestion = false;
                    engine.addCurrentToDaily();
                    return true;
                }
            }
            throw new CommandException("Press y or n");
		}
		if (isOnGoingCommand){
			boolean found=false;
			for (int i=0; i<nextShortcutList.length;i++){
				if (nextShortcutList[i] == c)
					found = true;
			}
// 			if (isEndingCommand){
                if (c == KeyEvent.VK_ENTER){
                    engine.validateCommand(1);
                    return true;
// 				   arg0.consume();
                }   
			if(Character.isDigit(c)){
                    engine.validateCommand(Character.getNumericValue(c));
                    return true;
                }
//                 else
//                     throw new CommandException("Order is Over");
//             throw new CommandException("Order is Over. Hit Enter to Validate or add quantity");
//             }
            
			if (found == false){
				throw new CommandException(c + " : Bad Command");

			}
			else{
				if(! isShortcutCommand(c)){
                    engine.appendToCurrentCommand(c);
					engine.getMenu().nextLevel(c);
					getAllowedShortcut();
				}
			}
		}
		else{
//             if (e.getKeyCode() == KeyEvent.VK_ENTER){
            if(c == 'a'){
                yesNoQuestion = true;
                lastChar=c;
                engine.yesNoQuestion();
//                 engine.addCurrentToDaily();
                return true;
            }
		
			if(commandbeginner == c){
				engine.startOrder();
				isOnGoingCommand = true;
				}
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

	
	public boolean isOrderOver(){
        return isEndingCommand;
	}
	
	public boolean isOnGoingCommand(){
        return isOnGoingCommand;
	}
	
	public void clean(){
        isOnGoingCommand =false;
        isEndingCommand = false;
        commandShortcutList = new char[]{'e','q'};
        getAllowedShortcut();
	}
	
	public char[] getAllowedShortcut() {
		nextShortcutList = commandShortcutList;
	if (engine.getMenu().getCurrentLevel().hasChild()){
			 char[] shortcutlevellist= engine.getMenu().getCurrentLevel().getChildrenKeys();
			 nextShortcutList = ArrayUtils.addAll(nextShortcutList, shortcutlevellist);
		}
		else{
				if(engine.getMenu().getCurrentLevel().hasPrice()){
					char[] shortcutprice = engine.getMenu().getCurrentLevel().getPriceKeys();
					nextShortcutList = ArrayUtils.addAll(nextShortcutList, shortcutprice);
// 					isEndingCommand = true;
				}
		}
    return nextShortcutList;
			/** nextShortcutList = new char[shortcutlevellist.length + commandShortcutList.length ];
			 int i=0;
		/**	for (; i<commandShortcutList.length;i++){
				 nextShortcutList[i] = commandShortcutList[i];
			 }
			 //i++;
			 for (int j=0;j<shortcutlevellist.length;j++){
				 nextShortcutList[i+j]=shortcutlevellist[j];
			 }  **/
		 //print allowed shortculist to command
		 //error.setText(new String (nextShortcutList));
	}

}

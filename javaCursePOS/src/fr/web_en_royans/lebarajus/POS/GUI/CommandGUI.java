package fr.web_en_royans.lebarajus.POS.GUI;

import java.util.List;

import charva.awt.Color;
import charva.awt.Component;
import charva.awt.FlowLayout;
import charva.awt.event.ActionEvent;
import charva.awt.event.KeyEvent;
import charva.awt.event.KeyListener;
import charvax.swing.JButton;
import charvax.swing.JLabel;
import charvax.swing.JPanel;
import charvax.swing.JTextArea;
import charvax.swing.JTextField;
import fr.web_en_royans.lebarajus.POS.CommandException;
import fr.web_en_royans.lebarajus.POS.menu.MenuItem;

public class CommandGUI extends JPanel{
	private GUIManager gui;
	private FlowLayout mgr;
	private int hauteur;
	private int largeur;
	private JButton cancelButton = new JButton();
	private JLabel command = new JLabel();
	private JLabel error = new JLabel();
	private JLabel state = new JLabel(": to begin an order");
    private JLabel sep = new JLabel(" || ");
	public CommandGUI(GUIManager gui_, int largeur_,int hauteur_) {
		super();
		gui = gui_;
		this.hauteur = hauteur_;
		this.largeur = largeur_;
        mgr = new FlowLayout();

        setForeground(Color.white);
        setBackground(Color.blue);
        setLocation(0,hauteur-3);
//         command.setRows(1);
//         command.setColumns(15);
        add(cancelButton, null);
        
        state.setLength(20);
        add(state);
        add(sep);
        
        command.setLength(10);
        add(command);
        
        

//         command.addKeyListener(new KeyListener() {
// 			@Override
// 			public void keyPressed(KeyEvent arg0) {
// 				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
// 				  gui.getEngine().validateCommand(1);
// 
// 				   arg0.consume();
// 				}
// 				else{
// 				   		if (arg0.getKeyCode() == KeyEvent.VK_DELETE){
// 
// 
// 				   		}
// 				   		else{
// 								if(!(handleKey((char)arg0.getKeyCode())))
// 										arg0.consume();
// 				   		}
// 				}
// 			}
// 
// 			@Override
// 			public void keyReleased(KeyEvent arg0) {
// 				// TODO Auto-generated method stub
// 
// 			}
// 
// 			@Override
// 			public void keyTyped(KeyEvent arg0) {
// 				// TODO Auto-generated method stub
// 
// 			}
// 
//         });

        
        setSize(largeur,1);
        //setSize(1,10);
//         cancelButton.setText("Prout");
//         cancelButton.addActionListener(new charva.awt.event.ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 cancelButton_actionPerformed(e);
//             }
//         });

        cancelButton.setText("Prout");
        cancelButton.addActionListener(new charva.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelButton_actionPerformed(e);
            }
        });

        add(error);
        setLayout(mgr);
        mgr.doLayout(this);
        gui.getContentPane().add(this);

	}



	public void printCommand(String command){
	}

	void cancelButton_actionPerformed(ActionEvent e) {
//         gui.terminate();
        state.setText("Validation!");
        gui.getEngine().validateCommand(1);
    }

// 	private boolean handleKey(char c){
// 		try {
// 			return gui.getEngine().handleKey(c);
// 		} catch (CommandException e) {
// 			return handleError(e.getError());
// 		}
// 	}
    public void addChar(char c){
        command.setText(command.getText() +c);
    }
    
    public void changeState(String stateStr)
    {
        state.setText(stateStr);
    }
    
	public boolean handleError(String errormsg) {
		error.setText(errormsg);
		return false;
	//int caret = command.getCaretPosition();
		//command.replaceRange("", caret - 1, caret);

		//KeyEvent e = new KeyEvent (KeyEvent.VK_BACK_SPACE,KeyEvent.KEY_TYPED, command);
		//KeyEvent f = new KeyEvent (KeyEvent.VK_LEFT,KeyEvent.KEY_TYPED, command);
		//command.processKeyEvent(e);
		/**KeyEvent f = new KeyEvent ('\t',KeyEvent.KEY_TYPED, command);
		cancelButton.requestFocus();
		command.requestFocus();**/
		//KeyEvent g = new KeyEvent (KeyEvent.VK_BACK_TAB,KeyEvent.KEY_TYPED, cancelButton);
		//key == '\t'
		 //command.getParent().nextFocus();
		// previousFocus();
		//e = new KeyEvent (KeyEvent.VK_DELETE,KeyEvent.KEY_TYPED, command);
		//command.processKeyEvent(f);
		//cancelButton.processKeyEvent(g);
		//repaint();
		//command.repaint();
		//command.requestSync();
		//command.processKeyEvent(e);

		//command.replaceRange("",command.getText().length()-1,command.getText().length()-1);
		//command.setText("");
	}


}

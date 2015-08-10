package fr.web_en_royans.lebarajus.POS;

public class CommandException extends Exception {
	private String error;
	public CommandException(String error_) {
		error= error_;
	}

	public String getError(){
		return error;
	}
}

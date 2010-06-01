package controller;

/**
 * 
 * Prosta klasa Zadrzenia
 * @author Maciej Sulek
 * 
 */
public class ExtendEvent 
{
	/** przechowywana komenda do wykonania */
	public String command;
	
	/**
	 * konstruktor klasy
	 */
	public ExtendEvent(String command)
	{
		this.command = command;
	}

	/**
	 * @return the command
	 */
	public String getCommand() 
	{
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(String command) 
	{
		this.command = command;
	}	
}

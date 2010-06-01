package controller;

/**
 * 
 * Klasa rozszerzajaca klase Akcji Rozszerzonej na ActionEvent
 * @author Maciej Sulek
 * 
 */
public class ExtendActionEvent extends ExtendEvent
{
	public String command;
	
	public ExtendActionEvent(String command)
	{
		super(command);
	}
}

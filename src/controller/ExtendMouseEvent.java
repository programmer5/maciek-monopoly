package controller;

/**
 * 
 * Klasa rozszrzajaca klase zdarzenia o Zadzenia Myszy
 * @author Maciej Sulek
 * 
 */
public class ExtendMouseEvent extends ExtendEvent
{	
	public String command;
	
	public ExtendMouseEvent(String command)
	{
		super(command);
	}
}

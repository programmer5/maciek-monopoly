package controller.actions;

import view.ViewChanger;
import controller.Controller;

/**
 * Akcja zamykania okna nowej gry
 * @author Maciej Sulek
 */
public class ExtendCloseNewGameAction extends ExtendAction
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendCloseNewGameAction
	 * @param controller kontroler gry
	 */
	public ExtendCloseNewGameAction(final Controller controller) 
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja ukrywajaca okno nowej gry
	 */
	@Override
	public void perform() 
	{
		ViewChanger mainViewChanger = controller.getViewChanger();
		mainViewChanger.setNewGameVisible(false);
	}
}

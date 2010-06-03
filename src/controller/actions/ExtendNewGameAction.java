package controller.actions;

import view.ViewChanger;
import controller.Controller;

/**
 * Akcja wyswietlania okna nowej gry
 * @author Maciej Sulek
 */
public class ExtendNewGameAction extends ExtendAction
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendNewGameAction
	 * @param controller kontroler gry
	 */
	public ExtendNewGameAction(final Controller controller) 
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja uruchamiajaca okno nowej gry
	 */
	@Override
	public void perform() 
	{
		ViewChanger mainViewChanger = controller.getViewChanger();
		mainViewChanger.setNewGameVisible(true);
	}
}

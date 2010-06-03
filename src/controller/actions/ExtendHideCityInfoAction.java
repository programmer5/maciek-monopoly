package controller.actions;

import view.ViewChanger;
import controller.Controller;

/**
 * Klasa akcji ukrycia okna z informacjami o miescie
 * @author Maciej Sulek
 */
public class ExtendHideCityInfoAction extends ExtendAction
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendHideCityInfoAction
	 * @param controller kontroler gry
	 */
	public ExtendHideCityInfoAction(final Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja wykonujaca ukrecie okna z informacjami o miescie
	 */
	@Override
	public void perform()
	{
		ViewChanger mainViewChanger = controller.getViewChanger();
		mainViewChanger.setVisibleCityInfoView(false);
	}
	
}

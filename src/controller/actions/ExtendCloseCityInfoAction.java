package controller.actions;

import view.ViewChanger;
import controller.Controller;

/**
 * Akcja chowania okna informacji o miescie
 * @author Maciej Sulek
 */
public class ExtendCloseCityInfoAction extends ExtendAction 
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendCloseCityInfoAction
	 * @param controller kontroler gry
	 */
	public ExtendCloseCityInfoAction(final Controller controller) 
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja ukrywajaca okno z informacjami o miescie
	 */
	@Override
	public void perform() 
	{
		ViewChanger mainViewChanger = controller.getViewChanger();
		mainViewChanger.setVisibleCityInfoView(false);
	}
}

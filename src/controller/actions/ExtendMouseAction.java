package controller.actions;

import view.ViewChanger;
import controller.Controller;
import model.CityModel;
import model.Model;

/**
 * Klasa akcji ruchu myszy na polu miasta
 * @author Maciej Sulek
 */
public class ExtendMouseAction extends ExtendAction
{
	/**	kontroler gry */
	private Controller controller;
	
	/** pole, na ktore najechano */
	private int actField;
	
	/**
	 * Konstruktor klasy
	 * @param controller kontroler gry
	 */
	public ExtendMouseAction(Controller controller) 
	{
		this.controller = controller;
	}
	
	/**
	 * Wyswietlanie zaktualizowanego okna informacji o miescie
	 */
	@Override
	public void perform() 
	{
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		this.actField = mainViewChanger.getActField();
		if (mainModel.getField(actField) instanceof CityModel == false) return;
		String[] tmpParams = ((CityModel)mainModel.getField(actField)).getAllParams();
		mainViewChanger.updateAllCityInfoView(tmpParams);
		mainViewChanger.setVisibleCityInfoView(true);
	}
	
}

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
		this.actField = Controller.getActField();
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		if (mainModel.field[actField] instanceof CityModel == false) return;
		String[] tmpParams = ((CityModel)mainModel.field[actField]).getAllParams();
		mainViewChanger.updateAllCityInfoView(tmpParams);
		mainViewChanger.setVisibleCityInfoView(true);
	}
	
}

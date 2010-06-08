package controller.actions;

import view.ViewChanger;
import model.CityModel;
import model.Model;
import model.TrainModel;
import controller.Controller;

/**
 * Klasa akcji wywolywanej przy zakupie miasta
 * @author Maciej Sulek
 */
public class ExtendBuyCityAction extends ExtendAction 
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendBuyCityAction
	 * @param controller kontroler gry
	 */
	public ExtendBuyCityAction(Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja umozliwiajaca kupowanie miasta
	 */
	@Override
	public void perform() 
	{
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		int actPlayer = mainModel.getCurrentPlayer();
		int fieldNumber = mainModel.getChecker(actPlayer).getFieldNumber();
		int playerSaldo = mainModel.getPlayer(actPlayer).getSaldo();
		int cost = 0;
		if (mainModel.getField(fieldNumber) instanceof CityModel)
		{
			cost = ((CityModel)mainModel.getField(fieldNumber)).getCityPrice();
		}
		else
		{
			cost = ((TrainModel)mainModel.getField(fieldNumber)).getTrainCost();
		}
		if (playerSaldo < cost)
		{
			mainViewChanger.showGameDialog("Masz za mało pieniędzy aby dokonać zakupu!", "Niestety...");
		}
		else  
		{
			mainViewChanger.showGameDialog("Dokonałeś nowego zakupu!", "Gratulacje!");
			mainViewChanger.changeBuyCityButtonState(false);
			playerSaldo = playerSaldo - cost;
			mainModel.getPlayer(actPlayer).setSaldo(playerSaldo);
			mainModel.setCityOwner(fieldNumber, (short) (actPlayer + 1));
			mainViewChanger.setPlayerMoney(actPlayer, playerSaldo);
		}
	}
}

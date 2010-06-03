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
		int fieldNumber = mainModel.checkers[actPlayer].getFieldNumber();
		int playerSaldo = mainModel.players[actPlayer].getSaldo();
		int cost = 0;
		if (mainModel.field[fieldNumber] instanceof CityModel)
		{
			cost = ((CityModel)mainModel.field[fieldNumber]).getCityPrice();
		}
		else
		{
			cost = ((TrainModel)mainModel.field[fieldNumber]).getTrainCost();
		}
		if (playerSaldo < cost)
		{
			mainViewChanger.showGameDialog("Masz za mało pieniędzy dokonać zakupu!", "Niestety...");
		}
		else  
		{
			mainViewChanger.showGameDialog("Dokonałeś nowego zakupu!", "Gratulacje!");
			mainViewChanger.changeBuyCityButtonState(false);
			playerSaldo = playerSaldo - cost;
			mainModel.players[actPlayer].setSaldo(playerSaldo);
			mainModel.setCityOwner(fieldNumber, (short) (actPlayer + 1));
			mainViewChanger.setPlayerMoney(actPlayer, playerSaldo);
		}
	}
}

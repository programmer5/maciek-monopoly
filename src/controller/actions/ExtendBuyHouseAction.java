package controller.actions;

import model.CityModel;
import model.Model;
import view.ViewChanger;
import controller.Controller;

/**
 * Akcja zakupu domu
 * @author Maciej Sulek
 */
public class ExtendBuyHouseAction extends ExtendAction 
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendBuyHouseAction
	 * @param controller kontroler gry
	 */
	public ExtendBuyHouseAction(Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja umozliwiajaca kupowanie hotelu
	 */
	@Override
	public void perform() 
	{
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		mainViewChanger.setBuyButtonsEnabled(false, false, false);
		int actPlayer = mainModel.getCurrentPlayer();
		int playerSaldo = mainModel.players[actPlayer].getSaldo();
		int fieldNumber = mainModel.checkers[actPlayer].getFieldNumber();
		int cost = ((CityModel)mainModel.field[fieldNumber]).getHouseCost();
		if (playerSaldo < cost)
		{
			mainViewChanger.showGameDialog("Nie stać Cię na zakup domu!", "Ups...");
			return;
		}
		mainModel.players[actPlayer].changeSaldo(cost);
		((CityModel)mainModel.field[fieldNumber]).incEstateNumber();
		mainViewChanger.setPlayerMoney(actPlayer, playerSaldo - cost);
		mainViewChanger.addHouseToCity(fieldNumber);
		mainViewChanger.showGameDialog("Kupiłeś dom!", "Nieźle...");
	}
}

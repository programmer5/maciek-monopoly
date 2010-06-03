package controller.actions;

import model.Model;
import view.ViewChanger;
import controller.Controller;

/**
 * Akcja konczenia tury
 * @author Maciej Sulek
 */
public class ExtendEndTurnAction extends ExtendAction 
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendEndTurnAction
	 * @param controller kontroler gry
	 */
	public ExtendEndTurnAction(final Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Funkcja umozliwiajaca konczenie tury
	 */
	@Override
	public void perform() 
	{
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		for (int i = 0; i < mainModel.getPlayerNumber(); ++i)
		{
			if (mainModel.players[i].getSaldo() < 0)
			{
				//TODO Konczenie gry
				//endGame();
				return;
			}
		}
		mainViewChanger.nextPlayer(mainModel.getCurrentPlayer(), mainModel.nextPlayer());
		mainViewChanger.changeGameButtonsState(true, false);
	}
}

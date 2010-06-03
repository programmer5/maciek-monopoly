package controller.actions;

import java.util.Random;

import model.CityModel;
import model.Model;
import model.TrainModel;
import view.ViewChanger;
import controller.Controller;

/**
 * Akcja rzutu kostka
 * @author Maciej Sulek
 */
public class ExtendRollDiceAction extends ExtendAction 
{
	/** kontroler gry */
	private Controller controller;
	
	/**
	 * Konstruktor klasy ExtendRollDiceAction
	 * @param controller kontroler gry
	 */
	public ExtendRollDiceAction(final Controller controller) 
	{
		this.controller = controller;
	}

	/**
	 * Funkcja wywolywana przy rzucie kostka
	 */
	@Override
	public void perform() 
	{
		Model mainModel = controller.getModel();
		ViewChanger mainViewChanger = controller.getViewChanger();
		Random rnd = new Random();
		int rndNumber = rnd.nextInt(6) + 1;
		int actPlayer = mainModel.getCurrentPlayer();
		int tmp = 0;
		int tmpMustStay = mainModel.players[actPlayer].getMustStay();
		if (tmpMustStay != 0)
		{
			mainModel.players[actPlayer].incMustStay();
			mainViewChanger.showGameDialog("Niestety siedzisz w wiezeniu jeszcze przez " + (tmpMustStay-1) + " kolejek!", "Bądź cierpliwy...");
			return;
		}
		String tmpTable[];
		int fieldNumber = mainModel.checkers[actPlayer].getFieldNumber();
		int newFieldNumber = mainModel.checkers[actPlayer].moveOn(rndNumber);
		int whoIsCity = mainModel.whoIsThisCity(newFieldNumber);
		//podstawowe czynnosci
		mainViewChanger.setDiceResult(rndNumber);
		mainViewChanger.moveChecker(actPlayer, fieldNumber, newFieldNumber);
		mainViewChanger.changeGameButtonsState(false, true);
		//platnosci
		if (whoIsCity == 0) //miasto do kupienia
		{
			mainViewChanger.setBuyButtonsEnabled(true, false, false);
		}
		else if (whoIsCity == -1) //niczyja wlasnosci - pole specjalne 
		{
			mainViewChanger.setBuyButtonsEnabled(false, false, false);
			tmpTable = mainModel.field[newFieldNumber].pay(0);
			if (tmpTable[1].equals("GO_TO_JAIL") == true)
			{
				tmpMustStay = Integer.parseInt(tmpTable[0]);
				mainModel.players[actPlayer].setMustStay(tmpMustStay);
				mainViewChanger.showGameDialog("Trafiłeś do wiezienia na " + tmpMustStay + " kolejke(i)!", "Niestety...!");
				mainViewChanger.moveChecker(actPlayer, newFieldNumber, 21);
				mainModel.checkers[actPlayer].setFieldNumber(21);
			}
			else if (tmpTable[1].equals("") == false)
			{
				mainModel.players[actPlayer].changeSaldo(Integer.parseInt(tmpTable[0]));
				mainViewChanger.setPlayerMoney(actPlayer, mainModel.players[actPlayer].getSaldo());
				mainViewChanger.showGameDialog(tmpTable[1], "Uwaga!");
			}
			
		}
		else if (whoIsCity != actPlayer+1) //gracz stanal na nieswoim miescie
		{
			tmp = mainModel.playerHasDistrict(newFieldNumber, (short) (whoIsCity));
			tmpTable = mainModel.field[newFieldNumber].pay(tmp);
			int tmpSaldo = Integer.parseInt(tmpTable[0]);
			mainModel.players[actPlayer].changeSaldo(-tmpSaldo);
			mainModel.players[whoIsCity - 1].changeSaldo(tmpSaldo);
			mainViewChanger.setPlayerMoney(actPlayer, mainModel.players[actPlayer].getSaldo());
			mainViewChanger.setPlayerMoney(whoIsCity - 1, mainModel.players[whoIsCity - 1].getSaldo());
			mainViewChanger.showGameDialog("Stanałeś na nieswoje pole! Za postój płacisz " + tmpSaldo + " MMM!", "Niestety...");
		}
		else if (whoIsCity == actPlayer+1) //gracz stoi na swoim polu
		{
			if (mainModel.field[newFieldNumber] instanceof TrainModel)
			{
				mainViewChanger.setBuyButtonsEnabled(false, false, false);
				return;
			}
			short tmpEstateNumber = ((CityModel)mainModel.field[newFieldNumber]).getEstateNumber();
			if (tmpEstateNumber == 0)
			{
				mainViewChanger.setBuyButtonsEnabled(false, true, false);
			}
			else if (tmpEstateNumber == 3)
			{
				mainViewChanger.setBuyButtonsEnabled(false, false, true);
			}
			else if (tmpEstateNumber == 4)
			{
				mainViewChanger.setBuyButtonsEnabled(false, false, false);
			}
		}
	}
}

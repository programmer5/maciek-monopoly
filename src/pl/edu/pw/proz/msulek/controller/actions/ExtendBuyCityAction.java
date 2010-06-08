package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.CityModel;
import pl.edu.pw.proz.msulek.model.Model;
import pl.edu.pw.proz.msulek.model.TrainModel;
import pl.edu.pw.proz.msulek.view.ViewChanger;

/**
 * Klasa akcji wywolywanej przy zakupie miasta
 * 
 * @author Maciej Sulek
 */
public class ExtendBuyCityAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendBuyCityAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendBuyCityAction(final Controller controller)
    {
        this.controller = controller;
    }

    /**
     * Funkcja umozliwiajaca kupowanie miasta
     */
    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        final int actPlayer = mainModel.getCurrentPlayer();
        final int fieldNumber = mainModel.getChecker(actPlayer).getFieldNumber();
        int playerSaldo = mainModel.getPlayer(actPlayer).getSaldo();
        int cost = 0;
        if(mainModel.getField(fieldNumber) instanceof CityModel)
        {
            cost = ((CityModel) mainModel.getField(fieldNumber)).getCityPrice();
        }
        else
        {
            cost = ((TrainModel) mainModel.getField(fieldNumber)).getTrainCost();
        }
        if(playerSaldo < cost)
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

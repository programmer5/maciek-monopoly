package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.CityModel;
import pl.edu.pw.proz.msulek.model.Model;
import pl.edu.pw.proz.msulek.view.ViewChanger;

public class ExtendBuyHotelAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendBuyHotelAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendBuyHotelAction(final Controller controller)
    {
        this.controller = controller;
    }

    /**
     * Funkcja umozliwiajaca kupowanie hotelu
     */
    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setBuyButtonsEnabled(false, false, false);
        final int actPlayer = mainModel.getCurrentPlayer();
        final int playerSaldo = mainModel.getPlayer(actPlayer).getSaldo();
        final int fieldNumber = mainModel.getChecker(actPlayer).getFieldNumber();
        final int cost = ((CityModel) mainModel.getField(fieldNumber)).getHotelCost();
        if(playerSaldo < cost)
        {
            mainViewChanger.showGameDialog("Nie stać Cię na zakup hotelu!", "Ups...");
            return;
        }
        mainModel.getPlayer(actPlayer).changeSaldo(cost);
        ((CityModel) mainModel.getField(fieldNumber)).incEstateNumber();
        mainViewChanger.setPlayerMoney(actPlayer, playerSaldo - cost);
        mainViewChanger.addHotelToCity(fieldNumber);
        mainViewChanger.showGameDialog("Kupiłeś hotel!", "Imponujące!");
    }
}

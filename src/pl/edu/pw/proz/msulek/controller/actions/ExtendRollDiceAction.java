package pl.edu.pw.proz.msulek.controller.actions;

import java.util.Random;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.CityModel;
import pl.edu.pw.proz.msulek.model.Model;
import pl.edu.pw.proz.msulek.model.TrainModel;
import pl.edu.pw.proz.msulek.view.ViewChanger;


/**
 * Akcja rzutu kostka
 * 
 * @author Maciej Sulek
 */
public class ExtendRollDiceAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendRollDiceAction
     * 
     * @param controller
     *            kontroler gry
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
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        final Random rnd = new Random();
        final int rndNumber = rnd.nextInt(6) + 1;
        final int actPlayer = mainModel.getCurrentPlayer();
        int tmp = 0;
        int tmpMustStay = mainModel.getPlayer(actPlayer).getMustStay();
        if(tmpMustStay != 0)
        {
            mainModel.getPlayer(actPlayer).incMustStay();
            mainViewChanger.showGameDialog("Niestety siedzisz w wiezeniu jeszcze przez " + (tmpMustStay - 1) + " kolejek!", "Bądź cierpliwy...");
            return;
        }
        String tmpTable[];
        final int fieldNumber = mainModel.getChecker(actPlayer).getFieldNumber();
        final int newFieldNumber = mainModel.getChecker(actPlayer).moveOn(rndNumber);
        final int whoIsCity = mainModel.whoIsThisCity(newFieldNumber);
        // podstawowe czynnosci
        mainViewChanger.setDiceResult(rndNumber);
        mainViewChanger.moveChecker(actPlayer, fieldNumber, newFieldNumber);
        mainViewChanger.changeGameButtonsState(false, true);
        // platnosci
        if(whoIsCity == 0) // miasto do kupienia
        {
            mainViewChanger.setBuyButtonsEnabled(true, false, false);
        }
        else if(whoIsCity == -1) // niczyja wlasnosci - pole specjalne
        {
            mainViewChanger.setBuyButtonsEnabled(false, false, false);
            tmpTable = mainModel.getField(newFieldNumber).pay(0);
            if(tmpTable[1].equals("GO_TO_JAIL") == true)
            {
                tmpMustStay = Integer.parseInt(tmpTable[0]);
                mainModel.getPlayer(actPlayer).setMustStay(tmpMustStay);
                mainViewChanger.showGameDialog("Trafiłeś do wiezienia na " + tmpMustStay + " kolejke(i)!", "Niestety...!");
                mainViewChanger.moveChecker(actPlayer, newFieldNumber, 21);
                mainModel.getChecker(actPlayer).setFieldNumber(21);
            }
            else if(tmpTable[1].equals("") == false)
            {
                mainModel.getPlayer(actPlayer).changeSaldo(Integer.parseInt(tmpTable[0]));
                mainViewChanger.setPlayerMoney(actPlayer, mainModel.getPlayer(actPlayer).getSaldo());
                mainViewChanger.showGameDialog(tmpTable[1], "Uwaga!");
            }

        }
        else if(whoIsCity != actPlayer + 1) // gracz stanal na nieswoim
        // miescie
        {
            tmp = mainModel.playerHasDistrict(newFieldNumber, (short) (whoIsCity));
            tmpTable = mainModel.getField(newFieldNumber).pay(tmp);
            final int tmpSaldo = Integer.parseInt(tmpTable[0]);
            mainModel.getPlayer(actPlayer).changeSaldo(-tmpSaldo);
            mainModel.getPlayer(whoIsCity - 1).changeSaldo(tmpSaldo);
            mainViewChanger.setPlayerMoney(actPlayer, mainModel.getPlayer(actPlayer).getSaldo());
            mainViewChanger.setPlayerMoney(whoIsCity - 1, mainModel.getPlayer(whoIsCity - 1).getSaldo());
            mainViewChanger.showGameDialog("Stanałeś na nieswoje pole! Za postój płacisz " + tmpSaldo + " MMM!", "Niestety...");
        }
        else if(whoIsCity == actPlayer + 1) // gracz stoi na swoim polu
        {
            if(mainModel.getField(newFieldNumber) instanceof TrainModel)
            {
                mainViewChanger.setBuyButtonsEnabled(false, false, false);
                return;
            }
            final short tmpEstateNumber = ((CityModel) mainModel.getField(newFieldNumber)).getEstateNumber();
            if(tmpEstateNumber == 0)
            {
                mainViewChanger.setBuyButtonsEnabled(false, true, false);
            }
            else if(tmpEstateNumber == 3)
            {
                mainViewChanger.setBuyButtonsEnabled(false, false, true);
            }
            else if(tmpEstateNumber == 4)
            {
                mainViewChanger.setBuyButtonsEnabled(false, false, false);
            }
        }
    }
}

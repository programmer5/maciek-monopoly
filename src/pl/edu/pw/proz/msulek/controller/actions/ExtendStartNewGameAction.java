package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.Model;
import pl.edu.pw.proz.msulek.view.ViewChanger;

/**
 * Rozpoczecie nowej gry
 * 
 * @author Maciej Sulek
 */
public class ExtendStartNewGameAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendStartNewGameAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendStartNewGameAction(final Controller controller)
    {
        this.controller = controller;
    }

    /**
     * Funkcja wykonujaca akcje
     */
    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        final String[] playersNames = mainViewChanger.getNewGamePlayersNames();
        int playerNumber = 0;
        if(playersNames[0].equals("") == false)
        {
            ++playerNumber;
            if(playersNames[1].equals("") == false)
            {
                ++playerNumber;
                if(playersNames[2].equals("") == false)
                {
                    ++playerNumber;
                    if(playersNames[3].equals("") == false)
                    {
                        ++playerNumber;
                    }
                }
            }
        }
        if(playerNumber == 0)
        {
            mainViewChanger.showNewGameDialog("Nie wpisałeś nazwy żadnego gracza (pamiętaj, że wpisywanie musisz zacząć od pierwszego gracza)!", "Błąd nowej gry!");
        }
        else if(playerNumber == 1)
        {
            mainViewChanger.showNewGameDialog("Jeden gracz to za mało (pamiętaj, że wpisywanie musisz zacząć od pierwszego gracza)!", "Błąd nowej gry!");
            playerNumber = 0;
        }
        else
        {
            mainViewChanger.setGamePlayersNames(playersNames);
            for (int i = 0; i < playerNumber; ++i)
            {
                mainViewChanger.newGameCheckersState(i);
            }
            for (int i = playerNumber; i < 4; ++i)
            {
                mainViewChanger.setPlayerPanelVisible(i, false);
            }
            mainModel.setPlayerNumber(playerNumber);
            mainViewChanger.newGamePlayerMoney(mainModel.getPlayerSaldo(0));
            mainViewChanger.setNewGameVisible(false);
            mainViewChanger.enableButtons();
            mainViewChanger.setPlayerHighlight(0, true);
        }
    }
}

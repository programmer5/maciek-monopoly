package pl.edu.pw.elka.proz.msulek.controller.actions;

import pl.edu.pw.elka.proz.msulek.controller.Controller;
import pl.edu.pw.elka.proz.msulek.model.Model;
import pl.edu.pw.elka.proz.msulek.view.ViewChanger;

/**
 * Akcja konczenia tury
 * 
 * @author Maciej Sulek
 */
public class ExtendEndTurnAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendEndTurnAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendEndTurnAction(final Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        for (int i = 0; i < mainModel.getPlayerNumber(); ++i)
        {
            if(mainModel.getPlayer(i).getSaldo() < 0)
            {
                mainViewChanger.allButtonsEnableFalse();
                mainViewChanger.showGameDialog("Saldo jednego z graczy jest mniejsze od zera, co powoduje, że dalsza gra musi być przerwana! Gratulacje dla zwycięzcy!", "Koniec GRY!");
                return;
            }
        }
        mainViewChanger.nextPlayer(mainModel.getCurrentPlayer(), mainModel.nextPlayer());
        mainViewChanger.changeGameButtonsState(true, false);
    }
}

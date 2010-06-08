package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.Model;
import pl.edu.pw.proz.msulek.view.ViewChanger;

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

    /**
     * Funkcja umozliwiajaca konczenie tury
     */
    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        for (int i = 0; i < mainModel.getPlayerNumber(); ++i)
        {
            if(mainModel.getPlayer(i).getSaldo() < 0)
            {
                // TODO Konczenie gry
                // endGame();
                return;
            }
        }
        mainViewChanger.nextPlayer(mainModel.getCurrentPlayer(), mainModel.nextPlayer());
        mainViewChanger.changeGameButtonsState(true, false);
    }
}

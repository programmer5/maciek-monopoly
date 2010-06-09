package pl.edu.pw.elka.proz.msulek.controller.actions;

import pl.edu.pw.elka.proz.msulek.controller.Controller;
import pl.edu.pw.elka.proz.msulek.view.ViewChanger;

/**
 * Akcja zamykania okna nowej gry
 * 
 * @author Maciej Sulek
 */
public class ExtendCloseNewGameAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendCloseNewGameAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendCloseNewGameAction(final Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void perform()
    {
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setNewGameVisible(false);
    }
}

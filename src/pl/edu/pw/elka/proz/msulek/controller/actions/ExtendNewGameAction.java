package pl.edu.pw.elka.proz.msulek.controller.actions;

import pl.edu.pw.elka.proz.msulek.controller.Controller;
import pl.edu.pw.elka.proz.msulek.view.ViewChanger;

/**
 * Akcja wyswietlania okna nowej gry
 * 
 * @author Maciej Sulek
 */
public class ExtendNewGameAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendNewGameAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendNewGameAction(final Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void perform()
    {
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setNewGameVisible(true);
    }
}

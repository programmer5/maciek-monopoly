package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import view.ViewChanger;

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

    /**
     * Funkcja uruchamiajaca okno nowej gry
     */
    @Override
    public void perform()
    {
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setNewGameVisible(true);
    }
}

package pl.edu.pw.elka.proz.msulek.controller.actions;

import pl.edu.pw.elka.proz.msulek.controller.Controller;
import pl.edu.pw.elka.proz.msulek.view.ViewChanger;

/**
 * Klasa akcji ukrycia okna z informacjami o miescie
 * 
 * @author Maciej Sulek
 */
public class ExtendHideCityInfoAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendHideCityInfoAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendHideCityInfoAction(final Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void perform()
    {
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setVisibleCityInfoView(false);
    }

}

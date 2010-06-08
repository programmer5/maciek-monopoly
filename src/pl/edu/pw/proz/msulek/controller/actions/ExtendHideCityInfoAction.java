package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import view.ViewChanger;

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

    /**
     * Funkcja wykonujaca ukrecie okna z informacjami o miescie
     */
    @Override
    public void perform()
    {
        final ViewChanger mainViewChanger = controller.getViewChanger();
        mainViewChanger.setVisibleCityInfoView(false);
    }

}

package pl.edu.pw.elka.proz.msulek.controller.actions;

import pl.edu.pw.elka.proz.msulek.controller.Controller;
import pl.edu.pw.elka.proz.msulek.view.ViewChanger;

/**
 * Akcja chowania okna informacji o miescie
 * 
 * @author Maciej Sulek
 */
public class ExtendCloseCityInfoAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /**
     * Konstruktor klasy ExtendCloseCityInfoAction
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendCloseCityInfoAction(final Controller controller)
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

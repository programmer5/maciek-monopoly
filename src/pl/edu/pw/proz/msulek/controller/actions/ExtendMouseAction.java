package pl.edu.pw.proz.msulek.controller.actions;

import pl.edu.pw.proz.msulek.controller.Controller;
import pl.edu.pw.proz.msulek.model.CityModel;
import pl.edu.pw.proz.msulek.model.Model;
import view.ViewChanger;

/**
 * Klasa akcji ruchu myszy na polu miasta
 * 
 * @author Maciej Sulek
 */
public class ExtendMouseAction extends ExtendAction
{
    /** kontroler gry */
    private final Controller controller;

    /** pole, na ktore najechano */
    private int actField;

    /**
     * Konstruktor klasy
     * 
     * @param controller
     *            kontroler gry
     */
    public ExtendMouseAction(final Controller controller)
    {
        this.controller = controller;
    }

    /**
     * Wyswietlanie zaktualizowanego okna informacji o miescie
     */
    @Override
    public void perform()
    {
        final Model mainModel = controller.getModel();
        final ViewChanger mainViewChanger = controller.getViewChanger();
        this.actField = mainViewChanger.getActField();
        if(mainModel.getField(actField) instanceof CityModel == false)
        {
            return;
        }
        final String[] tmpParams = ((CityModel) mainModel.getField(actField)).getAllParams();
        mainViewChanger.updateAllCityInfoView(tmpParams);
        mainViewChanger.setVisibleCityInfoView(true);
    }

}

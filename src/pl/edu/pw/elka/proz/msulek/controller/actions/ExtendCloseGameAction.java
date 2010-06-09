package pl.edu.pw.elka.proz.msulek.controller.actions;

/**
 * Akcja zamykania gry
 * 
 * @author Maciej Sulek
 */
public class ExtendCloseGameAction extends ExtendAction
{
    /**
     * Funkcja zamykajaca gre
     */
    @Override
    public void perform()
    {
        System.exit(0);
    }
}

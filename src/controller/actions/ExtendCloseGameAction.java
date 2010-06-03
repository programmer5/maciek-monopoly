package controller.actions;

/**
 * Akcja zamykania gry 
 * @author Maciej Sulek
 */
public class ExtendCloseGameAction extends ExtendAction
{
	/**
	 * Funkcja ukrywajaca okno nowej gry
	 */
	@Override
	public void perform() 
	{
		System.exit(0);
	}
}

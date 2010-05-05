package view;

/**
 * 
 * @author Maciej Sulek
 * Klasa widoku
 *
 */

public class View 
{
	/**
	 * 
	 * Deklaracje prywatnych zmiennych
	 * @param mainboard zmienna glownej planszy
	 * 
	 */
	private Board mainboard;
	
	/**
	 * 
	 * Konstruktor klasy View
	 * 
	 */
	public View()
	{
		mainboard = new Board();
	}
	
	/**
	 * 
	 * Funkcja akywujaca potrzebne komponenty
	 * 
	 */
	public void start()
	{
		mainboard.setVisible(true);
	}
}

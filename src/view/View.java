package view;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;

/**
 * 
 * @author Maciej Sulek
 * Klasa widoku
 *
 */

public class View 
{
	/** przechowuje widok planszy */
	BoardView mainboard;
	/** przechowuje pola */
	private FieldView field[];
	
	/**
	 * 
	 * Konstruktor klasy View
	 * 
	 */
	public View()
	{
		mainboard = new BoardView();
		mainboard.setLayout(new BorderLayout(2,2));
		field = new FieldView[36];
		for (int i = 0; i < 28; ++i)
		{
			field[i] = new CityView("Warszawa" + i);
		}
		field[0] = new StartView();
		field[3] = new ChanceView();
		field[5] = new TrainView(); 
		field[10] = new RiskView();
		field[12] = new TrainView();
		field[16] = new ChanceView();
		field[18] = new TrainView();
		field[24] = new TrainView();
		field[26] = new RiskView();
	}
	
	/**
	 * 
	 * Funkcja aktywująca potrzebne komponenty
	 * 
	 */
	public void start()
	{
		mainboard.start();
		for (int i = 6; i >= 1; --i) mainboard.addToLeftPanel(field[i]);
		for (int i = 7; i <= 14; ++i) mainboard.addToTopPanel(field[i]);
		for (int i = 15; i <= 20; ++i) mainboard.addToRightPanel(field[i]);
		mainboard.addToBottomPanel(field[0]);
		for (int i = 27; i >= 21; --i)	mainboard.addToBottomPanel(field[i]);
		mainboard.addToGamePanel(new JLabel("WELCOME TO MONOPOLY"));

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		gs.setFullScreenWindow(mainboard);

	}
}

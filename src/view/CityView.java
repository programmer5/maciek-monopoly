package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Maciej Sulek
 * Klasa do reprezenatacji miasta
 * 
 */

public final class CityView extends FieldView
{

	/**	wygenerowane id */
	private static final long serialVersionUID = 964335094298912657L;
	/** panel z domami/hotelami */
	private JPanel estatePanel;
	/** label z nazwą miasta */
	private JLabel cityNameLabel;
	
	/**
	 * Konstruktor klasy
	 */
	
	CityView(String cityName)
	{
		super();
		cityNameLabel = new JLabel(cityName);
		add(cityNameLabel);
		estatePanel = new JPanel();
		estatePanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 32));
		estatePanel.setBackground(Color.yellow);
		add(estatePanel);
	}
}

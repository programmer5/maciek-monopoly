package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Klasa do reprezenatacji miasta
 * @author Maciej Sulek
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
	
	/** panel dla label'a */
	private JPanel cityNamePanel;
	
	/**
	 * Konstruktor klasy
	 */
	CityView(String cityName)
	{
		super();
		cityNameLabel = new JLabel(cityName);
		cityNamePanel = new JPanel();
		cityNamePanel.setBackground(Color.white);
		cityNamePanel.add(cityNameLabel);
		cityNamePanel.setPreferredSize(new Dimension(0,0));
		add(cityNamePanel);
		estatePanel = new JPanel();
		estatePanel.setBackground(Color.yellow);
		estatePanel.setMinimumSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
		estatePanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
		estatePanel.setMaximumSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
		estatePanel.setLayout(new BoxLayout(estatePanel, BoxLayout.X_AXIS));
		add(estatePanel);
	}
	
	/**
	 * zmiana nazwy miasta
	 * @param newName nowa nazwa miasta
	 */
	public void setCityName(String newName)
	{
		cityNameLabel.setText(newName);
	}
	
	public void addHouse()
	{
		estatePanel.add(new ImagePanel("data/house.jpg"));
	}
	
	public void addHotel()
	{
		estatePanel.removeAll();
		estatePanel.add(new ImagePanel("data/hotel.jpg"));
	}
}

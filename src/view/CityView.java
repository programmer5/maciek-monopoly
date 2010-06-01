package view;

import java.awt.Color;
import java.awt.Dimension;

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

}

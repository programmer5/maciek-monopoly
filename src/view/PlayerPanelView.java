package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * 
 * Klasa panelu gracza
 * @author Maciej Sulek
 *
 */

public class PlayerPanelView extends JPanel
{
	/** wygenerowane id */
	private static final long serialVersionUID = 3031295812883900352L;

	/** nazwa gracza */
	private JLabel playerName;
	
	/** posiadane pieniadze */
	private JLabel playerMoney;
	
	/**
	 * konstruktor klasy PlayerPanelView
	 */
	PlayerPanelView()
	{
		setOpaque(false);
		playerName = new JLabel("Gracz");
		playerMoney = new JLabel("0");
		add(playerName);
		add(playerMoney);
	}
	
	/**
	 * zmiana wyswietlanej nazwy gracza
	 * @param newPlayerName nowa nazwa gracza
	 */
	public void setPlayerName(String newPlayerName)	{ playerName.setText(newPlayerName); }
	
	/**
	 * zmiana wyswietlanych srodkow pienieznych
	 * @param newPlayerMoney nowe srodki pieniezne
	 */
	public void setPlayerMoney(String newPlayerMoney) { playerMoney.setText(newPlayerMoney); }
	
	/**
	 * zmiana podswietlenia
	 * @param value true - wlaczenie, false - wylaczenie
	 */
	public void setHighlight(boolean value)
	{
		if (value == true)
		{
			playerName.setForeground(Color.green);
			playerMoney.setForeground(Color.green);
			this.repaint();
		}
		else
		{
			playerName.setForeground(Color.black);
			playerMoney.setForeground(Color.black);
		}
	}
}

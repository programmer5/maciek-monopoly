package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * 
 * Klasa panelu gracza
 * 
 * @author Maciej Sulek
 * 
 */

public class PlayerPanelView extends JPanel
{
    /** wygenerowane id */
    private static final long serialVersionUID = 3031295812883900352L;

    /** nazwa gracza */
    private final JLabel playerName;

    /** posiadane pieniadze */
    private final JLabel playerMoney;

    /** przycisk wyswietlania dostepnych miast */
    private final JButton showPlayerCities;

    /**
     * konstruktor klasy PlayerPanelView
     */
    PlayerPanelView()
    {
        setOpaque(false);
        playerName = new JLabel("Gracz");
        playerName.setFont(new Font("Arial", Font.PLAIN, 22));
        playerMoney = new JLabel("0");
        playerMoney.setFont(new Font("Arial", Font.BOLD, 22));
        showPlayerCities = new JButton("Zobacz swoje miasta");
        showPlayerCities.setName("playerCities");
        add(playerName);
        add(playerMoney);
    }

    /**
     * zmiana wyswietlanej nazwy gracza
     * 
     * @param newPlayerName
     *            nowa nazwa gracza
     */
    public void setPlayerName(final String newPlayerName)
    {
        playerName.setText(newPlayerName);
    }

    /**
     * zmiana wyswietlanych srodkow pienieznych
     * 
     * @param newPlayerMoney
     *            nowe srodki pieniezne
     */
    public void setPlayerMoney(final String newPlayerMoney)
    {
        playerMoney.setText(newPlayerMoney);
    }

    /**
     * zmiana podswietlenia
     * 
     * @param value
     *            true - wlaczenie, false - wylaczenie
     */
    public void setHighlight(final boolean value)
    {
        if(value == true)
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

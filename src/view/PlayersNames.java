/**
 * 
 */
package view;

/**
 * Enum umozliwiajacy trzymanie nazw graczy
 * @author Maciej Sulek
 */
public enum PlayersNames 
{
	PLAYER1(""), PLAYER2(""), PLAYER3(""), PLAYER4("");
	
	/** nazwa gracza */
	private String playerName;
	
	/**
	 * Konstruktor typu
	 * @param playerName nazwa gracza
	 */
	private PlayersNames(String playerName)
	{
		this.playerName = playerName;
	}

	/**
	 * Pobranie nazwy graczy
	 * @return playerName nazwa gracza
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * Ustawienie nazwy gracza
	 * @param playerName nowa nazwa gracza
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}
}

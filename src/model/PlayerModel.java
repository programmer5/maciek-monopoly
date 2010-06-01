package model;

/**
 * 
 * Klasa gracza
 * @author Maciej Sulek
 *
 */
public class PlayerModel
{
	/** saldo gracza */
	private int saldo;
	
	/**
	 * Zwraca saldo
	 * @return saldo
	 */
	public int getSaldo() 
	{
		return saldo;
	}

	/**
	 * Ustawia saldo
	 * @param saldo nowe saldo
	 */
	public void setSaldo(int saldo) 
	{
		this.saldo = saldo;
	}

	/**
	 * Konstruktor klasy PlayerModel
	 */
	PlayerModel()
	{
		saldo = 15000;
	}
}

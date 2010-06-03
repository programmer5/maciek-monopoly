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
	
	/** ilosc kolejek do czekania */
	private int mustStay;
	
	/**
	 * Pobranie ilosci kolejek do czekania
	 * @return mustStay ile kolejek jeszcze musi czekac
	 */
	public int getMustStay() 
	{
		return mustStay;
	}

	/**
	 * Zmiana ilosci kolejek do czekania
	 * @param mustStay ilosc kolejek do czekania
	 */
	public void setMustStay(int mustStay)
	{
		this.mustStay = mustStay;
	}
	
	/**
	 * Zmniejszanie o jeden kolejek do czekania
	 */
	public void incMustStay()
	{
		--this.mustStay;
	}

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
	 * Zmienia saldo o zadana wartosc
	 * @param value wartosc zmiany
	 */
	public void changeSaldo(int value)
	{
		this.saldo = this.saldo + value;
	}
	
	/**
	 * Konstruktor klasy PlayerModel
	 */
	PlayerModel()
	{
		mustStay = 0;
		saldo = 15000;
	}
}

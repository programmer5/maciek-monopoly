package view;

/**
 * Klasa udostepniajaca funkcje zmiany widoku
 * @author Maciej Sulek
 */
public class ViewChanger 
{
	private View mainView;
	
	/**
	 * Konstruktor klasy ViewChanger
	 * @param _mainView
	 */
	public ViewChanger(View _mainView)
	{
		mainView = _mainView;
	}
	
	/**
	 * Przenoszenie pionka
	 * @param checkerNumber numer pionka
	 * @param fieldNumber numer pola
	 * @param newFieldNumber numer nowego pola
	 */
	public void moveChecker(int checkerNumber, int fieldNumber, int newFieldNumber)
	{
		mainView.moveChecker(checkerNumber, fieldNumber, newFieldNumber);
	}
	
	/**
	 * Ustawianie pieniedzy gracza przy nowej grze
	 * @param newPlayerMoney ilosc pieniedzy
	 */
	public void newGamePlayerMoney(int newPlayerMoney)
	{
		mainView.newGamePlayerMoney(newPlayerMoney);
	}
	
	/**
	 * Aktualizacja pieniedzy gracza
	 * @param playerNumber numer gracza
	 * @param newPlayerMoney nowa ilosc pieniedzy
	 */
	public void newPlayerMoney(int playerNumber, int newPlayerMoney)
	{
		mainView.newPlayerMoney(playerNumber, newPlayerMoney);
	}
	
	/**
	 * Zmiana stanu przycisku do rzucania kostka
	 */
	public void changeRollDiceButtonState()
	{
		mainView.changeRollDiceButtonState();
	}
	
	/**
	 * Uaktywnienie przyciskow do gry
	 */
	public void enableButtons()
	{
		mainView.enableButtons();
	}
	
	/** 
	 * Uaktualnianie wylosowanej liczby oczek kostki
	 * @param diceResult liczba oczek
	 */
	public void setDiceResult(int diceResult)
	{
		mainView.setDiceResult(diceResult);
	}
	
	/**
	 * Zmiany widoku wynikajace ze zmiany gracza
	 * @param actPlayer aktualny gracz
	 * @param nextPlayer numer nastepnego gracza
	 */
	public void nextPlayer(int actPlayer, int nextPlayer)
	{
		mainView.nextPlayer(actPlayer, nextPlayer);
	}
}

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
	public void setPlayerMoney(int playerNumber, int newPlayerMoney)
	{
		mainView.setPlayerMoney(playerNumber, newPlayerMoney);
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
	
	/**
	 * Zmiana widocznosci okna nowej gry
	 * @param decison nowa wartosc widocznosci okna
	 */
	public void setNewGameVisible(boolean decison)
	{
		mainView.setNewGameVisible(decison);
	}
	
	/**
	 * Pobranie nazw graczy 
	 * @return tablica z nazwami graczy
	 */
	public String[] getNewGamePlayersNames()
	{
		return mainView.getPlayersNames();
	}
	
	/**
	 * Ustawia nazwy graczy widoczne w grze
	 * @param playersNames tablica z nazwami uzytkownikow
	 */
	public void setGamePlayersNames(String[] playersNames)
	{
		mainView.setGamePlayersNames(playersNames);
	}
	
	/**
	 * Wyswietlanie dialgow na oknie nowej nazwy
	 * @param text tekst wiadomosci
	 * @param title tytul okna
	 */
	public void showNewGameDialog(String text, String title)
	{
		mainView.showNewGameDialog(text, title);
	}
	
	/**
	 * Wyswietlanie dialgow na oknie glownym
	 * @param text tekst wiadomosci
	 * @param title tytul okna
	 */
	public void showGameDialog(String text, String title)
	{
		mainView.showGameDialog(text, title);
	}
	
	/**
	 * Wlaczanie/wylaczanie podswietlenia gracza
	 * @param playerNumber numer gracza
	 * @param value true - wlacz podswietlenie, false - wylacz podswietlenie
	 */
	public void setPlayerHighlight(int playerNumber, boolean value)
	{
		mainView.setPlayerHighlight(playerNumber, value);
	}
	
	/**
	 * Zmiana widocznosci panelu gracza
	 * @param player number numer gracza
	 * @param value true - pokaz, false - ukryj
	 */
	public void setPlayerPanelVisible(int playerNumber, boolean value)
	{
		mainView.setPlayerPanelVisible(playerNumber, value);
	}
	
	/**
	 * Ustawianie pionka na poczatku
	 * @param playerNumber numer gracza
	 */
	public void newGameCheckersState(int playerNumber)
	{
		mainView.newGameCheckersState(playerNumber);
	}
	
	/**
	 * Zmiana widocznosci okna CityInfoView
	 * @param value nowa wartosc
	 */
	public void setVisibleCityInfoView(boolean value)
	{
		mainView.setVisibleCityInfoView(value);
	}
	
	/**
	 * Aktualizacja parametrow okna CityInfoView
	 * @param allParams tablica z wszystkimi atrybutami w nastepujacej kolejnosci:
	 * cityName, cityPrice, houseCost, hotelCost, owner, stayCost, stayCost1, stayCost2, stayCost3, stayCostHotel
	 */
	public void updateAllCityInfoView(String[] allParams)
	{
		mainView.updateAllCityInfoView(allParams);
	}
	
	/**
	 * Zmiana nazwy miasta
	 * @param cityNumber numer miasta
	 * @param cityName nowa nazwa
	 */
	public void setCityName(int cityNumber, String cityName)
	{
		mainView.setCityName(cityNumber, cityName);
	}
	
	
	/**
	 * Zmiana stanu przyciskow rollDice oraz endTurn
	 * @param rollDiceValue wartosc dostepnosci przycisku rollDiceButton
	 * @param endTurnValue wartosc dostepnosci przycisku endTurnValue
	 */
	public void changeGameButtonsState(boolean rollDiceValue, boolean endTurnValue)
	{
		mainView.changeGameButtonsState(rollDiceValue, endTurnValue);
	}
	
	/**
	 * Zmiana dostepnosci przycisku buyCityButton
	 * @param value ustwiana wartosc
	 */
	public void changeBuyCityButtonState(boolean value)
	{
		mainView.changeBuyCityButtonState(value);
	}
	
	/**
	 * Zmiana dostepnosci wymienionych przyciskow
	 * @param city przycisk buyCityButton
	 * @param house przycisk buyHouseButton
	 * @param hotel przycisk buyHotelButton
	 */
	public void setBuyButtonsEnabled(boolean city, boolean house, boolean hotel)
	{
		mainView.setBuyButtonsEnabled(city, house, hotel);
	}
	
	/**
	 * Ustawianie koloru pola dla pionkow, aby rozroznic dzielnice
	 * @param fieldNumber numer pola
	 * @param district numer dzielincy
	 */
	public void setFieldCheckerPanelColor(int fieldNumber, int district)
	{
		mainView.setFieldCheckerPanelColor(fieldNumber, district);
	}
	
	/**
	 * Dodawanie domu do miasta
	 * @param cityNumber numer miasta
	 */
	public void addHouseToCity(int cityNumber)
	{
		mainView.addHouseToCity(cityNumber);
	}
	
	/**
	 * Dodawanie hotelu do miasta
	 * @param cityNumber numer miasta
	 */
	public void addHotelToCity(int cityNumber)
	{
		mainView.addHotelToCity(cityNumber);
	}
	
	/**
	 * Wylaczenie wszystkich przyciskow
	 */
	public void allButtonsEnableFalse()
	{
		mainView.allButtonsEnableFalse();
	}
}

package view;

/**
 * Klasa udostepniajaca funkcje zmiany widoku
 * 
 * @author Maciej Sulek
 */
public class ViewChanger
{
    private final View mainView;

    /**
     * Konstruktor klasy ViewChanger
     * 
     * @param _mainView
     */
    public ViewChanger(final View _mainView)
    {
        mainView = _mainView;
    }

    /**
     * Przenoszenie pionka
     * 
     * @param checkerNumber
     *            numer pionka
     * @param fieldNumber
     *            numer pola
     * @param newFieldNumber
     *            numer nowego pola
     */
    public void moveChecker(final int checkerNumber, final int fieldNumber, final int newFieldNumber)
    {
        mainView.moveChecker(checkerNumber, fieldNumber, newFieldNumber);
    }

    /**
     * Ustawianie pieniedzy gracza przy nowej grze
     * 
     * @param newPlayerMoney
     *            ilosc pieniedzy
     */
    public void newGamePlayerMoney(final int newPlayerMoney)
    {
        mainView.newGamePlayerMoney(newPlayerMoney);
    }

    /**
     * Aktualizacja pieniedzy gracza
     * 
     * @param playerNumber
     *            numer gracza
     * @param newPlayerMoney
     *            nowa ilosc pieniedzy
     */
    public void setPlayerMoney(final int playerNumber, final int newPlayerMoney)
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
     * 
     * @param diceResult
     *            liczba oczek
     */
    public void setDiceResult(final int diceResult)
    {
        mainView.setDiceResult(diceResult);
    }

    /**
     * Zmiany widoku wynikajace ze zmiany gracza
     * 
     * @param actPlayer
     *            aktualny gracz
     * @param nextPlayer
     *            numer nastepnego gracza
     */
    public void nextPlayer(final int actPlayer, final int nextPlayer)
    {
        mainView.nextPlayer(actPlayer, nextPlayer);
    }

    /**
     * Zmiana widocznosci okna nowej gry
     * 
     * @param decison
     *            nowa wartosc widocznosci okna
     */
    public void setNewGameVisible(final boolean decison)
    {
        mainView.setNewGameVisible(decison);
    }

    /**
     * Pobranie nazw graczy
     * 
     * @return tablica z nazwami graczy
     */
    public String[] getNewGamePlayersNames()
    {
        return mainView.getPlayersNames();
    }

    /**
     * Ustawia nazwy graczy widoczne w grze
     * 
     * @param playersNames
     *            tablica z nazwami uzytkownikow
     */
    public void setGamePlayersNames(final String[] playersNames)
    {
        mainView.setGamePlayersNames(playersNames);
    }

    /**
     * Wyswietlanie dialgow na oknie nowej nazwy
     * 
     * @param text
     *            tekst wiadomosci
     * @param title
     *            tytul okna
     */
    public void showNewGameDialog(final String text, final String title)
    {
        mainView.showNewGameDialog(text, title);
    }

    /**
     * Wyswietlanie dialgow na oknie glownym
     * 
     * @param text
     *            tekst wiadomosci
     * @param title
     *            tytul okna
     */
    public void showGameDialog(final String text, final String title)
    {
        mainView.showGameDialog(text, title);
    }

    /**
     * Wlaczanie/wylaczanie podswietlenia gracza
     * 
     * @param playerNumber
     *            numer gracza
     * @param value
     *            true - wlacz podswietlenie, false - wylacz podswietlenie
     */
    public void setPlayerHighlight(final int playerNumber, final boolean value)
    {
        mainView.setPlayerHighlight(playerNumber, value);
    }

    /**
     * Zmiana widocznosci panelu gracza
     * 
     * @param player
     *            number numer gracza
     * @param value
     *            true - pokaz, false - ukryj
     */
    public void setPlayerPanelVisible(final int playerNumber, final boolean value)
    {
        mainView.setPlayerPanelVisible(playerNumber, value);
    }

    /**
     * Ustawianie pionka na poczatku
     * 
     * @param playerNumber
     *            numer gracza
     */
    public void newGameCheckersState(final int playerNumber)
    {
        mainView.newGameCheckersState(playerNumber);
    }

    /**
     * Zmiana widocznosci okna CityInfoView
     * 
     * @param value
     *            nowa wartosc
     */
    public void setVisibleCityInfoView(final boolean value)
    {
        mainView.setVisibleCityInfoView(value);
    }

    /**
     * Aktualizacja parametrow okna CityInfoView
     * 
     * @param allParams
     *            tablica z wszystkimi atrybutami w nastepujacej kolejnosci:
     *            cityName, cityPrice, houseCost, hotelCost, owner, stayCost,
     *            stayCost1, stayCost2, stayCost3, stayCostHotel
     */
    public void updateAllCityInfoView(final String[] allParams)
    {
        mainView.updateAllCityInfoView(allParams);
    }

    /**
     * Zmiana nazwy miasta
     * 
     * @param cityNumber
     *            numer miasta
     * @param cityName
     *            nowa nazwa
     */
    public void setCityName(final int cityNumber, final String cityName)
    {
        mainView.setCityName(cityNumber, cityName);
    }

    /**
     * Zmiana stanu przyciskow rollDice oraz endTurn
     * 
     * @param rollDiceValue
     *            wartosc dostepnosci przycisku rollDiceButton
     * @param endTurnValue
     *            wartosc dostepnosci przycisku endTurnValue
     */
    public void changeGameButtonsState(final boolean rollDiceValue, final boolean endTurnValue)
    {
        mainView.changeGameButtonsState(rollDiceValue, endTurnValue);
    }

    /**
     * Zmiana dostepnosci przycisku buyCityButton
     * 
     * @param value
     *            ustwiana wartosc
     */
    public void changeBuyCityButtonState(final boolean value)
    {
        mainView.changeBuyCityButtonState(value);
    }

    /**
     * Zmiana dostepnosci wymienionych przyciskow
     * 
     * @param city
     *            przycisk buyCityButton
     * @param house
     *            przycisk buyHouseButton
     * @param hotel
     *            przycisk buyHotelButton
     */
    public void setBuyButtonsEnabled(final boolean city, final boolean house, final boolean hotel)
    {
        mainView.setBuyButtonsEnabled(city, house, hotel);
    }

    /**
     * Ustawianie koloru pola dla pionkow, aby rozroznic dzielnice
     * 
     * @param fieldNumber
     *            numer pola
     * @param district
     *            numer dzielincy
     */
    public void setFieldCheckerPanelColor(final int fieldNumber, final int district)
    {
        mainView.setFieldCheckerPanelColor(fieldNumber, district);
    }

    /**
     * Dodawanie domu do miasta
     * 
     * @param cityNumber
     *            numer miasta
     */
    public void addHouseToCity(final int cityNumber)
    {
        mainView.addHouseToCity(cityNumber);
    }

    /**
     * Dodawanie hotelu do miasta
     * 
     * @param cityNumber
     *            numer miasta
     */
    public void addHotelToCity(final int cityNumber)
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

    /**
     * Pobranie numeru pola najechanego myszka
     * 
     * @return actField aktualne pole
     */
    public int getActField()
    {
        return mainView.getActField();
    }

}

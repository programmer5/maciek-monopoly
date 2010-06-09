package pl.edu.pw.elka.proz.msulek.model;

import java.io.*;

/**
 * Klasa odpowiedzialna za model gry
 * 
 * @author Maciej Sułek
 */
public class Model
{
    /** zbior pol */
    private final FieldModel fields[];
    /** liczba graczy */
    private int playerNumber;
    /** zbior graczy */
    private final PlayerModel players[];
    /** zbior pionkow */
    private final CheckerModel checkers[];
    /** aktualny gracz */
    private int currentPlayer;
    /** saldo przypisywane na poczatku gry */
    private final int SALDO = 3000;

    /**
     * Konstruktor klasy model
     */
    public Model()
    {
        fields = new FieldModel[30];
        players = new PlayerModel[4];
        checkers = new CheckerModel[4];
        playerNumber = 0;
        currentPlayer = 0;
    }

    /**
     * Inicjalizacja modelu
     * 
     */
    public void initialize()
    {
        int readLine = 0;
        try
        {
            final FileReader fCities = new FileReader("data/cities.cfg");
            final BufferedReader rCities = new BufferedReader(fCities);
            CityModel tmpCity;
            String strLine, tmpCityName;
            int tmpCityNumber;
            final int params[] = new int[9];
            for (int i = 0; i < 15; ++i)
            {
                // czytanie numeru polu
                strLine = rCities.readLine();
                if(strLine == null)
                {
                    throw new Exception("Błąd numeru miasta");
                }
                tmpCityNumber = Integer.parseInt(strLine);
                ++readLine;
                // czytanie nazwy miasta
                strLine = rCities.readLine();
                if(strLine == null)
                {
                    throw new Exception("Błąd nazwy miasta");
                }
                tmpCityName = strLine;
                ++readLine;
                // czytanie pozostałych parametrów
                for (int j = 0; j < 9; ++j)
                {
                    strLine = rCities.readLine();
                    if(strLine == null)
                    {
                        throw new Exception("Błąd parametru " + j);
                    }
                    params[j] = Integer.parseInt(strLine);
                    ++readLine;
                }
                tmpCity = new CityModel();
                tmpCity.updateAll(tmpCityName, params);
                fields[tmpCityNumber] = tmpCity;
            }
            fCities.close();
            if(readLine != 165)
            {
                throw new Exception("Błąd ilości lini");
            }
        }
        catch (final Exception e)
        {
            System.out.println("Błąd odczytu pliku - linia: " + (readLine + 1) + " - " + e.getMessage());
            System.exit(0);
        }
        // ladowanie pol specjalnych
        fields[0] = new SpecialFieldModel("Start", SpecialFieldModel.START_BONUS, 1500);
        fields[3] = new SpecialFieldModel("Szansa", SpecialFieldModel.CHANCE);
        fields[5] = new TrainModel("Koleje zachodnie");
        fields[7] = new SpecialFieldModel("GoToJail", SpecialFieldModel.GO_TO_JAIL);
        fields[10] = new SpecialFieldModel("Ryzyko", SpecialFieldModel.RISK);
        fields[12] = new TrainModel("Koleje północne");
        fields[14] = new SpecialFieldModel("Parking", SpecialFieldModel.NOTHING);
        fields[16] = new SpecialFieldModel("Szansa", SpecialFieldModel.CHANCE);
        fields[18] = new TrainModel("Koleje wschodnie");
        fields[19] = new SpecialFieldModel("Płacisz podatek", SpecialFieldModel.FEE, 250);
        fields[21] = new SpecialFieldModel("Odwiedasz więzienie", SpecialFieldModel.NOTHING);
        fields[24] = new TrainModel("Koleje południowe");
        fields[26] = new SpecialFieldModel("Ryzyko", SpecialFieldModel.RISK);
        for (int i = 0; i < 4; ++i)
        {
            checkers[i] = new CheckerModel();
            players[i] = new PlayerModel();
            players[i].setSaldo(SALDO);
        }
    }

    /**
     * Pobranie gracza
     * 
     * @param playerNumber numer gracza
     * @return player gracz
     */
    public PlayerModel getPlayer(final int playerNumber)
    {
        return players[playerNumber];
    }

    /**
     * Pobranie obiektu pionka
     * 
     * @param checkerNumber numer pionka
     * @return checker pionek
     */
    public CheckerModel getChecker(final int checkerNumber)
    {
        return checkers[checkerNumber];
    }

    /**
     * Pobranie pola
     * 
     * @param fieldNumber
     *            numer pola
     * @return field pole
     */
    public FieldModel getField(final int fieldNumber)
    {
        return fields[fieldNumber];
    }

    /**
     * Pobranie liczby graczy
     * 
     * @return playerNumber liczba graczy
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }

    /**
     * Zmiana liczby graczy
     * 
     * @param playerNumber
     *            nowa liczba graczy
     */
    public void setPlayerNumber(final int playerNumber)
    {
        this.playerNumber = playerNumber;
    }

    /**
     * Pobranie aktualnego gracza
     * 
     * @return aktualny gracz
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * @param currentPlayer
     *            nowy aktualny gracz
     */
    public void setCurrentPlayer(final int currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Nastepny gracz
     * 
     * @return nextPlayer nastepny gracz
     */
    public int nextPlayer()
    {
        return (currentPlayer = (currentPlayer + 1) % playerNumber);
    }

    /**
     * pobranie aktualnego konta gracza
     * 
     * @param playerNumber
     *            numer gracza
     * @return saldo saldo gracza
     */
    public int getPlayerSaldo(final int playerNumber)
    {
        return players[playerNumber].getSaldo();
    }

    /**
     * Zwraca numer wlasciciela (1-4) lub ze miasto do kupienia (0)
     * 
     * @param cityNumber
     * @return
     */
    public short whoIsThisCity(final int cityNumber)
    {
        if(fields[cityNumber] instanceof CityModel)
        {
            final short forReturn = ((CityModel) fields[cityNumber]).getCityStatus();
            return forReturn;
        }
        else if(fields[cityNumber] instanceof TrainModel)
        {
            final short forReturn = ((TrainModel) fields[cityNumber]).getOwner();
            return forReturn;
        }
        return -1;
    }

    /**
     * Zmiana wlasciciela
     * 
     * @param cityNumber
     *            numer miasta/koleji
     * @param owner
     *            numer wlasciciela
     */
    public void setCityOwner(final int cityNumber, final short owner)
    {
        if(fields[cityNumber] instanceof CityModel)
        {
            ((CityModel) fields[cityNumber]).setOwner(owner);
        }
        else if(fields[cityNumber] instanceof TrainModel)
        {
            ((TrainModel) fields[cityNumber]).setOwner(owner);
        }
    }

    /**
     * Sprawdza czy gracz posiada posiada dzielnice lub ile dworcow kolejowych
     * posiada
     * 
     * @param fieldNumber
     *            numer pola
     * @param who
     *            domniemany wlasciciel
     * @return number posiada 1 jesli ma dzielnice lub ilosc dworcow kolejowych
     */
    public int playerHasDistrict(final int fieldNumber, final short who)
    {
        int number = 1;
        if(fields[fieldNumber] instanceof CityModel)
        {
            final int searchDistrict = ((CityModel) fields[fieldNumber]).getDistrict();
            for (int i = 0; i < 28; ++i)
            {
                if(fields[i] instanceof CityModel)
                {
                    if(((CityModel) fields[i]).getDistrict() == searchDistrict && ((CityModel) fields[i]).getOwner() != who)
                    {
                        return 0;
                    }
                }
            }
            return 1;
        }
        else if(fields[fieldNumber] instanceof TrainModel)
        {
            for (int i = 0; i < 28; ++i)
            {
                if(fields[i] instanceof TrainModel)
                {
                    if(((TrainModel) fields[i]).getOwner() == who)
                    {
                        ++number;
                    }
                }
            }
            return number;
        }
        return -1;
    }

    /**
     * Rozpoczynanie nowej gry
     */
    public void newGame()
    {
        for (int i = 0; i < 4; ++i)
        {
            players[i].setSaldo(SALDO);
            players[i].setMustStay(0);
            checkers[i].setFieldNumber(0);
        }
        for (int i = 0; i < 28; ++i)
        {
            if(fields[i] instanceof CityModel)
            {
                ((CityModel) fields[i]).setCityOwner((short) 0);
            }
            else if(fields[i] instanceof TrainModel)
            {
                ((TrainModel) fields[i]).setOwner((short) 0);
            }
        }
        currentPlayer = 0;
    }
}

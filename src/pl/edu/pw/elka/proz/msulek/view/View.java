package pl.edu.pw.elka.proz.msulek.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.controller.listeners.*;

/**
 * Klasa widoku
 * 
 * @author Maciej Sulek
 */
public class View
{
    /** przechowuje widok planszy */
    private final BoardView mainboard;

    /** przechowuje pola */
    private final FieldView field[];

    /** przechowuje panele gracza */
    private final PlayerPanelView playerPanel[];

    /** przechowuje zbior pionkow */
    private final ImagePanel checkers[];

    /** przycisk rozpoczynający nową grę */
    private final JButton newGameButton;

    /** przycisk zamykający grę */
    private final JButton closeGameButton;

    /** przycisk rzucania kostką */
    private final JButton rollDiceButton;

    /** przycisk kupowania miasta */
    private final JButton buyCityButton;

    /** przycisk kupowania domu */
    private final JButton buyHouseButton;

    /** przycisk kupowania hotelu */
    private final JButton buyHotelButton;

    /** zakonczenie tury */
    private final JButton endTurnButton;

    /** wynik rzutu kostka */
    private final JLabel diceResult;

    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /** okno nowej gry */
    private final NewGameView newGameView;

    /** okno informacji o miescie */
    private final CityInfoView cityInfoView;

    /** panel menu */
    private final JPanel menuPanel;

    /** lewy panel w menu */
    private final JPanel menuPanelLeft;

    /** prawy panel w menu */
    private final JPanel menuPanelRight;

    /** srodkowy panel w menu */
    private final JPanel menuPanelCenter;

    /** kolory dzielnic */
    private final Color[] districtColors;

    /** aktualne pole */
    private final int actField[];

    /**
     * Konstruktor klasy View
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public View(final BlockingQueue<ExtendEvent> queue)
    {
        final String plaf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
        try
        {
            UIManager.setLookAndFeel(plaf);
        }
        catch (final ClassNotFoundException e)
        {
            e.printStackTrace();
            System.err.println("Blad podczas proby zmiany wygladu na systemowy.");
        }
        catch (final InstantiationException e)
        {
            e.printStackTrace();
            System.err.println("Blad podczas proby zmiany wygladu na systemowy.");
        }
        catch (final IllegalAccessException e)
        {
            e.printStackTrace();
            System.err.println("Blad podczas proby zmiany wygladu na systemowy.");
        }
        catch (final UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
            System.err.println("Blad podczas proby zmiany wygladu na systemowy.");
        }
        this.queue = queue;
        mainboard = new BoardView(queue);
        mainboard.setLayout(new BorderLayout(2, 2));
        field = new FieldView[28];
        for (int i = 0; i < 28; ++i)
        {
            field[i] = new CityView("Warszawa" + i);
        }
        field[0] = new StartView();
        field[3] = new ChanceView();
        field[5] = new TrainView();
        field[7] = new GoToJailView();
        field[10] = new RiskView();
        field[12] = new TrainView();
        field[14] = new OtherView("data/freepark.jpg");
        field[16] = new ChanceView();
        field[18] = new TrainView();
        field[19] = new PayFeeView();
        field[21] = new OtherView("data/jail.jpg");
        field[24] = new TrainView();
        field[26] = new RiskView();
        playerPanel = new PlayerPanelView[4];
        for (int i = 0; i < 4; ++i)
        {
            playerPanel[i] = new PlayerPanelView();
        }
        playerPanel[0].setPlayerName("Gracz pierwszy");
        playerPanel[1].setPlayerName("Gracz drugi");
        playerPanel[2].setPlayerName("Gracz trzeci");
        playerPanel[3].setPlayerName("Gracz czwarty");
        // ustawianie przyciskow gry
        newGameButton = new JButton("Nowa gra");
        newGameButton.addActionListener(new ExtendNewGameListener(queue));
        closeGameButton = new JButton("Zakończ");
        closeGameButton.addActionListener(new ExtendCloseGameListener(queue));
        newGameView = new NewGameView(queue);
        cityInfoView = new CityInfoView(queue);
        // ustawianie paneli gry
        menuPanel = new JPanel();
        menuPanelLeft = new JPanel();
        menuPanelRight = new JPanel();
        menuPanelCenter = new JPanel();
        menuPanel.setOpaque(false);
        menuPanelLeft.setOpaque(false);
        menuPanelRight.setOpaque(false);
        menuPanelCenter.setOpaque(false);
        // tworzenie przyciskow
        rollDiceButton = new JButton("Rzuc kostka!");
        rollDiceButton.addActionListener(new ExtendRollDiceListener(queue));
        rollDiceButton.setEnabled(false);
        diceResult = new JLabel("1");
        diceResult.setFont(new Font("Arial", Font.BOLD, 20));
        diceResult.setPreferredSize(new Dimension(20, 20));
        buyCityButton = new JButton("Kupuję!");
        buyCityButton.addActionListener(new ExtendBuyCityListener(queue));
        buyCityButton.setEnabled(false);
        buyHouseButton = new JButton("Kup dom");
        buyHouseButton.addActionListener(new ExtendBuyHouseListener(queue));
        buyHouseButton.setEnabled(false);
        buyHotelButton = new JButton("Kup hotel");
        buyHotelButton.addActionListener(new ExtendBuyHotelListener(queue));
        buyHotelButton.setEnabled(false);
        endTurnButton = new JButton("Zakoncz ture");
        endTurnButton.addActionListener(new ExtendEndTurnListener(queue));
        endTurnButton.setEnabled(false);
        rollDiceButton.setPreferredSize(endTurnButton.getPreferredSize());
        // inicjalizacja kolorow dzielnic
        districtColors = new Color[10];
        // inicjalizacja pionkow
        checkers = new ImagePanel[4];
        actField = new int[1];
        actField[0] = 0;
    }

    /**
     * Funkcja aktywująca potrzebne komponenty
     */
    public void start()
    {
        mainboard.start();
        for (int i = 6; i >= 1; --i)
        {
            mainboard.addToLeftPanel(field[i]);
            field[i].setName(String.valueOf(i));
            field[i].addMouseMotionListener(new ExtendMouseMotion(queue, i, actField));
        }
        for (int i = 7; i <= 14; ++i)
        {
            mainboard.addToTopPanel(field[i]);
            field[i].setName(String.valueOf(i));
            field[i].addMouseMotionListener(new ExtendMouseMotion(queue, i, actField));
        }
        for (int i = 15; i <= 20; ++i)
        {
            mainboard.addToRightPanel(field[i]);
            field[i].setName(String.valueOf(i));
            field[i].addMouseMotionListener(new ExtendMouseMotion((queue), i, actField));
        }
        mainboard.addToBottomPanel(field[0]);
        field[0].setName(String.valueOf(0));
        field[0].addMouseMotionListener(new ExtendMouseMotion(queue, 0, actField));
        for (int i = 27; i >= 21; --i)
        {
            mainboard.addToBottomPanel(field[i]);
            field[i].setName(String.valueOf(i));
            field[i].addMouseMotionListener(new ExtendMouseMotion(queue, i, actField));
        }
        menuPanel.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 4; ++i)
        {
            mainboard.addToGamePanel(playerPanel[i]);
        }
        menuPanel.add(menuPanelLeft);
        menuPanel.add(menuPanelCenter);
        menuPanel.add(menuPanelRight);
        menuPanelLeft.add(diceResult);
        menuPanelLeft.add(rollDiceButton);
        menuPanelLeft.add(endTurnButton);
        menuPanelLeft.add(buyCityButton);
        menuPanelLeft.add(buyHouseButton);
        menuPanelLeft.add(buyHotelButton);
        menuPanelRight.add(newGameButton);
        menuPanelRight.add(closeGameButton);
        mainboard.addToGamePanel(menuPanel);
        checkers[0] = new ImagePanel("data/checker1.gif");
        checkers[1] = new ImagePanel("data/checker2.gif");
        checkers[2] = new ImagePanel("data/checker3.gif");
        checkers[3] = new ImagePanel("data/checker4.gif");
        // wybor kolorow
        districtColors[0] = Color.blue;
        districtColors[1] = Color.cyan;
        districtColors[2] = Color.green;
        districtColors[3] = Color.magenta;
        districtColors[4] = Color.orange;
        districtColors[5] = Color.pink;
        districtColors[6] = Color.yellow;
        districtColors[7] = Color.red;
        districtColors[8] = Color.black;
        // pelny ekran
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice gs = ge.getDefaultScreenDevice();
        gs.setFullScreenWindow(mainboard);
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
        field[fieldNumber].removeChecker(checkers[checkerNumber]);
        field[newFieldNumber].addChecker(checkers[checkerNumber]);
        field[fieldNumber].repaint();
        field[newFieldNumber].repaint();
    }

    /**
     * Ustawianie pieniedzy gracza przy nowej grze
     * 
     * @param newPlayerMoney
     *            ilosc pieniedzy
     */
    public void newGamePlayerMoney(final int newPlayerMoney)
    {
        playerPanel[0].setPlayerMoney(String.valueOf(newPlayerMoney));
        playerPanel[1].setPlayerMoney(String.valueOf(newPlayerMoney));
        playerPanel[2].setPlayerMoney(String.valueOf(newPlayerMoney));
        playerPanel[3].setPlayerMoney(String.valueOf(newPlayerMoney));
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
        playerPanel[playerNumber].setPlayerMoney(String.valueOf(newPlayerMoney));
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
        rollDiceButton.setVisible(rollDiceValue);
        endTurnButton.setVisible(endTurnValue);
    }

    /**
     * Zmiana dostepnosci przycisku buyCityButton
     * 
     * @param value
     *            ustwiana wartosc
     */
    public void changeBuyCityButtonState(final boolean value)
    {
        buyCityButton.setEnabled(value);
    }

    /**
     * Uaktywnienie przyciskow do gry
     */
    public void enableButtons()
    {
        rollDiceButton.setEnabled(true);
        rollDiceButton.setVisible(true);
        buyCityButton.setEnabled(false);
        buyHouseButton.setEnabled(false);
        buyHotelButton.setEnabled(false);
        endTurnButton.setEnabled(true);
        endTurnButton.setVisible(false);
    }

    /**
     * Uaktualnianie wylosowanej liczby oczek kostki
     * 
     * @param diceResult
     *            liczba oczek
     */
    public void setDiceResult(final int diceResult)
    {
        this.diceResult.setText(String.valueOf(diceResult));
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
        playerPanel[actPlayer].setHighlight(false);
        playerPanel[nextPlayer].setHighlight(true);
    }

    /**
     * Zmiana widocznosci okna nowej gry
     * 
     * @param decison
     *            nowa wartosc widocznosci okna
     */
    public void setNewGameVisible(final boolean decison)
    {
        newGameView.setVisible(decison);
    }

    /**
     * Pobranie nazwy uzytkownikow
     * 
     * @return playersNames tablica z nazwami graczy
     */
    public String[] getPlayersNames()
    {
        final String[] playersNames = new String[4];
        playersNames[0] = new String(newGameView.getFirstPlayer());
        playersNames[1] = new String(newGameView.getSecondPlayer());
        playersNames[2] = new String(newGameView.getThirdPlayer());
        playersNames[3] = new String(newGameView.getFourthPlayer());
        return playersNames;
    }

    /**
     * Ustawia nazwy graczy widoczne w grze
     * 
     * @param playersNames
     *            tablica z nazwami uzytkownikow
     */
    public void setGamePlayersNames(final String[] playersNames)
    {
        playerPanel[0].setPlayerName(playersNames[0]);
        playerPanel[1].setPlayerName(playersNames[1]);
        playerPanel[2].setPlayerName(playersNames[2]);
        playerPanel[3].setPlayerName(playersNames[3]);
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
        JOptionPane.showMessageDialog(mainboard, text, title, JOptionPane.ERROR_MESSAGE);
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
        JOptionPane.showMessageDialog(mainboard, text, title, JOptionPane.INFORMATION_MESSAGE);
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
        playerPanel[playerNumber].setHighlight(value);
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
        playerPanel[playerNumber].setVisible(value);
    }

    /**
     * Ustawianie pionka na poczatku
     * 
     * @param playerNumber
     *            numer gracza
     */
    public void newGameCheckersState(final int playerNumber)
    {
        field[0].addChecker(checkers[playerNumber]);
        field[0].repaint();
    }

    /**
     * Zmiana widocznosci okna CityInfoView
     * 
     * @param value
     *            nowa wartosc
     */
    public void setVisibleCityInfoView(final boolean value)
    {
        cityInfoView.setVisible(value);
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
        cityInfoView.updateAll(allParams);
    }

    public void setCityName(final int cityNumber, final String cityName)
    {
        ((CityView) field[cityNumber]).setCityName(cityName);
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
        buyCityButton.setEnabled(city);
        buyHouseButton.setEnabled(house);
        buyHotelButton.setEnabled(hotel);
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
        field[fieldNumber].checkerPanel.setBackground(districtColors[district - 1]);
    }

    /**
     * Dodawanie domu do miasta
     * 
     * @param cityNumber
     *            numer miasta
     */
    public void addHouseToCity(final int cityNumber)
    {
        ((CityView) field[cityNumber]).addHouse();
        field[cityNumber].revalidate();
    }

    /**
     * Dodawanie hotelu do miasta
     * 
     * @param cityNumber
     *            numer miasta
     */
    public void addHotelToCity(final int cityNumber)
    {
        ((CityView) field[cityNumber]).addHotel();
        field[cityNumber].revalidate();
    }

    /**
     * Wylaczenie wszystkich przyciskow
     */
    public void allButtonsEnableFalse()
    {
        rollDiceButton.setEnabled(false);
        endTurnButton.setEnabled(false);
        buyCityButton.setEnabled(false);
        buyHotelButton.setEnabled(false);
        buyHouseButton.setEnabled(false);
    }

    /**
     * Pobranie aktualnego pola
     * 
     * @return actField aktualne pole najechane myszka
     */
    public int getActField()
    {
        return actField[0];
    }

    /**
     * Przygotowanie do nowej gry
     */
    public void newGame()
    {
        setPlayerHighlight(0, false);
        setPlayerHighlight(1, false);
        setPlayerHighlight(2, false);
        setPlayerHighlight(3, false);
        for (int i = 0; i < 28; ++i)
        {
            field[i].checkerPanel.removeAll();
            if(field[i] instanceof CityView)
            {
                ((CityView) field[i]).clearEstatePanel();
            }
            field[i].repaint();
        }
        newGameView.clearAllPlayersNames();
    }
}

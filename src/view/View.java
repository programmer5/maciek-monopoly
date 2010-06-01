package view;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.*;

/**
 * 
 * Klasa widoku
 * @author Maciej Sulek
 *
 */
public class View 
{
	/** przechowuje widok planszy */
	public BoardView mainboard;
	
	/** przechowuje pola */
	public FieldView field[];
	
	/** przechowuje panele gracza */
	public PlayerPanelView playerPanel[];
	
	/** przechowuje zbior pionkow */
	public ImagePanel checkers[];
	
	/** przycisk rozpoczynający nową grę */
	private JButton newGameButton;
	
	/** przycisk zamykający grę */
	private JButton closeGameButton;
	
	/** przycisk rzucania kostką */
	private JButton rollDiceButton;
	
	/** przycisk kupowania miasta */
	private JButton buyCityButton;
	
	/** przycisk kupowania domu */
	private JButton buyHouseButton;
	
	/** przycisk kupowania hotelu */
	private JButton buyHotelButton;
	
	/** zakonczenie tury */
	private JButton endTurnButton;
	
	/** wynik rzutu kostka */
	private JLabel diceResult;
	
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/** okno nowej gry */
	public NewGameView newGameView;
	
	/** okno informacji o miescie */
	public CityInfoView cityInfoView;
	
	/** panel menu */
	private JPanel menuPanel;
	
	/** lewy panel w menu */
	private JPanel menuPanelLeft;
	
	/** prawy panel w menu */
	private JPanel menuPanelRight;
	
	/** srodkowy panel w menu */
	private JPanel menuPanelCenter;
	
	/**
	 * 
	 * Konstruktor klasy View
	 * 
	 */
	public View(BlockingQueue<ExtendEvent> queue)
	{
		String plaf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		try 
		{
			UIManager.setLookAndFeel(plaf);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} 
		catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		this.queue = queue;
		mainboard = new BoardView(queue);
		mainboard.setLayout(new BorderLayout(2,2));
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
		for (int i = 0; i < 4; ++i) playerPanel[i] = new PlayerPanelView();
		playerPanel[0].setPlayerName("Gracz pierwszy");
		playerPanel[1].setPlayerName("Gracz drugi");
		playerPanel[2].setPlayerName("Gracz trzeci");
		playerPanel[3].setPlayerName("Gracz czwarty");
		ExtendActionListener newGameButtonListener = new ExtendActionListener(queue);
		newGameButton = new JButton("Nowa gra");
//		newGameButton.setPreferredSize(new Dimension(400, 40));
		newGameButton.setName("newGameButton");
		newGameButton.addActionListener(newGameButtonListener);
		closeGameButton = new JButton("Zakończ");
//		closeGameButton.setPreferredSize(new Dimension(400, 40));
		closeGameButton.setName("closeGameButton");
		closeGameButton.addActionListener(new ExtendActionListener(queue));
		newGameView = new NewGameView(queue);
		cityInfoView = new CityInfoView(queue);
		//ustawianie paneli gry
		menuPanel = new JPanel();
		menuPanelLeft = new JPanel();
		menuPanelRight = new JPanel();
		menuPanelCenter = new JPanel();
		menuPanel.setOpaque(false);
		menuPanelLeft.setOpaque(false);
		menuPanelRight.setOpaque(false);
		menuPanelCenter.setOpaque(false);
		//tworzenie przyciskow
		rollDiceButton = new JButton("Rzuc kostka!");
		rollDiceButton.setName("rollDiceButton");
		rollDiceButton.addActionListener(new ExtendActionListener(queue));
		rollDiceButton.setEnabled(false);
		diceResult = new JLabel("1");
		buyCityButton = new JButton("Kup to miasto!");
		buyCityButton.setName("buyCityButton");
		buyCityButton.addActionListener(new ExtendActionListener(queue));
		buyCityButton.setEnabled(false);
		buyHouseButton = new JButton("Kup dom");
		buyHouseButton.setName("buyHouseButton");
		buyHouseButton.addActionListener(new ExtendActionListener(queue));
		buyHouseButton.setEnabled(false);
		buyHotelButton = new JButton("Kup hotel");
		buyHotelButton.setName("buyHouseButton");
		buyHotelButton.addActionListener(new ExtendActionListener(queue));
		buyHotelButton.setEnabled(false);
		endTurnButton = new JButton("Zakoncz ture");
		endTurnButton.setName("endTurnButton");
		endTurnButton.addActionListener(new ExtendActionListener(queue));
		endTurnButton.setEnabled(false);
		//inicjalizacja pionkow
		checkers = new ImagePanel[4];
	}
	
	/**
	 * 
	 * Funkcja aktywująca potrzebne komponenty
	 * 
	 */
	public void start()
	{
		mainboard.start();
		for (int i = 6; i >= 1; --i) 
			{
				mainboard.addToLeftPanel(field[i]);
				field[i].setName(String.valueOf(i));
				field[i].addMouseMotionListener(new ExtendMouseMotion(queue));
			}
		for (int i = 7; i <= 14; ++i)
			{
				mainboard.addToTopPanel(field[i]);
				field[i].setName(String.valueOf(i));
				field[i].addMouseMotionListener(new ExtendMouseMotion(queue));
			}
		for (int i = 15; i <= 20; ++i)
			{
				mainboard.addToRightPanel(field[i]);
				field[i].setName(String.valueOf(i));
				field[i].addMouseMotionListener(new ExtendMouseMotion(queue));
			}
		mainboard.addToBottomPanel(field[0]);
		field[0].setName(String.valueOf(0));
		field[0].addMouseMotionListener(new ExtendMouseMotion(queue));
		for (int i = 27; i >= 21; --i) 
			{
				mainboard.addToBottomPanel(field[i]);
				field[i].setName(String.valueOf(i));
				field[i].addMouseMotionListener(new ExtendMouseMotion(queue));
			}
		menuPanel.setLayout(new GridLayout(1, 3));
		for (int i = 0; i < 4; ++i) mainboard.addToGamePanel(playerPanel[i]);
		menuPanel.add(menuPanelLeft);
		menuPanel.add(menuPanelCenter);
		menuPanel.add(menuPanelRight);
		menuPanelLeft.add(diceResult);
		menuPanelLeft.add(rollDiceButton);
		menuPanelLeft.add(buyCityButton);
		menuPanelLeft.add(buyHouseButton);
		menuPanelLeft.add(buyHotelButton);
		menuPanelLeft.add(endTurnButton);
		menuPanelRight.add(newGameButton);
		menuPanelRight.add(closeGameButton);
		mainboard.addToGamePanel(menuPanel);
		checkers[0] = new ImagePanel("data/checker1.gif");
		checkers[1] = new ImagePanel("data/checker2.gif");
		checkers[2] = new ImagePanel("data/checker3.gif");
		checkers[3] = new ImagePanel("data/checker4.gif");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		gs.setFullScreenWindow(mainboard);
		//NewGameView newGameWindow = new NewGameView();
	}
	
	/**
	 * Przenoszenie pionka
	 * @param checkerNumber numer pionka
	 * @param fieldNumber numer pola
	 * @param newFieldNumber numer nowego pola
	 */
	public void moveChecker(int checkerNumber, int fieldNumber, int newFieldNumber)
	{
		field[fieldNumber].removeChecker(checkers[checkerNumber]);
		field[newFieldNumber].addChecker(checkers[checkerNumber]);
		field[fieldNumber].repaint();
		field[newFieldNumber].repaint();
	}
	
	/**
	 * Ustawianie pieniedzy gracza przy nowej grze
	 * @param newPlayerMoney ilosc pieniedzy
	 */
	public void newGamePlayerMoney(int newPlayerMoney)
	{
		playerPanel[0].setPlayerMoney(String.valueOf(newPlayerMoney));
		playerPanel[1].setPlayerMoney(String.valueOf(newPlayerMoney));
		playerPanel[2].setPlayerMoney(String.valueOf(newPlayerMoney));
		playerPanel[3].setPlayerMoney(String.valueOf(newPlayerMoney));
	}
	
	/**
	 * Aktualizacja pieniedzy gracza
	 * @param playerNumber numer gracza
	 * @param newPlayerMoney nowa ilosc pieniedzy
	 */
	public void newPlayerMoney(int playerNumber, int newPlayerMoney)
	{
		playerPanel[playerNumber].setPlayerMoney(String.valueOf(newPlayerMoney));
	}
	
	/**
	 * Zmiana stanu przycisku do rzucania kostka
	 */
	public void changeRollDiceButtonState()
	{
		rollDiceButton.setEnabled(!(rollDiceButton.isEnabled()));
	}
	
	/**
	 * Uaktywnienie przyciskow do gry
	 */
	public void enableButtons()
	{
		rollDiceButton.setEnabled(true);
		buyCityButton.setEnabled(true);
		buyHouseButton.setEnabled(true);
		buyHotelButton.setEnabled(true);
		endTurnButton.setEnabled(true);
	}
	
	/** 
	 * Uaktualnianie wylosowanej liczby oczek kostki
	 * @param diceResult liczba oczek
	 */
	public void setDiceResult(int diceResult)
	{
		this.diceResult.setText(String.valueOf(diceResult));
	}
	
	/**
	 * Zmiany widoku wynikajace ze zmiany gracza
	 * @param actPlayer aktualny gracz
	 * @param nextPlayer numer nastepnego gracza
	 */
	public void nextPlayer(int actPlayer, int nextPlayer)
	{
		playerPanel[actPlayer].setHighlight(false);
		playerPanel[nextPlayer].setHighlight(true);
	}
}

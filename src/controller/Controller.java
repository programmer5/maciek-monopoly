package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;

import view.*;
import model.*;

/**
 * 
 * Klasa kontrolera
 * @author Maciej Sulek
 *
 */

public class Controller
{
	/** glowny model */
	private static Model mainModel;
	
	/** glowny widok */
	private static ViewChanger mainViewChanger;
	
	/** rozszerzenie zdarzen akcji */
	private static ExtendEvent extendEvent;
	
	/** mapa par */
	private static Vector<Pair> map;
	
	/** */
	private ControllerRunnable controllerRunnable;
	
	/** */
	private Thread controllerThread;
	
	/** aktualny element mapy */
	private static int act;
	
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy Controller
	 * @param queue kolejka blokujaca
	 * @param viewChanger klasa umozliwiajaca zmiany w view
	 * @param model model programu
	 * @throws SecurityException wyjatek bezpieczenstwa
	 * @throws NoSuchMethodException wyjatek nieodnalezionej metody
	 */
	public Controller(BlockingQueue<ExtendEvent> queue, ViewChanger viewChanger, Model model)
		throws SecurityException, NoSuchMethodException
	{
		mainModel = model;
		mainViewChanger = viewChanger;
		map = new Vector<Pair>();
		createMap();
		controllerRunnable = new ControllerRunnable(queue);
		controllerThread = new Thread(controllerRunnable);
		controllerThread.start();
		loadData();
	}
	
	/**
	 * tworzy mape
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public void createMap() 
	throws SecurityException, NoSuchMethodException
	{
		map.add(new Pair("newGameButton", Controller.class.getMethod("newGameViewShow")));
		map.add(new Pair("newGameButtonCancel", Controller.class.getMethod("newGameViewHide")));
		map.add(new Pair("newGameButtonOk", Controller.class.getMethod("startNewGame")));
		map.add(new Pair("closeGameButton", Controller.class.getMethod("closeGame")));
		map.add(new Pair("rollDiceButton", Controller.class.getMethod("rollDice")));
		map.add(new Pair("closeInfoButton", Controller.class.getMethod("closeInfo")));
		map.add(new Pair("gamePanel", Controller.class.getMethod("closeInfo")));
		map.add(new Pair("buyCityButton", Controller.class.getMethod("buyCity")));
		map.add(new Pair("endTurnButton", Controller.class.getMethod("endTurn")));
	}
	
	//FUNKCJE DLA OBIEKTOW
	/**
	 * pokazywanie okna nowej gry
	 */
	public static void newGameViewShow()
	{
		mainView.newGameView.setVisible(true);
	}
	
	/**
	 * ukrywanie okna nowej gry
	 */
	public static void newGameViewHide()
	{
		mainView.newGameView.setVisible(false);
	}
	
	/**
	 * rozpoczynanie nowej gry
	 */
	public static void startNewGame()
	{
		if (mainView.newGameView.getFirstPlayer().equals("") == false) 
		{
			mainView.playerPanel[0].setPlayerName(mainView.newGameView.getFirstPlayer());
			++mainModel.playerNumber;
			if (mainView.newGameView.getSecondPlayer().equals("") == false) 
			{
				mainView.playerPanel[1].setPlayerName(mainView.newGameView.getSecondPlayer());
				++mainModel.playerNumber;
				if (mainView.newGameView.getThirdPlayer().equals("") == false) 
				{
					mainView.playerPanel[2].setPlayerName(mainView.newGameView.getThirdPlayer());
					++mainModel.playerNumber;
					if (mainView.newGameView.getFourthPlayer().equals("") == false) 
					{
						mainView.playerPanel[3].setPlayerName(mainView.newGameView.getFourthPlayer());
						++mainModel.playerNumber;
					}
				}
			}
		}
		if (mainModel.playerNumber == 0) 
		{
			JOptionPane.showMessageDialog(mainView.newGameView, "Nie wpisałeś nazwy żadnego gracza (pamiętaj, że wpisywanie musisz zacząć od pierwszego gracza)!", "Błąd nowej gry!", JOptionPane.ERROR_MESSAGE);
		}
		else if (mainModel.playerNumber == 1) 
		{
			JOptionPane.showMessageDialog(mainView.newGameView, "Jeden gracz to za mało (pamiętaj, że wpisywanie musisz zacząć od pierwszego gracza)!", "Błąd nowej gry!", JOptionPane.ERROR_MESSAGE);
			mainModel.playerNumber = 0;
		}
		else
		{
			for (int i = 0; i < mainModel.playerNumber; ++i)
			{
				mainView.field[0].addChecker(mainView.checkers[i]);
			}
			for (int i = mainModel.playerNumber; i < 4; ++i) 
			{
				mainView.playerPanel[i].setVisible(false);
			}
			mainView.newGamePlayerMoney(mainModel.getPlayerSaldo(0));
			mainView.newGameView.setVisible(false);
			mainView.enableButtons();
			mainView.playerPanel[0].setHighlight(true);
		}
		
	}
	
	/**
	 * konczenie gry
	 */
	public static void closeGame()
	{
		System.exit(0);
	}
	
	/**
	 * rzuczanie kostka
	 */
	public static void rollDice()
	{
		Random rnd = new Random();
		int rndNumber = rnd.nextInt(6) + 1;
		int actPlayer = mainModel.getCurrentPlayer();
//		System.out.println("ads" + rndNumber);
		int fieldNumber = mainModel.checkers[actPlayer].getFieldNumber();
		int newFieldNumber = mainModel.checkers[actPlayer].moveOn(rndNumber);
//		System.out.println("asd " + fieldNumber + " " + newFieldNumber);
		mainView.setDiceResult(rndNumber);
		mainView.moveChecker(actPlayer, fieldNumber, newFieldNumber);
		mainView.changeRollDiceButtonState();
	}
	
	/**
	 * zamkniecie okna informacji o miescie
	 */
	public static void closeInfo()
	{
		mainView.cityInfoView.setVisible(false);
	}
	
	/**
	 * zakup miasta
	 */
	public static void buyCity()
	{
		
	}
	
	/** konczenie tury */
	public static void endTurn()
	{
		mainView.nextPlayer(mainModel.getCurrentPlayer(), mainModel.nextPlayer());
		mainView.changeRollDiceButtonState();
	}
	
	/**
	 * standardowa akcja dla panelu
	 */
	public static void panelAction()
	{
		if (mainModel.field[act] instanceof CityModel == false) return;
		String[] tmpParams = ((CityModel)mainModel.field[act]).getAllParams();
		mainView.cityInfoView.updateAll(tmpParams);
		mainView.cityInfoView.setVisible(true);
		System.out.println("Panel: " + String.valueOf(act));
	}
	
	/**
	 * ladowanie nazw miast i danych o nich z modelu do widoku
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	public void loadData()
	throws SecurityException, NoSuchMethodException
	{
		for (int i = 0; i < 28; ++i)
		{
			if (mainModel.field[i] instanceof CityModel)
				((CityView)mainView.field[i]).setCityName(mainModel.field[i].getFieldName());
			map.add(new Pair(String.valueOf(i), Controller.class.getMethod("panelAction")));
		}
	}
	
	/**
	 * 
	 * @author Maciej Sulek
	 * Klasa prywatna implementujaca watek
	 *
	 */
	private class ControllerRunnable implements Runnable
	{		
		public ControllerRunnable(BlockingQueue<ExtendEvent> _queue)
		throws SecurityException, NoSuchMethodException
		{
			queue = _queue;
		}
		
		@Override
		public void run() 
		{	
			while(true)
			{
				try 
				{
					extendEvent = queue.take();
					for (int i = 0; i < map.size(); ++i)
					{
						//System.out.println(extendActionEvent.getCommand());
						if (map.get(i).getCommand().equals((extendEvent).getCommand()))
						{
							try
							{
								act = Integer.parseInt(map.get(i).getCommand());
							}
							catch (NumberFormatException e)
							{
								act = 0;
							}
							map.get(i).getMethod().invoke(null);
						}
					}
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				} 
				catch (IllegalArgumentException e) 
				{
					e.printStackTrace();
				}
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				}
				catch (InvocationTargetException e) 
				{
					e.printStackTrace();
				} 
			}
		}
	}
}

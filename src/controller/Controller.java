package controller;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import controller.actions.*;
import controller.events.*;
import view.*;
import model.*;

/**
 * Klasa kontrolera
 * @author Maciej Sulek
 */

public class Controller
{
	/** glowny model */
	private static Model mainModel;
	
	/** glowny widok */
	private static ViewChanger mainViewChanger;
	
	/** mapa par */
	private final HashMap<Class<? extends ExtendEvent>, ExtendAction> map;;
	
	/** aktualny element mapy */
	private static int actField;
	
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy Controller
	 * @param queue kolejka blokujaca
	 * @param viewChanger klasa umozliwiajaca zmiany w view
	 * @param model model programu
	 * @throws SecurityException wyjatek bezpieczenstwa
	 * @throws NoSuchMethodException wyjatek nieodnalezionej metody
	 * @throws ClassNotFoundException wyjatek nieznalezionej klasy
	 */
	public Controller(BlockingQueue<ExtendEvent> queue, ViewChanger viewChanger, Model model)
		throws SecurityException, NoSuchMethodException, ClassNotFoundException
	{
		mainModel = model;
		mainViewChanger = viewChanger;
		this.queue = queue;
		map = new HashMap<Class<? extends ExtendEvent>, ExtendAction>();
		createMap();
		loadData();
	}
	
	public void work()
	{
		while(true)
		{
			ExtendEvent extendEvent;
			try 
			{
				extendEvent = queue.take();
				ExtendAction extendAction = map.get(extendEvent.getClass());
				extendAction.perform();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
	
	/** 
	 * Pobranie modelu
	 * @return mainModel model
	 */
	public Model getModel()
	{
		return mainModel;
	}
	
	/**
	 * Pobranie fasady widoku
	 * @return mainViewChanger fasada widoku
	 */
	public ViewChanger getViewChanger()
	{
		return mainViewChanger;
	}
	
	/**
	 * Pobranie numeru aktualnego panelu
	 * @return actField aktualne pole
	 */
	public static int getActField()
	{
		return actField;
	}
	
	/**
	 * Ustawienie numeru aktualnego panelu
	 * @param newActField nowa aktualne pole
	 */
	public static void setActField(int newActField)
	{
		actField = newActField;
	}
	
	/**
	 * tworzy mape
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public void createMap() 
	throws SecurityException, NoSuchMethodException
	{
		map.put(ExtendNewGameEvent.class, new ExtendNewGameAction(this));
		map.put(ExtendMouseEvent.class, new ExtendMouseAction(this));
		map.put(ExtendHideCityInfoEvent.class, new ExtendHideCityInfoAction(this));
		map.put(ExtendRollDiceEvent.class, new ExtendRollDiceAction(this));
		map.put(ExtendBuyCityEvent.class, new ExtendBuyCityAction(this));
		map.put(ExtendStartNewGameEvent.class, new ExtendStartNewGameAction(this));
		map.put(ExtendCloseNewGameEvent.class, new ExtendCloseNewGameAction(this));
		map.put(ExtendEndTurnEvent.class, new ExtendEndTurnAction(this));
		map.put(ExtendCloseGameEvent.class, new ExtendCloseGameAction());
		map.put(ExtendBuyHotelEvent.class, new ExtendBuyHotelAction(this));
		map.put(ExtendBuyHouseEvent.class, new ExtendBuyHouseAction(this));
		map.put(ExtendCloseCityInfoEvent.class, new ExtendCloseCityInfoAction(this));
	}
	
	//FUNKCJE DLA OBIEKTOW		
	/** konczenie gry */
	public static void endGame()
	{
		mainViewChanger.allButtonsEnableFalse();
		mainViewChanger.showGameDialog("Saldo jednego z graczy jest mniejsze od zera, co powoduje, że dalsza gra musi być przerwana! Gratulacje dla zwycięzcy!", "Koniec GRY!");
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
			{
				mainViewChanger.setCityName(i, mainModel.field[i].getFieldName());
				mainViewChanger.setFieldCheckerPanelColor(i, ((CityModel)mainModel.field[i]).getDistrict());
			}
		}
	}
}

package controller;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import controller.actions.*;
import controller.events.*;
import view.*;
import model.*;

/**
 * Klasa kontrolera
 * 
 * @author Maciej Sulek
 */

public class Controller
{
	/** glowny model */
	private Model mainModel;
	
	/** glowny widok */
	private ViewChanger mainViewChanger;
	
	/** mapa par */
	private final HashMap<Class<? extends ExtendEvent>, ExtendAction> map;;
	
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy Controller
	 * 
	 * @param queue kolejka blokujaca
	 * @param viewChanger klasa umozliwiajaca zmiany w view
	 * @param model model programu
	 */
	public Controller(BlockingQueue<ExtendEvent> queue, ViewChanger viewChanger, Model model)
	{
		mainModel = model;
		mainViewChanger = viewChanger;
		this.queue = queue;
		map = new HashMap<Class<? extends ExtendEvent>, ExtendAction>();
		createMap();
		loadData();
	}
	
	/**
	 * Funkcja pobierajaca zdarzenia z kolejki
	 */
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
	 * Pobieranie modelu
	 * 
	 * @return mainModel model
	 */
	public Model getModel()
	{
		return mainModel;
	}
	
	/**
	 * Pobieranie fasady widoku
	 * 
	 * @return mainViewChanger fasada widoku
	 */
	public ViewChanger getViewChanger()
	{
		return mainViewChanger;
	}
	
	/**
	 * Tworzy mape
	 */
	public void createMap() 
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
	
	/** 
	 * Konczenie gry 
	 */
	public void endGame()
	{
		mainViewChanger.allButtonsEnableFalse();
		mainViewChanger.showGameDialog("Saldo jednego z graczy jest mniejsze od zera, co powoduje, że dalsza gra musi być przerwana! Gratulacje dla zwycięzcy!", "Koniec GRY!");
	}
	
	/**
	 * Ladowanie nazw miast i danych o nich z modelu do widoku
	 */
	public void loadData()
	{
		for (int i = 0; i < 28; ++i)
		{
			if (mainModel.getField(i) instanceof CityModel)
			{
				mainViewChanger.setCityName(i, mainModel.getField(i).getFieldName());
				mainViewChanger.setFieldCheckerPanelColor(i, ((CityModel)mainModel.getField(i)).getDistrict());
			}
		}
	}
}

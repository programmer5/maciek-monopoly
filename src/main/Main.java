package main;

import java.util.concurrent.ArrayBlockingQueue;
import controller.*;
import controller.events.ExtendEvent;
import view.*;
import model.*;

/**
 * 
 * Glowna klasa uruchamiajaca poszczegolne elementy
 * @author Maciej Sulek
 * 
 */
public class Main
{
	/**
	 * 
	 * @param args argumenty głównej funkcji main
	 * @throws ClassNotFoundException 
	 * 
	 */
	public static void main(String[] args) throws ClassNotFoundException 
	{
		final int QUEUE_SIZE = 30;
		ArrayBlockingQueue<ExtendEvent> blockingQueue = new ArrayBlockingQueue<ExtendEvent>(QUEUE_SIZE);
		Model mainModel = new Model();
		View mainView = new View(blockingQueue);
		ViewChanger mainViewChanger = new ViewChanger(mainView);
		mainView.start();
		mainModel.initialize();
		try 
		{
			Controller controller = new Controller(blockingQueue, mainViewChanger, mainModel);
			controller.work();
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) 
		{
			e.printStackTrace();
		}
	}
}

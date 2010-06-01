package main;

import java.awt.EventQueue;
import java.util.concurrent.ArrayBlockingQueue;

import controller.*;
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
	 * 
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{	
			@Override
			public void run() 
			{
				final int QUEUE_SIZE = 10;
				ArrayBlockingQueue<ExtendEvent> blockingQueue = new ArrayBlockingQueue<ExtendEvent>(QUEUE_SIZE);
				Model mainModel = new Model();
				View mainView = new View(blockingQueue);
				ViewChanger mainViewChanger = new ViewChanger(mainView);
				mainView.start();
				mainModel.initialize();
				try 
				{
					new Controller(blockingQueue, mainViewChanger, mainModel);
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
		});
	}

}

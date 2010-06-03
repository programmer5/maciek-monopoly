package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendCloseGameEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwanie nacisniecia przycisku zamkniecia gry
 * @author Maciej Sulek
 */
public class ExtendCloseGameListener implements ActionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendCloseGameListener
	 * @param queue
	 */
	public ExtendCloseGameListener(BlockingQueue<ExtendEvent> queue)
	{
		this.queue = queue;
	}
	
	/**
	 * Funkcja wykonywana przy kliknieciu
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			queue.put(new ExtendCloseGameEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}	
	}
}

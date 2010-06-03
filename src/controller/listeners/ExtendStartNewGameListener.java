package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendEvent;
import controller.events.ExtendStartNewGameEvent;

/**
 * Nasluchiwacz wcisniecia przycisku startu nowej gry
 * @author programmer
 *
 */
public class ExtendStartNewGameListener implements ActionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendStartNewGameListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendStartNewGameListener(BlockingQueue<ExtendEvent> queue)
	{
		this.queue = queue;
	}
	
	/**
	 * Funkcja wykonywana przy wykryciu klikniecia
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		try 
		{
			queue.put(new ExtendStartNewGameEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

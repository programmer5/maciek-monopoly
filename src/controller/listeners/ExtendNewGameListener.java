package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendEvent;
import controller.events.ExtendNewGameEvent;

/**
 * Nasluchiwanie wcisniecia przycisku Nowej Gry
 * @author Maciej Sulek
 */
public class ExtendNewGameListener implements ActionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendNewGameListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendNewGameListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendNewGameEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

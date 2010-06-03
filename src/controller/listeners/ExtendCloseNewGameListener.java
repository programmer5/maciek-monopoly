package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendCloseNewGameEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwanie czy wcisnieto przycisk zamkniecia okna nowej gry
 * @author Maciej Sulek
 */
public class ExtendCloseNewGameListener implements ActionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendCloseNewGameListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendCloseNewGameListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendCloseNewGameEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

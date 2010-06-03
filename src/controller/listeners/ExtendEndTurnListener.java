package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendEndTurnEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwanie przycisniecia przycisku zakonczenia tury
 * @author Maciej Sulek
 */
public class ExtendEndTurnListener implements ActionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendEndTurnListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendEndTurnListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendEndTurnEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

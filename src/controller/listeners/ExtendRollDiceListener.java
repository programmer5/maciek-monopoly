package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendEvent;
import controller.events.ExtendRollDiceEvent;

/**
 * Nasluchuje wcisniecie przycisku rzutu kostka
 * @author Maciej Sulek
 */
public class ExtendRollDiceListener implements ActionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendRollDiceListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendRollDiceListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendRollDiceEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

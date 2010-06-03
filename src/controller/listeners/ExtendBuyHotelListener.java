package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendBuyHotelEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwacz czy zostal wcisniety przycisk zakupu hotelu
 * @author Maciej Sulek
 */
public class ExtendBuyHotelListener implements ActionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendBuyHotelListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendBuyHotelListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendBuyHotelEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

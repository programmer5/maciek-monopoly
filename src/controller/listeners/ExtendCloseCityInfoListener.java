package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendCloseCityInfoEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwacz czy wcisnieto przycisk zamkniecia okna informacji o miescie
 * @author programmer
 */
public class ExtendCloseCityInfoListener implements ActionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendCloseCityInfoListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendCloseCityInfoListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendCloseCityInfoEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	} 
}

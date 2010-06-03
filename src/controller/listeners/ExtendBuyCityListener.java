package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendBuyCityEvent;
import controller.events.ExtendEvent;
/**
 * Nasluchiwanie przycisniecia przycisku zakupu miasta
 * @author Maciej Sulek
 */
public class ExtendBuyCityListener implements ActionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendBuyCityListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendBuyCityListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendBuyCityEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

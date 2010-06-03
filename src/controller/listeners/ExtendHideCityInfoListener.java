package controller.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendEvent;
import controller.events.ExtendHideCityInfoEvent;

/**
 * Wykrycie ruchu na panelu gry 
 * @author programmer
 *
 */
public class ExtendHideCityInfoListener implements MouseMotionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendHideCityInfoListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendHideCityInfoListener(BlockingQueue<ExtendEvent> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void mouseDragged(MouseEvent evt) 
	{
		// Brak potrzeby implementacji	
	}

	/**
	 * Operacje, gdy wykryto ruch myszy
	 */
	@Override
	public void mouseMoved(MouseEvent evt)
	{
		try 
		{
			queue.put(new ExtendHideCityInfoEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}

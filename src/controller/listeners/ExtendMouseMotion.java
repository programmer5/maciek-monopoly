
package controller.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;

import controller.Controller;
import controller.events.ExtendEvent;
import controller.events.ExtendMouseEvent;

/**
 * 
 * Klasa implementujaca Nasluchwiacz Ruchow Myszy
 * @author Maciej Sulek
 *
 */
public class ExtendMouseMotion implements MouseMotionListener
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/** pole na ktore najechano */
	private int actField;
	
	/**
	 * Konstruktor klasy ExtendMouseMotion
	 * @param queue kolejka blokujaca
	 * @param actField numer pola dla listenera
	 */
	public ExtendMouseMotion(BlockingQueue<ExtendEvent> queue, final int actField)
	{
		this.queue = queue;
		this.actField = actField;
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// Nie ma potrzeby ipmlementacji tej funkcji
	}

	@Override
	public void mouseMoved(MouseEvent evt)
	{
		try 
		{
			queue.put(new ExtendMouseEvent());
			Controller.setActField(actField);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

}
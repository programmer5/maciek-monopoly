package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import controller.events.ExtendBuyHouseEvent;
import controller.events.ExtendEvent;

/**
 * Nasluchiwacz czy nie zostal nacisniety przycisk zakupu domu
 * @author Maciej Sulek
 */
public class ExtendBuyHouseListener implements ActionListener 
{
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/**
	 * Konstruktor klasy ExtendBuyHouseListener
	 * @param queue kolejka blokujaca
	 */
	public ExtendBuyHouseListener(BlockingQueue<ExtendEvent> queue)
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
			queue.put(new ExtendBuyHouseEvent());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	} 
}

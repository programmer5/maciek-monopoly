package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendBuyHouseEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;


/**
 * Nasluchiwacz czy nie zostal nacisniety przycisk zakupu domu
 * 
 * @author Maciej Sulek
 */
public class ExtendBuyHouseListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendBuyHouseListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendBuyHouseListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendBuyHouseEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

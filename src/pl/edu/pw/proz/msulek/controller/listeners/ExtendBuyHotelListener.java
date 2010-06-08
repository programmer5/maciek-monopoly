package pl.edu.pw.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.proz.msulek.controller.events.ExtendBuyHotelEvent;
import pl.edu.pw.proz.msulek.controller.events.ExtendEvent;


/**
 * Nasluchiwacz czy zostal wcisniety przycisk zakupu hotelu
 * 
 * @author Maciej Sulek
 */
public class ExtendBuyHotelListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendBuyHotelListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendBuyHotelListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    /**
     * Funkcja wykonywana przy wykryciu klikniecia
     */
    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendBuyHotelEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
}

package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendCloseCityInfoEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;


/**
 * Nasluchiwacz czy wcisnieto przycisk zamkniecia okna informacji o miescie
 * 
 * @author Maciej Sulek
 */
public class ExtendCloseCityInfoListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendCloseCityInfoListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendCloseCityInfoListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendCloseCityInfoEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

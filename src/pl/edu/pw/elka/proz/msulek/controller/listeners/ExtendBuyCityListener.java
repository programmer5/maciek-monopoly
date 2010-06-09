package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendBuyCityEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;

/**
 * Nasluchiwanie przycisniecia przycisku zakupu miasta
 * 
 * @author Maciej Sulek
 */
public class ExtendBuyCityListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendBuyCityListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendBuyCityListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendBuyCityEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

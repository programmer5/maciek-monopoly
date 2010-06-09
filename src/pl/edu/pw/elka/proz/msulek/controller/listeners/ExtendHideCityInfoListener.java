package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendHideCityInfoEvent;

/**
 * Wykrycie ruchu na panelu gry
 * 
 * @author Maciej Sulek
 */
public class ExtendHideCityInfoListener implements MouseMotionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendHideCityInfoListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendHideCityInfoListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void mouseDragged(final MouseEvent evt)
    {
        // Brak potrzeby implementacji
    }

    @Override
    public void mouseMoved(final MouseEvent evt)
    {
        try
        {
            queue.put(new ExtendHideCityInfoEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

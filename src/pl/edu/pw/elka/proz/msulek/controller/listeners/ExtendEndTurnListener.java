package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEndTurnEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;

/**
 * Nasluchiwanie przycisniecia przycisku zakonczenia tury
 * 
 * @author Maciej Sulek
 */
public class ExtendEndTurnListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendEndTurnListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendEndTurnListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendEndTurnEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

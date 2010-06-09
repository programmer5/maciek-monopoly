package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendStartNewGameEvent;

/**
 * Nasluchiwacz wcisniecia przycisku startu nowej gry
 * 
 * @author Maciej Sulek
 */
public class ExtendStartNewGameListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendStartNewGameListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendStartNewGameListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendStartNewGameEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

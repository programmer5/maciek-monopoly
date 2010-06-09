package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendCloseNewGameEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;


/**
 * Nasluchiwanie czy wcisnieto przycisk zamkniecia okna nowej gry
 * 
 * @author Maciej Sulek
 */
public class ExtendCloseNewGameListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendCloseNewGameListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendCloseNewGameListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendCloseNewGameEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

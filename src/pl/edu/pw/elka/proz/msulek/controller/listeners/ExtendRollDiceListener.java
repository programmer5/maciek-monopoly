package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendRollDiceEvent;

/**
 * Nasluchuje wcisniecie przycisku rzutu kostka
 * 
 * @author Maciej Sulek
 */
public class ExtendRollDiceListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendRollDiceListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendRollDiceListener(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
    }

    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        try
        {
            queue.put(new ExtendRollDiceEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }
}

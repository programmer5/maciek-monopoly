package pl.edu.pw.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.proz.msulek.controller.events.ExtendNewGameEvent;


/**
 * Nasluchiwanie wcisniecia przycisku Nowej Gry
 * 
 * @author Maciej Sulek
 */
public class ExtendNewGameListener implements ActionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy ExtendNewGameListener
     * 
     * @param queue
     *            kolejka blokujaca
     */
    public ExtendNewGameListener(final BlockingQueue<ExtendEvent> queue)
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
            queue.put(new ExtendNewGameEvent());
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
}

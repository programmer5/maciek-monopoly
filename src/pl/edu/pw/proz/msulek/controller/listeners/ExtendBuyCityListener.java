package pl.edu.pw.proz.msulek.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.proz.msulek.controller.events.ExtendBuyCityEvent;
import pl.edu.pw.proz.msulek.controller.events.ExtendEvent;


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

    /**
     * Funkcja wykonywana przy wykryciu klikniecia
     */
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
            System.exit(0);
        }
    }
}

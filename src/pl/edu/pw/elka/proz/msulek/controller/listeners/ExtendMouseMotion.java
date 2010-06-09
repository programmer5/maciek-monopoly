package pl.edu.pw.elka.proz.msulek.controller.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendMouseEvent;

/**
 * Klasa implementujaca nasluchwiacz ruchow myszy
 * 
 * @author Maciej Sulek
 */
public class ExtendMouseMotion implements MouseMotionListener
{
    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /** pole na ktore najechano */
    private final int actField;

    /** obiekt przechowujacy aktualne pole w widoku */
    private final int actFieldGlobal[];

    /**
     * Konstruktor klasy ExtendMouseMotion
     * 
     * @param queue
     *            kolejka blokujaca
     * @param actField
     *            numer pola dla listenera
     */
    public ExtendMouseMotion(final BlockingQueue<ExtendEvent> queue, final int actField, final int actFieldGlobal[])
    {
        this.queue = queue;
        this.actField = actField;
        this.actFieldGlobal = actFieldGlobal;
    }

    @Override
    public void mouseDragged(final MouseEvent arg0)
    {
        // Nie ma potrzeby ipmlementacji tej funkcji
    }

    @Override
    public void mouseMoved(final MouseEvent evt)
    {
        try
        {
            queue.put(new ExtendMouseEvent());
            actFieldGlobal[0] = actField;
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Blad kolejki! Program musi zakonczyc dzialanie.");
            System.exit(0);
        }
    }

}
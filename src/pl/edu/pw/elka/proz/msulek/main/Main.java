package pl.edu.pw.elka.proz.msulek.main;

import java.util.concurrent.ArrayBlockingQueue;

import pl.edu.pw.elka.proz.msulek.controller.*;
import pl.edu.pw.elka.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.elka.proz.msulek.model.*;
import pl.edu.pw.elka.proz.msulek.view.*;

/**
 * Glowna klasa uruchamiajaca poszczegolne elementy
 * 
 * @author Maciej Sulek
 */
public class Main
{
    /**
     * Glowna funkcja
     * 
     * @param args
     *            argumenty głównej funkcji main
     */
    public static void main(final String[] args)
    {
        final int QUEUE_SIZE = 30;
        final ArrayBlockingQueue<ExtendEvent> blockingQueue = new ArrayBlockingQueue<ExtendEvent>(QUEUE_SIZE);
        final Model mainModel = new Model();
        final View mainView = new View(blockingQueue);
        final ViewChanger mainViewChanger = new ViewChanger(mainView);
        mainView.start();
        mainModel.initialize();
        try
        {
            final Controller controller = new Controller(blockingQueue, mainViewChanger, mainModel);
            controller.work();
        }
        catch (final SecurityException e)
        {
            e.printStackTrace();
            System.err.println("Blad kontrolera gry. Musi nastapic zamkniecie.");
            System.exit(0);
        }
    }
}

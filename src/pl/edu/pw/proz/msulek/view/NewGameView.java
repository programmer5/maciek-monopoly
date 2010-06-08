package pl.edu.pw.proz.msulek.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pl.edu.pw.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.proz.msulek.controller.listeners.ExtendCloseNewGameListener;
import pl.edu.pw.proz.msulek.controller.listeners.ExtendStartNewGameListener;


/**
 * Klasa okna rozpoczynajacego nowa gre
 * 
 * @author Maciej Sulek
 */
public class NewGameView extends JFrame
{
    /** wygenerowane id */
    private static final long serialVersionUID = 784092313743116688L;

    /** pole nazwy pierwszego gracza */
    private final JTextField firstPlayer;

    /** pole nazwy drugiego gracza */
    private final JTextField secondPlayer;

    /** pole nazwy trzeciego gracza */
    private final JTextField thirdPlayer;

    /** pole nazwy czwartego gracza */
    private final JTextField fourthPlayer;

    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy NewGameView()
     */
    public NewGameView(final BlockingQueue<ExtendEvent> _queue)
    {
        this.queue = _queue;
        final int width = 400;
        final int height = 200;
        final Toolkit toolkit = getToolkit();
        final Dimension dimension = toolkit.getScreenSize();
        setTitle("Rozpocznij nową grę!");
        setSize(width, height);
        setLocation(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2);
        // tworzenie komponentow
        firstPlayer = new JTextField();
        secondPlayer = new JTextField();
        thirdPlayer = new JTextField();
        fourthPlayer = new JTextField();
        setLayout(new GridLayout(6, 6));
        add(new JLabel("Nazwa czwartego gracza:"), 3, 0);
        add(fourthPlayer, 3, 1);
        add(new JLabel("Nazwa trzeciego gracza:"), 2, 0);
        add(thirdPlayer, 2, 1);
        add(new JLabel("Nazwa drugiego gracza:"), 1, 0);
        add(secondPlayer, 1, 1);
        add(new JLabel("Nazwa pierwszego gracza:"), 0, 0);
        add(firstPlayer, 0, 1);
        final JButton newGameOk = new JButton("Zaczynamy!");
        newGameOk.addActionListener(new ExtendStartNewGameListener(queue));
        add(newGameOk, 4, 0);
        final JButton newGameCancel = new JButton("Może później...");
        newGameCancel.addActionListener(new ExtendCloseNewGameListener(queue));
        add(newGameCancel, 4, 1);
    }

    /**
     * Pobieranie nazwy pierwszego gracza
     * 
     * @return firstPlayer nazwa pierwszego gracza
     */
    public String getFirstPlayer()
    {
        return firstPlayer.getText();
    }

    /**
     * Pobieranie nazwy drugiego gracza
     * 
     * @return secondPlayer nazwa drugiego gracza
     */
    public String getSecondPlayer()
    {
        return secondPlayer.getText();
    }

    /**
     * Pobieranie nazwy trzeciego gracza
     * 
     * @return thirdPlayer nazwa trzeciego gracza
     */
    public String getThirdPlayer()
    {
        return thirdPlayer.getText();
    }

    /**
     * Pobieranie nazwy czwartego gracza
     * 
     * @return fourthPlayer nazwa czwartego gracza
     */
    public String getFourthPlayer()
    {
        return fourthPlayer.getText();
    }
}

package pl.edu.pw.proz.msulek.view;

import javax.swing.*;

import pl.edu.pw.proz.msulek.controller.events.ExtendEvent;
import pl.edu.pw.proz.msulek.controller.listeners.ExtendHideCityInfoListener;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Maciej Sulek Klasa do realizowania planszy do gry
 * 
 */

public final class BoardView extends JFrame
{
    /** wygenerowane id */
    private static final long serialVersionUID = 1L;

    /** panel gorny */
    private JPanel topPanel;

    /** panel dolny */
    private JPanel bottomPanel;

    /** panel lewy */
    private JPanel leftPanel;

    /** panel prawy */
    private JPanel rightPanel;

    /** panel obsługi gry */
    private ImagePanel gamePanel;

    /** szerokosc okna */
    static int boardWidth;

    /** wysokosc okna */
    static int boardHeight;

    /** kolejka blokujaca */
    private final BlockingQueue<ExtendEvent> queue;

    /**
     * Konstruktor klasy Board
     * 
     * @param queue
     *            kolejka blokujaca
     */
    BoardView(final BlockingQueue<ExtendEvent> queue)
    {
        this.queue = queue;
        final Toolkit toolkit = getToolkit();
        final Dimension dimension = toolkit.getScreenSize();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Witaj w grze MONOPOL");
        boardWidth = dimension.width;
        boardHeight = dimension.height;
        setSize(boardWidth, boardHeight);
        // setLocation(dimension.width / 2 - boardWidth / 2, dimension.height /
        // 2 - boardHeight / 2);
        setLayout(new BorderLayout(0, 0));
        // setResizable(false);
        // setUndecorated(true);
    }

    /**
     * 
     * Funkcja ładująca komponenty
     * 
     */
    public void start()
    {
        // tworzenie komponentów
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        gamePanel = new ImagePanel("data/mainbg.jpg");
        gamePanel.setName("gamePanel");
        gamePanel.addMouseMotionListener(new ExtendHideCityInfoListener(queue));
        topPanel.setPreferredSize(new Dimension(boardWidth, boardHeight / 8));
        bottomPanel.setPreferredSize(new Dimension(boardWidth, boardHeight / 8));
        leftPanel.setPreferredSize(new Dimension(boardWidth / 8, boardHeight));
        rightPanel.setPreferredSize(new Dimension(boardWidth / 8, boardHeight));
        topPanel.setBackground(Color.white);
        bottomPanel.setBackground(Color.blue);
        leftPanel.setBackground(Color.black);
        rightPanel.setBackground(Color.yellow);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
        add(leftPanel, BorderLayout.LINE_START);
        add(rightPanel, BorderLayout.LINE_END);
        add(gamePanel, BorderLayout.CENTER);
        // gamePanel.repaint();
        setAlwaysOnTop(false);
        setVisible(true);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
    }

    /**
     * Funkcja umozliwiająca dodanie komponentu do gornego panelu
     * 
     * @param comp
     *            dodwany komponent
     */
    public void addToTopPanel(final Component comp)
    {
        topPanel.add(comp);
    }

    /**
     * Funkcja umozliwiająca dodanie komponentu do dolnego panelu
     * 
     * @param comp
     *            dodwany komponent
     */
    public void addToBottomPanel(final Component comp)
    {
        bottomPanel.add(comp);
    }

    /**
     * Funkcja umozliwiająca dodanie komponentu do lewego panelu
     * 
     * @param comp
     *            dodwany komponent
     */
    public void addToLeftPanel(final Component comp)
    {
        leftPanel.add(comp);
    }

    /**
     * Funkcja umozliwiająca dodanie komponentu do prawego panelu
     * 
     * @param comp
     *            dodwany komponent
     */
    public void addToRightPanel(final Component comp)
    {
        rightPanel.add(comp);
    }

    /**
     * Funkcja umozliwiająca dodanie komponentu do panelu gry
     * 
     * @param comp
     *            dodwany komponent
     */
    public void addToGamePanel(final Component comp)
    {
        gamePanel.add(comp);
    }

    /**
     * Funkcja umozliwiająca pobranie szerokosci okna
     * 
     * @reuturn boarWidth szerokosc okna
     */
    int getBoardWidth()
    {
        return boardWidth;
    }

    /**
     * Funkcja umozliwiająca pobranie wysokosci okna
     * 
     * @return boardHeight wysokosc okna
     */
    int getBoardHeight()
    {
        return boardHeight;
    }
}

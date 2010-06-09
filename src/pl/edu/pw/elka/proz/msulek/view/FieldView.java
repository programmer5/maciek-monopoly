package pl.edu.pw.elka.proz.msulek.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

//import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Klasa do wyswietlania pola na planszy
 * 
 * @author Maciej Sulek
 */

public class FieldView extends JPanel
{
    /** wygenerowane id */
    private static final long serialVersionUID = -2488246611184305744L;

    /** panel z pionkami */
    protected JPanel checkerPanel;

    /** id pola */
    protected int id;

    /**
     * Zwraca id pionka
     * 
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final int id)
    {
        this.id = id;
    }

    /**
     * Konstruktor klasy FieldView
     * 
     * @param _id
     *            id pola
     */
    FieldView()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.pink);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 8));
        checkerPanel = new JPanel();
        checkerPanel.setMinimumSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
        checkerPanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
        checkerPanel.setMaximumSize(new Dimension(BoardView.boardWidth / 8 + 15, BoardView.boardHeight / 24));
        checkerPanel.setBackground(Color.red);
        checkerPanel.setLayout(new BoxLayout(checkerPanel, BoxLayout.X_AXIS));
        add(checkerPanel);
    }

    /**
     * Dodaje pionek do panelu pionkow
     * 
     * @param c
     *            dodawany komponent
     */
    public void addChecker(final Component c)
    {
        this.checkerPanel.add(c);
    }

    /**
     * Usuwa pionek z panelu pionkow
     * 
     * @param c
     *            usuwany komponent
     */
    public void removeChecker(final Component c)
    {
        this.checkerPanel.remove(c);
    }
}

package pl.edu.pw.elka.proz.msulek.view;

import java.awt.Dimension;

/**
 * Klasa pola Start
 * 
 * @author Maciej Sułek
 */
public final class StartView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = 2472144162673923689L;

    /** panel z obrazem */
    private final ImagePanel startPanel;

    /**
     * Konstruktor klasy StartView
     */
    StartView()
    {
        super();
        startPanel = new ImagePanel("data/start.jpg");
        startPanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 16));
        add(startPanel);
    }
}

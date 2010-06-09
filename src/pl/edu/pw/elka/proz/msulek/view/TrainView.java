package pl.edu.pw.elka.proz.msulek.view;

import java.awt.Dimension;

/**
 * Klasa pola stacji kolejowej
 * 
 * @author Maciej Sułek
 */
public class TrainView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = -1640962791222624398L;

    /** panel z obrazem */
    private final ImagePanel trainPanel;

    /**
     * Konstruktor klasy TrainView
     */
    TrainView()
    {
        super();
        trainPanel = new ImagePanel("data/train.jpg");
        trainPanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 16));
        add(trainPanel);
    }
}
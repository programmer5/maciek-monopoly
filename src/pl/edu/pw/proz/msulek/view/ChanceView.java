package pl.edu.pw.proz.msulek.view;

import java.awt.Dimension;

/**
 * Klasa pola szansa
 * 
 * @author Maciej Sułek
 */
public class ChanceView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = 5397024415847956354L;

    /** panel z obrazem */
    private final ImagePanel chancePanel;

    /**
     * konstruktor klasy ChanceView
     */
    ChanceView()
    {
        super();
        chancePanel = new ImagePanel("data/chance.jpg");
        chancePanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 16));
        add(chancePanel);
    }
}
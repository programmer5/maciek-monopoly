package view;

import java.awt.Dimension;

/**
 * 
 * @author Maciej Sułek
 * Klasa pola szansa
 *
 */
public class ChanceView extends FieldView 
{
	/**	wygenerowane id */
	private static final long serialVersionUID = 5397024415847956354L;
	
	/** panel z obrazem */
	private ImagePanel chancePanel;
	
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
package view;

import java.awt.Dimension;

/**
 * 
 * @author Maciej Sułek
 * Klasa pola ryzyko
 *
 */
public class RiskView extends FieldView 
{
	/**	wygenerowane id */
	private static final long serialVersionUID = -5647847057046709829L;
	
	/** panel z obrazem */
	private ImagePanel riskPanel;
	
	/**
	* konstruktor klasy RiskView
	*/
	RiskView()
	{
		super();
		riskPanel = new ImagePanel("data/risk.jpg");
		riskPanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 16));
		add(riskPanel);
	}
}
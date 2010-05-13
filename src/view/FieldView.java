package view;

import java.awt.Color;
import java.awt.Dimension;

//import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * 
 * @author Maciej Sulek
 * Klasa do wyswietlania pola na planszy
 *
 */

public class FieldView extends JPanel
{
	
	/**	wygenerowane id */
	private static final long serialVersionUID = -2488246611184305744L;
	/** panel z pionkami */
	protected JPanel checkerPanel;
	/** obraz reprezentujacy pole */
	//protected Image fieldImage; 
	
	/**
	 * Konstruktor klasy Field
	 */

	FieldView()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.pink);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 8));
		checkerPanel = new JPanel();
		checkerPanel.setPreferredSize(new Dimension(BoardView.boardWidth / 8, BoardView.boardHeight / 32));
		checkerPanel.setBackground(Color.red);
		//fieldImage
		add(checkerPanel);
	}
}

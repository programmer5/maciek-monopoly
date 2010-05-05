package view;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * 
 * @author Maciej Sulek
 * Klasa do realizowania planszy do gry
 *
 */


public final class Board extends JFrame
{
	/**
	 * 
	 * Konstruktor klasy Board
	 * 
	 */
	Board()
	{
		int _width = 800, _height = 600;
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(_width, _height);
		setTitle("Witaj w grze MONOPOL");
		setLocation(dimension.width / 2 - _width / 2, dimension.height / 2 - _height / 2);
	}
}

package view;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * 
 * @author Maciej Sulek
 * Klasa do realizowania planszy do gry
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
	
	/**
	 * 
	 * Konstruktor klasy Board
	 * 
	 */
	BoardView()
	{
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Witaj w grze MONOPOL");
		boardWidth = dimension.width;
		boardHeight = dimension.height;
		setSize(boardWidth, boardHeight);
		//setLocation(dimension.width / 2 - boardWidth / 2, dimension.height / 2 - boardHeight / 2);
		setLayout(new BorderLayout(0,0));
//		setResizable(false);
//		setUndecorated(true);
	}
	
	/**
	 * 
	 * Funkcja ładująca komponenty
	 * 
	 */
	public void start()
	{
		//tworzenie komponentów
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		gamePanel = new ImagePanel("data/mainbg.jpg");
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
		add(topPanel, BorderLayout.PAGE_START);
		add(bottomPanel, BorderLayout.PAGE_END);
		add(leftPanel, BorderLayout.LINE_START);
		add(rightPanel, BorderLayout.LINE_END);
		add(gamePanel, BorderLayout.CENTER);
//		gamePanel.repaint();
		setVisible(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
	}
	
	/**
	 * 
	 * Funkcja umozliwiająca dodanie komponentu do gornego panelu
	 * 
	 */
	public void addToTopPanel(Component comp) {	topPanel.add(comp);	}

	/**
	 * 
	 * Funkcja umozliwiająca dodanie komponentu do dolnego panelu
	 * 
	 */
	public void addToBottomPanel(Component comp) { bottomPanel.add(comp); }

	/**
	 * 
	 * Funkcja umozliwiająca dodanie komponentu do lewego panelu
	 * 
	 */
	public void addToLeftPanel(Component comp) { leftPanel.add(comp); }
	
	/**
	 * 
	 * Funkcja umozliwiająca dodanie komponentu do prawego panelu
	 * 
	 */
	public void addToRightPanel(Component comp) { rightPanel.add(comp); }
	
	/**
	 * 
	 * Funkcja umozliwiająca dodanie komponentu do panelu gry
	 * 
	 */
	public void addToGamePanel(Component comp) { gamePanel.add(comp); }
	
	/**
	 * 
	 * Funkcja umozliwiająca pobranie szerokosci okna
	 * 
	 */
	int getBoardWidth() { return boardWidth; }
	
	/**
	 * 
	 * Funkcja umozliwiająca pobranie wysokosci okna
	 * 
	 */
	int getBoardHeight() { return boardHeight; }
}

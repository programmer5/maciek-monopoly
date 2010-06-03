package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.events.ExtendEvent;
import controller.listeners.ExtendCloseNewGameListener;
import controller.listeners.ExtendStartNewGameListener;

/**
 * 
 * Klasa okna rozpoczynajacego nowa gre
 * @author Maciej Sulek
 *
 */

public class NewGameView extends JFrame 
{
	/** wygenerowane id */
	private static final long serialVersionUID = 784092313743116688L;

	/** pole nazwy pierwszego gracza */
	private JTextField firstPlayer;
	
	/** pole nazwy drugiego gracza */
	private JTextField secondPlayer;

	/** pole nazwy trzeciego gracza */
	private JTextField thirdPlayer;
	
	/** pole nazwy czwartego gracza  */
	private JTextField fourthPlayer;
	
	/** kolejka blokujaca */
	private BlockingQueue<ExtendEvent> queue;
	
	/** 
	 * konstruktor klasy NewGameView()
	 */
	public NewGameView(BlockingQueue<ExtendEvent> _queue)
	{
		this.queue = _queue;
		int width = 400;
		int height = 200;
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setTitle("Rozpocznij nową grę!");
		setSize(width, height);
		setLocation(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2);
		//tworzenie komponentow
		firstPlayer = new JTextField();
		secondPlayer = new JTextField();
		thirdPlayer = new JTextField();
		fourthPlayer = new JTextField();
		setLayout(new GridLayout(6,6));
		add(new JLabel("Nazwa czwartego gracza:"), 3, 0);
		add(fourthPlayer, 3, 1);
		add(new JLabel("Nazwa trzeciego gracza:"), 2, 0);
		add(thirdPlayer, 2, 1);
		add(new JLabel("Nazwa drugiego gracza:"), 1, 0);
		add(secondPlayer, 1, 1);
		add(new JLabel("Nazwa pierwszego gracza:"), 0, 0);
		add(firstPlayer, 0, 1);
		JButton newGameOk = new JButton("Zaczynamy!");
		newGameOk.addActionListener(new ExtendStartNewGameListener(queue));
		add(newGameOk, 4, 0);
		JButton newGameCancel = new JButton("Może później...");
		newGameCancel.addActionListener(new ExtendCloseNewGameListener(queue));
		add(newGameCancel, 4, 1);
	}
	
	/**
	 * @return the firstPlayer name
	 */
	public String getFirstPlayer() 
	{
		return firstPlayer.getText();
	}

	/**
	 * @return the secondPlayer
	 */
	public String getSecondPlayer() 
	{
		return secondPlayer.getText();
	}

	/**
	 * @return the thirdPlayer
	 */
	public String getThirdPlayer()
	{
		return thirdPlayer.getText();
	}

	/**
	 * @return the fourthPlayer
	 */
	public String getFourthPlayer()
	{
		return fourthPlayer.getText();
	}
}

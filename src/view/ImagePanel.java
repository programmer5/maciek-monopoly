package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * Klasa panelu potrzebnego z obrazkiem
 * @author Maciej Sułek
 *
 */
public class ImagePanel extends JPanel
{
	/** wygenerowane id */
	private static final long serialVersionUID = -6077094369042664625L;
	
	/** obrazek do narysowania */
	private Image img;
	
	/** obiekt wczytujacy obraz */
	private ImageIcon imgico;

	/** 
	 * konstruktor klasy ImagePanel
	 */
	ImagePanel(String path)
	{
		imgico = new ImageIcon(path);
	}
	/**
	 * przeładowanie funkcji paintComponent
	 * @param g grafika do narysowania
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		img = imgico.getImage();
		float tmp = (float)imgico.getIconWidth() / (float)imgico.getIconHeight();
	    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    g.setColor(Color.white);
	    g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(img, 0, 0, (int)(tmp * getHeight()), getHeight(), null);
	}
}
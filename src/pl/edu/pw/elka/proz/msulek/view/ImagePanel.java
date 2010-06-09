package pl.edu.pw.elka.proz.msulek.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Klasa panelu z obrazkiem
 * 
 * @author Maciej Sułek
 */
public class ImagePanel extends JPanel
{
    /** wygenerowane id */
    private static final long serialVersionUID = -6077094369042664625L;

    /** obrazek do narysowania */
    private Image img;

    /** obiekt wczytujacy obraz */
    private final ImageIcon imgico;

    /**
     * Konstruktor klasy ImagePanel
     */
    ImagePanel(final String path)
    {
        imgico = new ImageIcon(path);
    }

    /**
     * Przeładowanie funkcji paintComponent
     * 
     * @param g
     *            grafika do narysowania
     */
    @Override
    public void paintComponent(final Graphics g)
    {
        img = imgico.getImage();
        final float tmp = (float) imgico.getIconWidth() / (float) imgico.getIconHeight();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(img, 0, 0, (int) (tmp * getHeight()), getHeight(), null);
    }
}
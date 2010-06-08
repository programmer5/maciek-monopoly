package pl.edu.pw.proz.msulek.view;

/**
 * 
 * Klasa do wyswietlania pola bez funkcji
 * 
 * @author Maciej Sulek
 * 
 */

public class OtherView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = -2648769278242204903L;

    /** panel z obrazem */
    private final ImagePanel otherPanel;

    /**
     * @param path
     *            sciezka do obrazka
     */
    OtherView(final String path)
    {
        super();
        otherPanel = new ImagePanel(path);
        add(otherPanel);
    }
}

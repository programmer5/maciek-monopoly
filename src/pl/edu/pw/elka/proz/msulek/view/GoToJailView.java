package pl.edu.pw.elka.proz.msulek.view;

/**
 * Klasa do reprezentacji pola 'idziesz do wiezienia'
 * 
 * @author Maciej Sulek
 */

public class GoToJailView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = -7848344962234121335L;

    /** panel z obrazem */
    private final ImagePanel goToJailPanel;

    /**
     * Konstruktor klasy GoToJailView
     */
    GoToJailView()
    {
        super();
        goToJailPanel = new ImagePanel("data/gotojail.jpg");
        add(goToJailPanel);
    }
}

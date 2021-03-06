package pl.edu.pw.elka.proz.msulek.view;

/**
 * Klasa pola zaplaty podatku
 * 
 * @author Maciej Sułek
 */
public class PayFeeView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = 1859405042839160504L;

    /** panel z obrazem */
    private final ImagePanel payFeePanel;

    /**
     * Konstruktor klasy PayFeeView
     */
    PayFeeView()
    {
        super();
        payFeePanel = new ImagePanel("data/payfee.jpg");
        add(payFeePanel);
    }
}
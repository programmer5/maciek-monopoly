package pl.edu.pw.elka.proz.msulek.view;

/**
 * Klasa pola ryzyko
 * 
 * @author Maciej Sułek
 */
public class RiskView extends FieldView
{
    /** wygenerowane id */
    private static final long serialVersionUID = -5647847057046709829L;

    /** panel z obrazem */
    private final ImagePanel riskPanel;

    /**
     * Konstruktor klasy RiskView
     */
    RiskView()
    {
        super();
        riskPanel = new ImagePanel("data/risk.jpg");
        add(riskPanel);
    }
}
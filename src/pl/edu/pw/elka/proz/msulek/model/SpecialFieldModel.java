package pl.edu.pw.elka.proz.msulek.model;

import java.util.Random;

/**
 * Klasa do obsługi pól specjalnych takich jak: szansa, ryzyko, opłata, pójście
 * do więzienia, przejście przez start
 * 
 * @author Maciej Sułek
 */

public final class SpecialFieldModel extends FieldModel
{
    /** stała opisująca status pola jako szansa */
    protected static final short CHANCE = 0;

    /** stała opisująca status pola jako ryzyko */
    protected static final short RISK = 1;

    /** stała opisująca status pola jako opłata */
    protected static final short FEE = 2;

    /** stała opisująca status pola jako pójście do więzienia */
    protected static final short GO_TO_JAIL = 3;

    /** stała opisująca status pola jako bonus za przejście przez start */
    protected static final short START_BONUS = 4;

    /** stała opisująca status pola jako zwykłe pole */
    protected static final short NOTHING = 5;

    /** przechowuje stan pola */
    private final short status;

    /** przechowuje wartość dla pola */
    private final int value;

    /**
     * konstruktor klasy SpecialFieldModel
     * 
     * @param newFieldName
     *            nazwa pola
     * @param newStatus
     *            status tworzonego pola
     */
    public SpecialFieldModel(final String newFieldName, final short newStatus)
    {
        super(newFieldName);
        status = newStatus;
        value = 0;
    }

    /**
     * konstruktor klasy SpecialFieldModel
     * 
     * @param newFieldName
     *            nazwa pola
     * @param newStatus
     *            status tworzonego pola
     * @param newValue
     *            wartość dla pola
     */
    public SpecialFieldModel(final String newFieldName, final short newStatus, final int newValue)
    {
        super(newFieldName);
        status = newStatus;
        value = newValue;
    }

    /**
     * pobieranie statusu
     * 
     * @return status pola
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * pobieranie wartości
     * 
     * @return wartość pola
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Funkcja wywolywana podczas placenia gdy gracz stanie na specjalnym polu
     * 
     * @param value
     *            wartosc pomocnicza
     * @return String[] tablica z kwota do zaplaty lub kwota zysku oraz
     *         komunikatem do wyswietlenia
     */
    @Override
    public String[] pay(final int value)
    {
        final Random rnd = new Random();
        final String[] tmpTable = new String[2];
        int forPay = 0;
        if(status == CHANCE)
        {
            forPay = rnd.nextInt(300) + 150;
            tmpTable[1] = new String("Stanąłeś na szanse! Dostajesz w prezencie " + forPay + " MMM!");
        }
        else if(status == RISK)
        {
            forPay = rnd.nextInt(300) + 150;
            tmpTable[1] = new String("Stanąłeś na ryzyko! Musisz zapłacić " + forPay + " MMM!");
            forPay = -forPay;
        }
        else if(status == FEE)
        {
            forPay = -200;
            tmpTable[1] = new String("Musisz zapłacić podatek dochodowy wysokości: 200 MMM!");
        }
        else if(status == START_BONUS)
        {
            forPay = 1000;
            tmpTable[1] = new String("Stanąłeś na start! Dostajesz wypłatę wysokości " + forPay + " MMM!");
        }
        else if(status == GO_TO_JAIL)
        {
            forPay = rnd.nextInt(3) + 1;
            tmpTable[1] = new String("GO_TO_JAIL");
        }
        else
        {
            forPay = 0;
            tmpTable[1] = new String("");
        }
        tmpTable[0] = new String(String.valueOf(forPay));
        return tmpTable;
    }

}

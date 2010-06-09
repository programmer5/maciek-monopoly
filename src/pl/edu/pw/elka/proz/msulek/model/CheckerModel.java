package pl.edu.pw.elka.proz.msulek.model;

/**
 * Klasa przechowujaca informacje o pionku
 * 
 * @author Maciej Sulek
 */
public class CheckerModel
{
    /** numer pola na ktorym jest pionek */
    private int fieldNumber;

    /**
     * Konstruktor klasy ChckerModel
     */
    CheckerModel()
    {
        fieldNumber = 0;
    }

    /**
     * Zmiana numeru pola o okreslona liczbe
     * 
     * @param moveNumber
     *            liczba pol do pokonania
     * @return fieldNumber nowy numer pola
     */
    public int moveOn(final int moveNumber)
    {
        fieldNumber = (fieldNumber + moveNumber) % 28;
        return fieldNumber;
    }

    /**
     * Zwraca numer pola, na ktory znajduje sie pionek
     * 
     * @return numer pola
     */
    public int getFieldNumber()
    {
        return fieldNumber;
    }

    /**
     * Pozwala zmienic numer pola
     * 
     * @param fieldNumber
     *            nowy numer pola
     */
    public void setFieldNumber(final int fieldNumber)
    {
        this.fieldNumber = fieldNumber;
    }
}

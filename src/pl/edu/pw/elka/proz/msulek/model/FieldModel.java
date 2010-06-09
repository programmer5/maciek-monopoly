package pl.edu.pw.elka.proz.msulek.model;

/**
 * Klasa przechowujaca informacje o polu
 * 
 * @author Maciej Sułek
 */
public class FieldModel
{
    /** nazwa pola */
    protected String fieldName;

    /**
     * Konstruktor klasy FieldModel
     */
    FieldModel()
    {
        fieldName = new String("Field NAME");
    }

    /**
     * Konstruktor klasy FieldModel
     * 
     * @param newFieldName
     *            nazwa pola
     */
    FieldModel(final String newFieldName)
    {
        fieldName = newFieldName;
    }

    /**
     * Zmiana nazwy pola
     * 
     * @param newFieldName
     *            nowa nazwa pola
     */
    public void setFieldName(final String newFieldName)
    {
        fieldName = newFieldName;
    }

    /**
     * Pobranie nazwy pola
     * 
     * @return nazwę pola
     */
    public String getFieldName()
    {
        return fieldName;
    }

    /**
     * Funkcja wywolywana podczas placenia
     * 
     * @param value
     *            wartosc pomocnicza
     * @return String[] tablica z kwota do zaplaty oraz komunikatem do
     *         wyswietlenia
     */
    public String[] pay(final int value)
    {
        final String[] tmpTable = new String[2];
        tmpTable[0] = new String("0");
        tmpTable[1] = new String("0");
        return tmpTable;
    }
}

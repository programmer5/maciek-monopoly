package model;

/**
 * 
 * Klasa do obsługi pól specjalnych takich jak:
 * szansa, ryzyko, opłata, pójście do więzienia, przejście przez start
 * @author Maciej Sułek
 *
 */

public final class SpecialFieldModel extends FieldModel
{
	/** stała opisująca status pola jako szansa*/
	protected static final short CHANCE = 0;
	/** stała opisująca status pola jako ryzyko*/
	protected static final short RISK = 1;
	/** stała opisująca status pola jako opłata*/
	protected static final short FEE = 2;
	/** stała opisująca status pola jako pójście do więzienia*/
	protected static final short GO_TO_JAIL = 3;
	/** stała opisująca status pola jako bonus za przejście przez start*/
	protected static final short START_BONUS = 4;
	/** stała opisująca status pola jako zwykłe pole */
	protected static final short NOTHING = 5;
	/** przechowuje stan pola */
	private short status;
	/** przechowuje wartość dla pola */
	private int value;
	
	/**
	 * konstruktor klasy SpecialFieldModel
	 * @param newFieldName nazwa pola
	 * @param newStatus status tworzonego pola
	 */
	public SpecialFieldModel(String newFieldName, short newStatus)
	{
		super(newFieldName);
		status = newStatus;
		value = 0;
	}
	
	/**
	 * konstruktor klasy SpecialFieldModel
	 * @param newFieldName nazwa pola
	 * @param newStatus status tworzonego pola
	 * @param newValue wartość dla pola
	 */
	public SpecialFieldModel(String newFieldName, short newStatus, int newValue)
	{
		super(newFieldName);
		status = newStatus;
		value = newValue;
	}
	
	/**
	 * pobieranie statusu
	 * @return status pola
	 */
	public int getStatus() { return status; }
	
	/**
	 * pobieranie wartości
	 * @return wartość pola
	 */
	public int getValue() { return value; }
	
}

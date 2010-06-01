package model;

/**
 * 
 * Klasa przechowujaca informacje o polu
 * @author Maciej Sułek
 * 
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
	 * @param newFieldName nazwa pola
	 */
	FieldModel(String newFieldName)
	{
		fieldName = newFieldName;
	}
	
	/** 
	 * Zmiana nazwy pola
	 * @param newFieldName nowa nazwa pola
	 */
	public void setFieldName(String newFieldName) { fieldName = newFieldName; }
	
	/**
	 * Pobranie nazwy pola
	 * @return nazwę pola
	 */
	public String getFieldName() { return fieldName; }
}

package model;

/**
 * Klasa opisujaca pole kolejii
 * @author Maciej Sulek
 */
public class TrainModel extends FieldModel
{
	/** oplata za postoj */
	int stayCost;
	
	/** wlasciciel */
	short owner;
	
	/** cena zakupu */
	int trainCost;
	
	/**
	 * Pobranie kosztu postoju
	 * @return stayCost koszt postoju
	 */
	public int getStayCost()
	{
		return stayCost;
	}

	/**
	 * Zmiana kosztu postoju
	 * @param stayCost nowy koszt postoju
	 */
	public void setStayCost(int stayCost) 
	{
		this.stayCost = stayCost;
	}

	/**
	 * Pobranie wlasciciela
	 * @return owner wlasciciel
	 */
	public short getOwner() 
	{
		return owner;
	}

	/**
	 * Zmiana wlasciciela
	 * @param owner nowy wlasciciel
	 */
	public void setOwner(short owner)
	{
		this.owner = owner;
	}
	
	/**
	 * Pobranie ceny za koleje
	 * @return trainCost cena za koleje
	 */
	public int getTrainCost() 
	{
		return trainCost;
	}

	/**
	 * Zmiana ceny za koleje
	 * @param trainCost nowa cena za kolje
	 */
	public void setTrainCost(int trainCost)
	{
		this.trainCost = trainCost;
	}

	/** 
	 * konstruktor klasy TrainModel
	 */
	public TrainModel()
	{
		super();
		stayCost = 150;
		owner = 0;
		trainCost = 300;
	}
	
	/**
	 * konstruktor klasy TrainModel
	 * @param fieldName nazwa pola
	 */
	public TrainModel(String fieldName)
	{
		super(fieldName);
		stayCost = 150;
		owner = 0;
		trainCost = 300;
	}
	
	/**
	 * Funkcja wywolywana podczas placenia gdy przeciwnik stanie na stacji kolejowej
	 * @param value ilosc stacji kolejowych danego wlasciciela
	 * @return String[] tablica z kwota do zaplaty oraz komunikatem do wyswietlenia
	 */
	public String[] pay(int value)
	{
		String[] tmpTable = new String[2];
		int forPay = value * stayCost;
		tmpTable[0] = new String(String.valueOf(forPay));
		tmpTable[1] = new String("Stanąłeś na stację kolejową. Płacisz: " + tmpTable[0] + ".");
		return tmpTable;
	}
}

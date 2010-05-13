package model;

/**
 * 
 * @author Maciej Sułek
 * Klasa modelu miasta
 *
 */
public final class CityModel extends FieldModel
{
	/** cena miasta */
	private int cityPrice;
	/** opłata za pobyt */
	private int stayCost;
	/** opłata za pobyt gdy miasto ma jeden dom */
	private int stayCost1;
	/** opłata za pobyt gdy miasto ma dwa domy */
	private int stayCost2;
	/** opłata za pobyt gdy miasto ma trzy domy */
	private int stayCost3;
	/** opłata za pobyt gdy miasto ma hotel */
	private int stayCostHotel;
	/** numer dzielnicy */
	private int district;
	/** koszt wybudowania domu */
	private int houseCost;
	/** koszt wybudowania hotelu */
	private int hotelCost;
	/** status miasta - kupione true, do kupienia false */
	private boolean isForBuy;
	
	/**
	 * Kontruktor klasy CityModel
	 */
	public CityModel()
	{
		super();
		isForBuy = true;
	}
	
	/**
	 * Metoda umożliwiająca załadowanie wszystkich danych
	 * @param newFieldName nowa nazwa pola
	 */
	public void updateAll(String newFieldName, int params[])
	{
		fieldName = newFieldName;
		cityPrice = params[0];
		stayCost = params[1];
		stayCost1 = params[2];
		stayCost2 = params[3];
		stayCost3 = params[4];
		stayCostHotel = params[5];
		district = params[6];
		houseCost = params[7];
		hotelCost = params[8];
	}
	
	/**
	 * pobranie ceny za miasto
	 * @return cena za miasto(int)
	 */
	public int getCityPrice() { return cityPrice; }
	
	/**
	 * pobranie opłaty za pobyt
	 * @return opłata za pobyt(int)
	 */
	public int getStayCost() { return stayCost; }
	
	/**
	 * pobranie opłaty za pobyt gdy miasto ma jeden dom
	 * @return opłata za pobyt gdy miasto ma jednen dom(int)
	 */
	public int getStayCost1() { return stayCost1; }
	
	/**
	 * pobranie opłaty za pobyt gdy miasto ma dwa domy
	 * @return opłata za pobyt gdy miasto ma dwa domy(int)
	 */
	public int getStayCost2() { return stayCost2; }
	
	/**
	 * pobranie opłaty za pobyt gdy miasto ma trzy domy
	 * @reuturn opłata za pobyt gdy miasto ma trzy domy(int)
	 */
	public int getStayCost3() { return stayCost3; }
	
	/**
	 * pobranie opłaty za pobyt gdy miasto ma hotel
	 * @return opłata za pobyt gdy miasto ma hotel(int)
	 */
	public int getStayCostHotel() { return stayCostHotel; }
	
	/**
	 * pobranie numeru dzielnicy
	 * @return numer dzielnicy(int)
	 */
	public int getDistrict() { return district; }
	
	/**
	 * pobranie kosztu budowy domu
	 * @return koszt budowy domu(int)
	 */
	public int getHouseCost() { return houseCost; }
	
	/**
	 * pobranie kosztu budowy hotelu
	 * @return koszt budowy hotelu(int)
	 */
	public int getHotelCost() { return hotelCost; }
	
	/**
	 * pobranie statusu miasta
	 * @return status miasta(boolean)
	 * jeśli miasto można kupić zwarca true, w przeciwnym razie false
	 */
	public boolean getCityStatus() { return isForBuy; }
	
	/** 
	 * zmiana statusu miasta
	 * @param status status miasta - true jesli na sprzedarz, false jesli nie
	 */
	public void setCityStatus(boolean newIsForBuy) { isForBuy = newIsForBuy; }
	
}

package model;

/**
 * 
 * Klasa modelu miasta
 * @author Maciej Sułek
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
	
	/** status miasta - do kupienia 0, wartosci 1-4 numer gracza do ktorego nalezy miasto */
	private short owner;
	
	/**
	 * Kontruktor klasy CityModel
	 */
	public CityModel()
	{
		super();
		owner = 0;
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
	 * @return status miasta(short)
	 * jeśli miasto można kupić zwarca 0, w przeciwnym razie wlasciciela
	 */
	public short getCityStatus() { return owner; }
	
	/** 
	 * zmiana statusu miasta
	 * @param status status miasta - 0 jesli na sprzedarz, 1-4 jesli nie
	 */
	public void setCityStatus(short newOwner) { owner = newOwner; }
	
	/**
	 * zwrocenie wszystkich atrybutow jako tablica stringow
	 * @return allParams[] tablica wszystkich parametrow w nastepujace kolejnosci:
	 * fieldName, cityPrice, houseCost, hotelCost, owner, stayCost, stayCost1, stayCost2, stayCost3, stayCostHotel
	 */
	public String[] getAllParams()
	{
		String[] allParams = new String[10];
		allParams[0] = fieldName;
		allParams[1] = String.valueOf(cityPrice);
		allParams[2] = String.valueOf(houseCost);
		allParams[3] = String.valueOf(hotelCost);
		allParams[4] = String.valueOf(owner);
		allParams[5] = String.valueOf(stayCost);
		allParams[6] = String.valueOf(stayCost1);
		allParams[7] = String.valueOf(stayCost2);
		allParams[8] = String.valueOf(stayCost3);
		allParams[9] = String.valueOf(stayCostHotel);
		return allParams;
	}
	
}

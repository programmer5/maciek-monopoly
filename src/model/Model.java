package model;

import java.io.*;

/**
 * @author Maciej Sułek
 * Klasa odpowiedzialna za model gry
 */
public class Model
{
	/** zbior pol */
	private FieldModel field[];
	
	/**
	 * Konstruktor klasy model
	 */
	public Model()
	{
		field = new FieldModel[30];
	}
	
	/**
	 * Inicjalizacja modelu
	 */
	public void initialize()
	{
		int readLine = 0;
		try
		{	
		    FileReader fCities = new FileReader("data/cities.cfg");
		    BufferedReader rCities = new BufferedReader(fCities);
		    CityModel tmpCity;
		    String strLine, tmpCityName;
		    int tmpCityNumber, params[] = new int[9];
		    for(int i = 0; i < 15; ++i)
		    {
		    	//czytanie numeru polu
		    	strLine = rCities.readLine();
		    	if (strLine == null) throw new Exception("Błąd numeru miasta");
		    	tmpCityNumber = Integer.parseInt(strLine);
		    	++readLine;
		    	//czytanie nazwy miasta
		    	strLine = rCities.readLine();
		    	if (strLine == null) throw new Exception("Błąd nazwy miasta");
		    	tmpCityName = strLine;
		    	++readLine;
		    	//czytanie pozostałych parametrów
		    	for(int j = 0; j < 9; ++j)
		    	{
		    		strLine = rCities.readLine();
		    		if (strLine == null) throw new Exception("Błąd parametru " + j);
		    		params[j] = Integer.parseInt(strLine);
		    		++readLine;
		    	}
		    	tmpCity = new CityModel();
		    	tmpCity.updateAll(tmpCityName, params);
		    	field[tmpCityNumber] = tmpCity;
		    }
		    fCities.close();
	    	if (readLine != 165) throw new Exception("Błąd ilości lini");
		}
		catch (Exception e)
		{
			System.out.println("Błąd odczytu pliku - linia: " + (readLine + 1) + " - " + e.getMessage());
		}
		//ładowanie pół specjalnych
		field[0] = new SpecialFieldModel("Start", SpecialFieldModel.START_BONUS, 1500);
		field[3] = new SpecialFieldModel("Szansa", SpecialFieldModel.CHANCE);
		field[7] = new SpecialFieldModel("Parking", SpecialFieldModel.NOTHING);
		field[10] = new SpecialFieldModel("Ryzyko", SpecialFieldModel.RISK);
		field[14] = new SpecialFieldModel("Idziesz do więzienia", SpecialFieldModel.GO_TO_JAIL);
		field[16] = new SpecialFieldModel("Szansa", SpecialFieldModel.CHANCE);
		field[19] = new SpecialFieldModel("Płacisz podatek", SpecialFieldModel.FEE, 250);
		field[21] = new SpecialFieldModel("Odwiedasz więzienie", SpecialFieldModel.NOTHING);
		field[26] = new SpecialFieldModel("Ryzyko", SpecialFieldModel.RISK);
	}
}

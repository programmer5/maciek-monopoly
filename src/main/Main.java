package main;

import view.*;
import model.*;

/**
 * 
 * @author Maciej Sulek
 * Glowna klasa uruchamiajaca poszczegolne elementy
 * 
 */
public class Main
{

	/**
	 * 
	 * @param args argumenty głównej funkcji main
	 * 
	 */
	public static void main(String[] args) 
	{
		Model mainmodel = new Model();
		View mainview = new View();
		mainview.start();
		mainmodel.initialize();
	}

}

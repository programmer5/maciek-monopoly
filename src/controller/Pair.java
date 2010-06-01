package controller;

import java.lang.reflect.Method;

/**
 * 
 * Klasa opisująca parę elementów String-Method
 * @author Maciej Sulek
 * 
 */
public class Pair 
{
	/** określa element, na którym zostanie wykonana operacja */
	private String command;
	
	/** metoda do wykonania */
	private Method method;
	
	/**
	 * Konstruktor
	 * @param command komenda, która jednoznacznie określa element, na którym zostanie wykonana operacja
	 * @param method metoda powiązana z komendą
	 */
	public Pair(String command, Method method)
	{
		this.command = command;
		this.method = method;
	}
	
	/**
	 * Uzyskanie komendy
	 * @return komenda(String)
	 */
	public String getCommand() 
	{
		return command;
	}

	/**
	 * Ustawienie nowej komendy
	 * @param command nowa komenda
	 */
	public void setCommand(String command) 
	{
		this.command = command;
	}

	/**
	 * Uzyskanie dostępu do metody
	 * @return metoda(method)
	 */
	public Method getMethod() 
	{
		return method;
	}

	/**
	 * Ustawienie nowej metody
	 * @param method nowa metoda
	 */
	public void setMethod(Method method) 
	{
		this.method = method;
	}
	
}
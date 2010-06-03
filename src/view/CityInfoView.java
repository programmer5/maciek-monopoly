package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.events.ExtendEvent;
import controller.listeners.ExtendCloseCityInfoListener;

/**
 * Klasa do wyswietlania informacji o miescie
 * @author Maciej Sulek
 */
public class CityInfoView extends JFrame
{
	/** wygenerowane id */
	private static final long serialVersionUID = 941476864956063109L;

	/** nazwa miasta */
	private JLabel cityName;
	
	/** cena miasta */
	private JLabel cityPrice;
	
	/** opłata za pobyt */
	private JLabel stayCost;
	
	/** opłata za pobyt gdy miasto ma jeden dom */
	private JLabel stayCost1;
	
	/** opłata za pobyt gdy miasto ma dwa domy */
	private JLabel stayCost2;
	
	/** opłata za pobyt gdy miasto ma trzy domy */
	private JLabel stayCost3;
	
	/** opłata za pobyt gdy miasto ma hotel */
	private JLabel stayCostHotel;
	
	/** koszt wybudowania domu */
	private JLabel houseCost;
	
	/** koszt wybudowania hotelu */
	private JLabel hotelCost;
	
	/** miasto do kupienia lub własność gracza */
	private JLabel owner;


	/**
	 * Ustawia wyswietlana cene za miasto
	 * @param cityPrice cena miasta do wyswietlania
	 */
	public void setCityPrice(String cityPrice) 
	{
		this.cityPrice.setText(cityPrice);
	}
	
	/**
	 * Ustawia wyswietlana oplate za postoj
	 * @param stayCost oplata za postoj
	 */
	public void setStayCost(String stayCost) 
	{
		this.stayCost.setText(stayCost);
	}
	
	/**
	 * Ustawia wyswietlana oplate za postoj z jednym domem
	 * @param stayCost1 oplata za postoj z jednym domem
	 */
	public void setStayCost1(String stayCost1)
	{
		this.stayCost1.setText(stayCost1);
	}
	
	/**
	 * Ustawia wyswietlana oplate za postoj z dwoma domami
	 * @param stayCost2 oplata za postoj z dwoma domami 
	 */
	public void setStayCost2(String stayCost2) 
	{
		this.stayCost2.setText(stayCost2);
	}
	
	/**
	 * Ustawia wyswietlana oplate za postoj z trzema domami
	 * @param stayCost3 oplata za postoj z trzema domami
	 */
	public void setStayCost3(String stayCost3) 
	{
		this.stayCost3.setText(stayCost3);
	}
	
	/**
	 * Ustawia wyswietlana oplate za postoj z hotelem
	 * @param stayCostHotel the stayCostHotel to set
	 */
	public void setStayCostHotel(String stayCostHotel)
	{
		this.stayCostHotel.setText(stayCostHotel);
	}
	
	/**
	 * Ustawia wyswietlana cene za kupno domu
	 * @param houseCost cena za kupno domu
	 */
	public void setHouseCost(String houseCost) 
	{
		this.houseCost.setText(houseCost);
	}
	
	/**
	 * Ustawia wyswietlana cene za kupno hotelu
	 * @param hotelCost cena za kupno hotelu
	 */
	public void setHotelCost(String hotelCost)
	{
		this.hotelCost.setText(hotelCost);
	}
	
	/**
	 * Ustawia wyswietlanego wlasciciela
	 * @param owner wlasciciel
	 */
	public void setOwner(String owner) 
	{
		this.owner.setText(owner);
	}
	
	/**
	 * Ustawia wyswietlana nazwe miasta
	 * @param cityName nazwa miasta
	 */
	public void setCityName(String cityName)
	{
		this.cityName.setText(cityName);
	}
	
	/** 
	 * Konstruktor klasy CityInfoView
	 */
	CityInfoView(BlockingQueue<ExtendEvent> queue)
	{
		setAlwaysOnTop(true);
		int width = 400, height = 600;
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setLocation(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2);
		setSize(new Dimension(width, height));
		JButton closeInfo = new JButton("Zamknij");
		closeInfo.setName("closeInfoButton");
		closeInfo.addActionListener(new ExtendCloseCityInfoListener(queue));
		cityName = new JLabel();
		cityPrice = new JLabel();
		hotelCost = new JLabel();
		houseCost = new JLabel();
		owner = new JLabel();
		stayCost = new JLabel();
		stayCost1 = new JLabel();
		stayCost2 = new JLabel();
		stayCost3 = new JLabel();
		stayCostHotel = new JLabel();
		setLayout(new GridLayout(11, 2));
		add(new JLabel("Informacje o mieście"));
		add(closeInfo);
		add(new JLabel("Nazwa miasta:"));
		add(cityName);
		add(new JLabel("Cena za miasto:"));
		add(cityPrice);
		add(new JLabel("Cena za kupno domu"));
		add(houseCost);
		add(new JLabel("Cena za kupno hotelu:"));
		add(hotelCost);
		add(new JLabel("Właściciel:"));
		add(owner);
		add(new JLabel("Opłata za pobyt:"));
		add(stayCost);
		add(new JLabel("Opłata za pobyt (1 dom):"));
		add(stayCost1);
		add(new JLabel("Opłata za pobyt (2 domy):"));
		add(stayCost2);
		add(new JLabel("Opłata za pobyt (3 domy):"));
		add(stayCost3);
		add(new JLabel("Opłata za pobyt (hotel):"));
		add(stayCostHotel);
	}

	/**
	 * Aktualizacja wszystkich wyswietlanych napisow
	 * @param allParams tablica z wszystkimi atrybutami w nastepujacej kolejnosci:
	 * cityName, cityPrice, houseCost, hotelCost, owner, stayCost, stayCost1, stayCost2, stayCost3, stayCostHotel
	 */
	public void updateAll(String allParams[])
	{
		cityName.setText(allParams[0]);
		cityPrice.setText(allParams[1]);
		houseCost.setText(allParams[2]);
		hotelCost.setText(allParams[3]);
		owner.setText(allParams[4]);
		stayCost.setText(allParams[5]);
		stayCost1.setText(allParams[6]);
		stayCost2.setText(allParams[7]);
		stayCost3.setText(allParams[8]);
		stayCostHotel.setText(allParams[9]);
	}
}

package br.gextract.domain;

import java.util.ArrayList;

public class BusRoute {
	public int code;
	public String line;
	public String itinerary;
	public String owner;
	public double price;
	public ArrayList<Place> places;
	
	public BusRoute(int code, String line, String itinerary, String owner,
			double price, ArrayList<Place> places) {
		super();
		this.code = code;
		this.line = line;
		this.itinerary = itinerary;
		this.owner = owner;
		this.price = price;
		this.places = places;
	}
	
	public BusRoute(int code, String line, String itinerary, String owner,
			double price) {
		this(code, line, itinerary, owner, price, new ArrayList<Place>());
	}
}

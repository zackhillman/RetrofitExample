package edu.ma.wa.nqueue.retrofitexample;

public class Location {


	private String name;

	private int longitude;
	private int latitude;
	
	public Location(){
		longitude = 0;
		latitude = 0;
		name = "";
	}
	
	public Location(String n, int lon, int lat){
		longitude = lon;
		latitude = lat;
		name = n;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	public int getLongitude(){
		return longitude;
	}
	
	public int getLatitude(){
		return latitude;
	}	
	
	public void setLongitude(int l){
		longitude = l;
	}
	
	public void setLatitude(int l){
		 latitude = l;
	}

	
	
	
}

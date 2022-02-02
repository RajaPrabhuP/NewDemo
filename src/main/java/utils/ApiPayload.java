package utils;

import java.util.Arrays;

import pojo.AddPlacePayload;

public class ApiPayload {

	public AddPlacePayload addPlacePayLoad() {
		pojo.AddPlacePayload addPlace = new pojo.AddPlacePayload();
		addPlace.setAccuracy(50);
		addPlace.setName("Frontline house");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setTypes(Arrays.asList("1","2"));
		addPlace.setWebsite("www.google.com");
		addPlace.setLanguage("Tamil");
		pojo.Location loc = new pojo.Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addPlace.setLocation(loc);
		return addPlace; 
	}
	
	
	public AddPlacePayload addPlacePayLoad(String name, String phonenumber, String address) {
		pojo.AddPlacePayload addPlace = new pojo.AddPlacePayload();
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhone_number(phonenumber);
		addPlace.setAddress(address);
		addPlace.setTypes(Arrays.asList("1","2"));
		addPlace.setWebsite("www.google.com");
		addPlace.setLanguage("Tamil");
		pojo.Location loc = new pojo.Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addPlace.setLocation(loc);
		return addPlace;
	}
	
	
}

package utils;

public enum ResourceAPI {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	UpdatePlaceAPI("/maps/api/place/update/json");
	
	private String resource;
	
	ResourceAPI(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
	

}

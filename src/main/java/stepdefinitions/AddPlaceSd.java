package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ApiPayload;
import utils.ResourceAPI;
import utils.Utility;


public class AddPlaceSd extends Utility {
	
	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	ApiPayload payLoad = new ApiPayload();
	JsonPath js;
	
	@Given("Add Place Payload")
	public void add_place_payload() throws IOException {
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
			System.out.println("Raja Prabhu........");
		  req = given().spec(requestSpecification()).body(payLoad.addPlacePayLoad());		

	}
	
	@Given("Add Place Payload with {string}, {string},{string}")
	public void add_place_payload_with(String name, String phonenumber, String address) throws IOException {
		  req = given().spec(requestSpecification()).body(payLoad.addPlacePayLoad(name,phonenumber,address));
	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		ResourceAPI enumObj = ResourceAPI.valueOf(resource);
		String resourceLoc = enumObj.getResource();
		System.out.println("Resource ------>  "+resourceLoc);
		
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST")) {
		response = req.log().all().post(resourceLoc);
		}else if(method.equalsIgnoreCase("GET")) {
			response = req.log().all().get(resourceLoc);					
		}
	}

	
	
	@Then("the API call success with status code {string}")
	public void the_api_call_success_with_status_code(String string) {
		response = response.then().log().all().spec(resSpec).extract().response();
		assertEquals(response.getStatusCode(), 200);	
		
	}
	@Then("{string} in response body {string}")
	public void in_response_body(String key, String val) {

		String resString = response.asString();
		js = new JsonPath(resString);
		assertEquals(js.get(key), "OK"); 
	}
	
	@Then("Verify the {string} mapped with correct placeId using {string}")
	public void verify_the_mapped_with_correct_place_id_using(String name, String resource) {
	   
		ResourceAPI resourceAPI = ResourceAPI.valueOf(resource);
		String res = resourceAPI.getResource();
		String asString = given().spec(reqSpec).queryParam("place_id", js.get("place_id"))
		.when().get(res).then().extract().asString();
		System.out.println(asString);
		
	}

}

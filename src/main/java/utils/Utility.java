package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	
	public static RequestSpecification reqSpec;

	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec == null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalvariable("baseURL"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addHeader("Content-Type","application/json")
				.build();
		return reqSpec;
		}
		return reqSpec;
	}
	
	public String getGlobalvariable(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\java\\RestAPI\\src\\main\\java\\utils\\global.properties");
		prop.load(fis);
		return prop.getProperty(key); 
	}
	
	public String getJsonPathValue(Response res, String keyValue) {
		
		
		String string = res.toString();
		JsonPath js = new JsonPath(string);
		return js.get(keyValue).toString();
		
	}

}

package com.atmecs.restapi.tests;

import static org.testng.Assert.assertTrue;

import org.codehaus.jettison.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atmecs.restapi.services.CommonFunctionality;
import com.atmecs.restapi.services.RestAPIServices;
import com.sun.jersey.api.client.ClientResponse;

public class TestRestServiceData {

	@BeforeMethod
	public void open() {

		CommonFunctionality.readProperties();
	}

	@Test(priority = 0, description = "Rest API Get Operation",enabled=true)
	public void testGetRestAPI() throws JSONException {
		String source = "3";
		ClientResponse response = RestAPIServices.getTypeRestAPI(source);
		assertTrue(response.getStatus() == 200,
				"Response code is not matching with expected one");
		String json = response.getEntity(String.class);
		System.out.println("response" + json);
		assertTrue(json.contains("3"),
				"The ID value is not matching with expected one");
		assertTrue(json.contains("FIRSTNAME"),
				"The value is not matching with the expected one");
		
		 /** JSONObject json = new JSONObject(response.toString());
		 * assertTrue(json.get("ID").equals("3"),
		 * "The ID value is not matching with expected one");
		 * assertTrue(json.get("FIRSTNAME").equals("yyyy"),
		 * "The value is not matching with the expected one");*/
		 
	}
	
	 @Test(priority = 1, description = "Rest API POST Operation",enabled=false) 
	 public void testPostRestAPI() {
	 String data ="<CUSTOMER  xmlns:xlink='http://www.w3.org/1999/xlink'> <ID>55</ID> <FIRSTNAME>venki</FIRSTNAME><LASTNAME>aaaa</LASTNAME><STREET>20 Upland Pl.</STREET><CITY>HYD</CITY></CUSTOMER>"; 
	 ClientResponse response = RestAPIServices.postTypeRestAPI(data);
	 assertTrue(response.getStatus() == 201,"Response code is not matching with expected one");
	 
	 }
	 

	 @Test(priority = 2, description = "Rest API PUT Operation",enabled=false) 
	 public void  testPutRestAPI() {
		 String source = "100";
	 String data = "<FIRSTNAME>ABCD123</FIRSTNAME>"; 
	 ClientResponse response = RestAPIServices.putTypeRestAPI(source,data); 
	 assertTrue(response.getStatus() == 200, "Response code is not matching with expected one");
	 
	 }
		
	 @Test(priority = 3, description = "Rest API DELETE Operation",enabled=false) 
	 public	 void testDeleteRestAPI() {
	
	 String source = "55"; 
	 ClientResponse response = RestAPIServices.deleteTypeRestAPI(source); 
	 System.out.println("response"+response.getEntity(String.class));
	 assertTrue(response.getStatus() == 200, "Response code is not matching with expected one");
	 assertTrue(response.getEntity(String.class).contains("<deleted>"+source+"</deleted>"));
	  
	 
	  }
	 
}

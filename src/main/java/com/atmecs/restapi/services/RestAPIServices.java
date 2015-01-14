package com.atmecs.restapi.services;

import java.io.File;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestAPIServices {

	// Calling RestAPI using GET method
	public static ClientResponse getTypeRestAPI(String source) {
		
		WebResource resource = CommonFunctionality.getWebResource();
		ClientResponse response = resource
				.path(CommonFunctionality.relativeURI).path("/"+source).get(ClientResponse.class);
		return response;
	}

	// Calling RestAPI using POST method
	public static ClientResponse postTypeRestAPI(String source) {
		WebResource resource = CommonFunctionality.getWebResource();
		//File f = new File(filePath);
		ClientResponse response = resource.path(CommonFunctionality.relativeURI).post(ClientResponse.class,source);
		return response;
	}
	
	// Calling RestAPI using PUT method
	public static ClientResponse putTypeRestAPI(String source,String data) {
		WebResource resource = CommonFunctionality.getWebResource();
		// File f = new File("src/main/resources/xmlData.xml");
		ClientResponse response = resource.path(CommonFunctionality.relativeURI).path("/"+source).post(ClientResponse.class, data);
		return response;
	}
	
	// Calling RestAPI using DELETE method
	public static ClientResponse deleteTypeRestAPI(String source) {
		WebResource resource = CommonFunctionality.getWebResource();
		//File f = new File("src/main/resources/xmlData.xml");
		ClientResponse response = resource.path(CommonFunctionality.relativeURI).path("/" + source).delete(ClientResponse.class);
		return response;
	}
}

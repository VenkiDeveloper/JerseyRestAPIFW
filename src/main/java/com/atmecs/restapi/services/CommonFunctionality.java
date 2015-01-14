package com.atmecs.restapi.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.json.XML;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CommonFunctionality {

	public static String BASE_URI;
	public static String relativeURI;

	// public static String path;
	// reading the values from RestAPIinfo.properties file
	public static void readProperties() {

		Properties prop = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader(new File(
					"src/main/resources/RestAPIinfo.properties"));
			prop.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BASE_URI = prop.getProperty("baseURI");
		relativeURI = prop.getProperty("relativeURI");
		// path = prop.getProperty("path");

		System.out.println("Base URI=" + BASE_URI + " relative URI"
				+ relativeURI);

	}

	// creating WebResources using jersey client API
	public static WebResource getWebResource() {

		Client client = Client.create();
		WebResource resource = client.resource(CommonFunctionality.BASE_URI);
		return resource;
	}

	// converting xml string to json using Json API
	public static JSONObject xmlToJson(String xmlString) {

		JSONObject json = XML.toJSONObject(xmlString);
		return json;
	}

	

}

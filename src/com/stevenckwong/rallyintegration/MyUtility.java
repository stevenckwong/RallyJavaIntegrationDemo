package com.stevenckwong.rallyintegration;

import java.io.IOException;
import java.net.URI;
import com.rallydev.rest.RallyRestApi;

public class MyUtility {
	
	public MyUtility() {
		
	}
	// This method parses the Rally result from logging in and returns the DisplayName
	// field.
	public String parseResultForDisplayName(String result) {
		int startIndex = result.indexOf("\"_refObjectName\": \"");
		startIndex+=19;
		
		int endIndex = result.indexOf("\"", startIndex);
		
		String displayName = result.substring(startIndex, endIndex);
		return displayName;
	}
	
	// This method parses the Rally result from logging in and returns the First name field
	public String parseResultForFirstName(String result) {
		return "Stubbed First Name";
	}
	
	
	public RallyRestApi connectToRallyUsingAPIKey(String apiKey) {
		URI uri = URI.create("https://rally1.rallydev.com");
		RallyRestApi rally = new RallyRestApi(uri,apiKey);
		
		return rally;
	}
	
	public String logTestRunResult(String testID, String testResult, String buildNumber) {
		
		String apiKey = "_CGJbIEnhQDq45u70AWVPFcMsEmGCkO6tZEhYDyg5Dw";

		URI uri = URI.create("https://rally1.rallydev.com");
		
		// RallyRestApi rally = new RallyRestApi(uri, username, password);
		RallyRestApi rally = new RallyRestApi(uri, apiKey);
		
//		String QueryString = "(UserName%20%3D%20"+username+")&start=1&pagesize=20";
//		String queryURL = "/user?query=" + QueryString + "&order=";		

		try {
			rally.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		// Updated this to test out the integration with Rally
		
		return "Success";
	}

}
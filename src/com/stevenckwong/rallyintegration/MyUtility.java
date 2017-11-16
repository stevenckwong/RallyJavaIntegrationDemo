package com.stevenckwong.rallyintegration;

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

}
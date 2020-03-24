package com.pjt.commom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpRestURLConnection {
	
	String clientId = "tLwkswBlPIKX2NrggTYG";
	String clientSecret = "Avnx4de286";
	
	
	public String httpURLConn(String selectQuery, String query) {
		
		BufferedReader br;
		StringBuffer response = null;
		try {
			String uri = "https://openapi.naver.com/v1/search/";
			URL url = new URL(uri+selectQuery+".json?query="+URLEncoder.encode(query, "UTF-8"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = conn.getResponseCode();
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String jsonData;
			response = new StringBuffer();
			while((jsonData = br.readLine()) != null) {
				response.append(jsonData);
			}
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.toString();
	}

}

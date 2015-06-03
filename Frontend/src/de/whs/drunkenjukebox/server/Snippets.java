package de.whs.drunkenjukebox.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gwt.dev.json.JsonObject;

import de.whs.drunkenjukebox.shared.Song;

public class Snippets {
	
	public static JSONObject getJsonObject(String url) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONObject(JsonString);		
		} catch (Exception e) {
			return null;
		}
	}

	public static JSONObject post(String url) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(url);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONObject(JsonString);	
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public static JSONObject put(String url, JSONObject JsonObj) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(url);
			
			 StringEntity params =new StringEntity(JsonObj.toString());
	        request.addHeader("content-type", "application/json");
	        request.setEntity(params);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONObject(JsonString);	
		}
		catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public static JSONArray getJsonArray(String url) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONArray(JsonString);
			
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Song getSongFromID(String songID, String ServerURL) {
		Song song = new Song();
		
		JSONObject currentSong = getJsonObject(ServerURL+"songs/"+songID);
		
		
		try {
			song.setInterpret(currentSong.getString("artist"));
			song.setTitle(currentSong.getString("title"));
			song.setDurationInSecs(Integer.parseInt(currentSong.getString("length")));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song;
	}

}

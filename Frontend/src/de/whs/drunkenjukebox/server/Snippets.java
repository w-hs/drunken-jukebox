package de.whs.drunkenjukebox.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import jdk.nashorn.internal.scripts.JS;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.whs.drunkenjukebox.shared.Song;

public class Snippets {
	private static JSONObject executeRequest(HttpUriRequest request) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				JsonString += line;
			}
			return new JSONObject(JsonString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject getJsonObject(String url) {
		return executeRequest(new HttpGet(url));
	}

	public static JSONObject post(String url) {
		return executeRequest(new HttpPost(url));
	}
	
	public static JSONObject post(String url, JSONObject object) {
		try {
			StringEntity params = new StringEntity(object.toString());

			HttpPost request = new HttpPost(url);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			
			return executeRequest(request);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject put(String url, JSONObject JsonObj) {
		try {
			StringEntity params = new StringEntity(JsonObj.toString());

			HttpPut request = new HttpPut(url);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			
			return executeRequest(request);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject delete(String url) {
		HttpDelete request = new HttpDelete(url);
		return executeRequest(request);
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
				// System.out.println(line);
				JsonString += line;
			}

			return new JSONArray(JsonString);

		} catch (Exception e) {
			return null;
		}
	}

	public static Song getSongFromID(String songID, String ServerURL) {
		JSONObject currentSong = getJsonObject(ServerURL + "songs/" + songID);
		return getSongFromJsonObject(currentSong);
	}

	public static Song getSongFromJsonObject(JSONObject song) {
		Song result = new Song();

		try {
			result.setId(song.getString("id"));
			result.setTitle(song.getString("title"));
			result.setDurationInSecs(song.getInt("length"));
			result.setInterpret(song.getString("artist"));
			result.setSongSource(song.getString("source"));
			result.setSongSourceType(song.getInt("sourceType"));
			result.setGenres(song.getString("genres"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static JSONObject getJsonObjectFrom(Song song) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("id", song.getId());
		object.put("title", song.getTitle());
		object.put("length", song.getDurationInSecs());
		object.put("artist", song.getInterpret());
		object.put("source", song.getSongSource());
		object.put("sourceType", song.getSongSourceTypeInt());
		object.put("genres", song.getGenres());
		
		return object;
	}
}

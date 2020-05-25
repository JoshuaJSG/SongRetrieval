package com.JSG.SongRetrieval.Controllers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchDataController {

        private List<String> albums = new ArrayList<>();
//    private String spotifyURL = "https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF/top-tracks";
//    private String clientID = "e7a2280645cf4fdbb762a4139c7ae8e1";
//    private String clientSecretID = "f57b9e632d124e97a9b25b751c185dc5";
//    private String personalID = "BQAYSaDCrGB5zVx2dZsVia6IlMTnK6PggVBQ72GBGcs0yalve5hTfXrOjNyt4uCBTP6x3Um7edoI_FCeh7pQPbq2pbDNPBif2LjYgdRGK59Piq8oKQ8BCUgivllAiKQGpqLMQWsqMhaEDISq-if3Z3QrtBhwL1okk88";


    public String fetchUrl(String urlString) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println();
        parseJSON(result.toString());
        return result.toString();
    }


    private void parseJSON(String httpResponse){
        String name = "";
        String albumName = "";
        String jsonString = httpResponse.toString();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray contributorsArray = obj.getJSONArray("results");
        for (int i = 0; i < contributorsArray.length()-1; i++) {
            name = contributorsArray.getJSONObject(0).getString("artistName");
            albumName = contributorsArray.getJSONObject(i+1).getString("collectionName");
            albums.add(albumName);
        }
        System.out.println("Albums for "+ name + " are:");
        loopList(albums);

    }



    private void loopList(List<String> albums){
        for (String album : albums) {
            System.out.println(album);
        }
    }

}

package com.JSG.SongRetrieval.Controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchDataController {

    private String URLString = "https://api.deezer.com/album/";



    public void fetchUrlWithId(int id)  {
        String newUrl = URLString+id;
        try {
            fetchUrl(newUrl);
        } catch (Exception e){
            System.out.println("Could not load url due to uncaught exception "
                    +e.getMessage());
        }


    }


    private String fetchUrl(String urlString) throws Exception{
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
        System.out.println(result.toString());
        return result.toString();
    }




}

package com.mycompany.bibliotecafilmes;

import com.mycompany.bibliotecafilmes.model.Filme;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MovieDatabase {
    
    private static final String API_KEY = "9f891cf7";
    private static final String BASE_URL = "http://www.omdbapi.com/";

    public static List<Filme> searchMovies(String searchQuery) {
        List<Filme> filmes = new ArrayList<>();
        try {
            String urlString = BASE_URL + "?apikey=" + API_KEY + "&s=" + searchQuery + "&type=movie";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray searchArray = jsonResponse.getJSONArray("Search");

            for (int i = 0; i < searchArray.length(); i++) {
                JSONObject movieObject = searchArray.getJSONObject(i);
                String title = movieObject.getString("Title");
                String year = movieObject.getString("Year");
                String imdbID = movieObject.getString("imdbID");

                filmes.add(new Filme(title, year, imdbID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmes;
    }
}

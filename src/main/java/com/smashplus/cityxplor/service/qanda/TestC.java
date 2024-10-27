package com.smashplus.cityxplor.service.qanda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestC {
    public static void main(String[] a){
        // Create a neat value object to hold the URL
        URL url = null;
        try {
            url = new URL("https://api.stackexchange.com/2.3/questions/56961628?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=activity&filter=default");
            // Open a connection(?) on the URL(??) and cast the response(???)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");
            // This line makes the request
            InputStream responseStream = connection.getInputStream();
            // Manually converting the response body InputStream to APOD using Jackson
            ObjectMapper mapper = new ObjectMapper();
            Question apod = mapper.readValue(responseStream, Question.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






// Finally we have the response
    }
}

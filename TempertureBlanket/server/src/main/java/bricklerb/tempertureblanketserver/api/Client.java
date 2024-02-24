package bricklerb.tempertureblanketserver.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import bricklerb.tempertureblanketserver.models.Temperature;

public class Client {
    private static URL apiUrl;
    String token = "";

    public Client() {
        super();

        try {
            apiUrl = new URL("https://history.openweathermap.org/");
        } catch (MalformedURLException e) {
        }
    }

    public Client(String token) {
        this();
        this.token = token;
    }

    public List<Temperature> GetTemperaturesForLatLon(double lat, double lon, LocalDate date) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl.toString() + "data/3.0/onecall/day_summary");
        builder.queryParam("lat", lat);
        builder.queryParam("lon", lon);
        builder.queryParam("date", date.toString());
        builder.queryParam("appid", token);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(builder.toUriString()))
                .header("accept", "application/json")
                .build();

        ArrayList<Temperature> temps;
        try {
            var response = client.send(request, null);
            Gson g = new Gson();
            g.fromJson(response.body().toString(), Temperature.class);

        } catch (Exception e) {
        }
    }

}

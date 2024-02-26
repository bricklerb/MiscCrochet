package bricklerb.tempertureblanketserver.api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.time.LocalDate;

import bricklerb.tempertureblanketserver.models.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

public class Client {
    private static URL apiUrl;
    String token = "";

    public Client() {
        super();

        try {
            apiUrl = new URL("https://api.openweathermap.org/");
        } catch (MalformedURLException e) {
        }
    }

    public Client(String token) {
        this();
        this.token = token;
    }

    public DailyAverageTemperature GetTemperaturesForLatLon(double lat, double lon, LocalDate date) {
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

        DailySummaryResponse dailySummaryResponse;
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson g = new Gson();
                dailySummaryResponse = g.fromJson(response.body().toString(), DailySummaryResponse.class);

                var temperature = new DailyAverageTemperature();
                temperature.setLat(lat);
                temperature.setLon(lon);
                temperature.setMax(dailySummaryResponse.max);
                temperature.setMorning(dailySummaryResponse.morning);
                temperature.setMin(dailySummaryResponse.min);
                temperature.setAfternoon(dailySummaryResponse.afternoon);
                temperature.setEvening(dailySummaryResponse.evening);
                return  temperature;

            }
            else if (response.statusCode() == 403) {
                //TODO error here
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public City GetCityFromZip(String zip, String countryCode) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl.toString() + "data/2.5/weather?zip=45431,US&appid={API key}");
        builder.queryParam("zip", zip + "," + countryCode);
        builder.queryParam("appid", token);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(builder.toUriString()))
                .header("accept", "application/json")
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                var currentWeather = gson.fromJson(response.body().toString(), CurrentWeatherResponse.class);

                var city = new City();
                city.setName(currentWeather.name);
                city.setLat(currentWeather.coord.lat);
                city.setLon(currentWeather.coord.lon);

                return city;
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }
}

package pt.ua.tqs.air_polution_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirService {

    private String api_key = "79499cb6bff5492e90e1aaced70a1779";

    public static AirCache airCache = new AirCache();

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public AirCache getAirCache() {
        return airCache;
    }

    public static AirQualityObject readJsonFromUrl(String city, String country) throws IOException, JSONException {
        AirQualityObject airQualityObject = airCache.getAirQuality(city);
        if(airQualityObject != null){
            return airQualityObject;
        }

        String url = "https://api.weatherbit.io/v2.0/current/airquality?city="+city+"&country="+country+"&key=79499cb6bff5492e90e1aaced70a1779";
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            String city_name = (String) json.get("city_name");
            json = json.getJSONArray("data").getJSONObject(0);
            int aqi = (int) json.get("aqi");

            double no2 = (double) json.get("no2");
            double pm10 = (int) json.get("pm10");
            double o3 = (double) json.get("o3");
            double pm25 = (int) json.get("pm25");
            double so2 = (double) json.get("so2");
            int pollen_level_grass = (int) json.get("pollen_level_grass");
            double co = (int) json.get("co");
            int pollen_level_tree = (int) json.get("pollen_level_tree");
            int pollen_level_weed = (int) json.get("pollen_level_weed");

            airQualityObject = new AirQualityObject(aqi, pm10, pm25, o3, so2, no2, co, pollen_level_tree, pollen_level_weed, pollen_level_grass, city_name);
            airCache.addToCache(airQualityObject);

            return airQualityObject;
        }

        finally {
            is.close();
        }


    }

    public static void main(String[] args) throws IOException, JSONException {
        AirQualityObject airQualityObject = readJsonFromUrl("Aveiro", "PT");
        System.out.println(airQualityObject.toString());
        System.out.println(airCache.getCalls());
    }

}

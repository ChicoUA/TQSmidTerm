package pt.ua.tqs.air_polution_project;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AirServiceTest {
    @Autowired
    AirService airService;

    @BeforeEach
    void setUp(){
        airService = new AirService();
        airService.airCache = new AirCache();
    }

    @Test
    void readJsonFromUrlCacheEmpty() throws IOException, JSONException {
        AirQualityObject airQualityObject = airService.readJsonFromUrl("Aveiro", "PT");
        assertEquals(1, airService.airCache.getCalls());
        assertEquals(0, airService.airCache.getHits());
    }

    @Test
    void readJsonFromUrlCacheHasItem() throws IOException, JSONException {
        AirQualityObject airQualityObject = airService.readJsonFromUrl("Aveiro", "PT");
        AirQualityObject airQualityObject2 = airService.readJsonFromUrl("Aveiro", "PT");
        assertEquals(2, airService.airCache.getCalls());
        assertEquals(1, airService.airCache.getHits());
    }
}
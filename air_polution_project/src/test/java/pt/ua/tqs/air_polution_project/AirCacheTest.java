package pt.ua.tqs.air_polution_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class AirCacheTest {
    @Mock
    AirQualityObject airQualityObject;

    @Mock
    AirQualityObject airQualityObject2;

    private AirCache airCache;

    @BeforeEach
    void setUp() {
        AirQualityObject airQualityObject = Mockito.mock(AirQualityObject.class);
        AirQualityObject airQualityObject2 = Mockito.mock(AirQualityObject.class);
        Mockito.when(airQualityObject.getCity_name()).thenReturn("Aveiro");
        Mockito.when(airQualityObject2.getCity_name()).thenReturn("Porto");
        airCache = new AirCache();
    }

    @Test
    void deleteFirst() {
        airCache.addToCache(airQualityObject);
        airCache.addToCache(airQualityObject2);

        int initialSize = airCache.getCache().size();

        airCache.deleteFirst();

        int finalSize = airCache.getCache().size();

        assertEquals(finalSize, initialSize - 1);
    }

    @Test
    void addToCache() {
        airCache.addToCache(airQualityObject2);
        airCache.addToCache(airQualityObject);

        assertEquals(2, airCache.getCache().size());
    }

    @Test
    void getAirQuality() {
        AirQualityObject airQualityObject2 = Mockito.mock(AirQualityObject.class);
        Mockito.when(airQualityObject2.getCity_name()).thenReturn("Porto");
        airCache.addToCache(airQualityObject2);
        AirQualityObject airQualityObject = airCache.getAirQuality("Porto");
        assertEquals(airQualityObject.getCity_name(), "Porto");
        assertEquals(1, airCache.getHits());
        assertEquals(0, airCache.getMisses());
        assertEquals(1, airCache.getCalls());

    }

    @Test
    void getAirQualityMiss(){
        AirQualityObject airQualityObject2 = Mockito.mock(AirQualityObject.class);
        Mockito.when(airQualityObject2.getCity_name()).thenReturn("Porto");
        airCache.addToCache(airQualityObject2);
        AirQualityObject airQualityObject = airCache.getAirQuality("Aveiro");
        assertEquals(airQualityObject, null);
        assertEquals(0, airCache.getHits());
        assertEquals(1, airCache.getMisses());
        assertEquals(1, airCache.getCalls());
    }
}
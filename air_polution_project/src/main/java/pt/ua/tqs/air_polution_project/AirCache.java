package pt.ua.tqs.air_polution_project;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirCache {
    private int hits;
    private int misses;
    private int calls;
    private List<AirQualityObject> cache;

    public AirCache() {
        this.hits = 0;
        this.misses = 0;
        this.calls = 0;
        this.cache = new ArrayList<>();
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }

    public int getCalls() {
        return calls;
    }

    public List<AirQualityObject> getCache() {
        return cache;
    }

    @Scheduled(fixedDelay = 10000)
    public void deleteFirst(){
        System.out.println("Deleting oldest item");
        if(!this.cache.isEmpty()) {
            this.cache.remove(0);
        }
    }

    public void addToCache(AirQualityObject airQualityObject){
        this.cache.add(airQualityObject);
    }

    public AirQualityObject getAirQuality(String cityName){
        AirQualityObject airQualityObject = null;
        for(AirQualityObject aqo : this.cache){
            String cname = aqo.getCity_name();
            if(cname.equalsIgnoreCase(cityName)){
                airQualityObject = aqo;
                break;
            }
        }
        if(airQualityObject != null){
            this.hits += 1;
        }
        else{
            this.misses += 1;
        }
        this.calls += 1;

        return airQualityObject;
    }
}

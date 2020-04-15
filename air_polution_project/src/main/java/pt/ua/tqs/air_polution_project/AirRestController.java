package pt.ua.tqs.air_polution_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AirRestController {
    @Autowired
    AirService airService;

    @GetMapping(value = "/airdata/{country}/{city}", produces = "application/json")
    public AirQualityObject getData(@PathVariable String country, @PathVariable String city) throws IOException {
        return airService.readJsonFromUrl(city, country);
    }

    @GetMapping("/CacheData/hits")
    public int getHits(){
        return airService.airCache.getHits();
    }

    @GetMapping("/CacheData/Misses")
    public int getMisses(){
        return airService.airCache.getMisses();
    }

    @GetMapping("/CacheData/Calls")
    public int getCalls(){
        return airService.airCache.getCalls();
    }
}

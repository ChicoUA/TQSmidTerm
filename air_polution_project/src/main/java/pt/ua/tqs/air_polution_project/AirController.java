package pt.ua.tqs.air_polution_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class AirController {
    @Autowired
    private AirService airService;

    @PostMapping("/greeting")
    public String getAirQualityForCity(@ModelAttribute Greeting greeting, Model model) throws IOException {
        AirQualityObject airQualityObject = AirService.readJsonFromUrl(greeting.getCity(), greeting.getCountry());
        model.addAttribute("aqi", airQualityObject.getAir_quality_index());
        model.addAttribute("pm10", airQualityObject.getPm10());
        model.addAttribute("pm25", airQualityObject.getPm25());
        model.addAttribute("o3", airQualityObject.getO3());
        model.addAttribute("so2", airQualityObject.getSo2());
        model.addAttribute("no2", airQualityObject.getNo2());
        model.addAttribute("co", airQualityObject.getCo());
        model.addAttribute("plt", airQualityObject.getPollen_level_tree());
        model.addAttribute("plg", airQualityObject.getPollen_level_grass());
        model.addAttribute("plw", airQualityObject.getPollen_level_weed());
        System.out.println(greeting.getCity());
        return "result";
    }

    @GetMapping("/greeting")
    public String getIndex(Model model){
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
}

package pl.kuba.weather.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import pl.kuba.weather.models.WetherModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {



    @GetMapping({"/","/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @PostMapping("/")
    public ModelAndView postIndex(@RequestParam String city){
        ModelAndView modelAndView = new ModelAndView("show");
        RestTemplate restTemplate = new RestTemplate();
        String link =  "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=d7f6e7ee2ac680175253256fb0ba1a47";
        WetherModel models = null;
        try {
            models = restTemplate.getForObject(link, WetherModel.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        if (models != null) {
            for (WetherModel.Weather weather : models.getWeather()) {
                if (weather!=null) {
                    modelAndView.addObject("o",weather.getIcon());
                }
            }
            String city1 = city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();
            modelAndView.addObject("city",city1);
            modelAndView.addObject("temp",models.getMain().getTemp()-273.15);
            modelAndView.addObject("pressure",models.getMain().getPressure());

    }
    return modelAndView;
}}


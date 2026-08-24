package com.example.ClimaAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {

    private String consultarURL(String apiUrl){
        String dados ="";
        RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        } else{
            dados = "Falha ao obter dados. Cód status: " + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarClima() {
        return consultarURL("https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378&daily=temperature_2m_max,temperature_2m_min,weather_code&hourly=temperature_2m,wind_speed_10m,relative_humidity_2m,wind_direction_10m&timezone=auto&forecast_days=1");
    }

}

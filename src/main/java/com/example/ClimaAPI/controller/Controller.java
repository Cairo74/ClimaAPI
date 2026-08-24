package com.example.ClimaAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ClimaAPI.service.Service;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Controller {

    Service service = new Service();
    @GetMapping("/clima")
    public String consultarClima() {
        return service.consultarClima();
    }


    

}

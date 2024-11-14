package com.example.CRUD.Consumo.API.CORREIOS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/statusConexao")
    public String checar (){
        return "TUDO CERTO";
    }
}

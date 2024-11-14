package com.example.CRUD.Consumo.API.CORREIOS.model;


import lombok.Data;

@Data
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}

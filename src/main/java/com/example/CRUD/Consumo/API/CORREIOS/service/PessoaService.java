package com.example.CRUD.Consumo.API.CORREIOS.service;

import com.example.CRUD.Consumo.API.CORREIOS.model.Endereco;
import com.example.CRUD.Consumo.API.CORREIOS.model.Pessoa;
import com.example.CRUD.Consumo.API.CORREIOS.repository.PessoaRepository;
import com.example.CRUD.Consumo.API.CORREIOS.repository.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ViaCepClient viaCepClient;

    @Transactional
    public Pessoa salvarPessoa(Pessoa pessoa) {
        // Consultar o endereço pelo CEP
        Endereco endereco = viaCepClient.consultarCep(pessoa.getCep());
        pessoa.setEndereco(endereco.getLogradouro() + ", " + endereco.getBairro() + ", " + endereco.getLocalidade() + " - " + endereco.getUf());
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }
}


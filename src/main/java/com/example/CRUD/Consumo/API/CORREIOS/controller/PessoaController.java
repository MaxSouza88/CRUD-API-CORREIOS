package com.example.CRUD.Consumo.API.CORREIOS.controller;

import com.example.CRUD.Consumo.API.CORREIOS.service.PessoaService;
import com.example.CRUD.Consumo.API.CORREIOS.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        try {
            Pessoa novaPessoa = pessoaService.salvarPessoa(pessoa);
            return ResponseEntity.ok(Collections.singletonMap(HttpStatus.OK, "Pessoa cadastrada com sucesso!")); //Cadastro positivo
        }
    catch (ConstraintViolationException e) {
        // Cria uma resposta mais detalhada com a lista de violações
        Map<String, String> erros = new HashMap<>();
        e.getConstraintViolations().forEach(violation -> {
            erros.put(violation.getPropertyPath().toString(), violation.getMessage());
        });
        return ResponseEntity.badRequest().body(erros);
    }
    catch (Exception e) {
        // Captura outras exceções e retorna uma mensagem genérica
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno ao processar a requisição.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id) {
        if (id != null || id > 0) {
            Pessoa pessoa = pessoaService.buscarPessoa(id);
            return ResponseEntity.ok(pessoa);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        if (id !=null || id>0) {
            pessoaService.deletarPessoa(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }
}


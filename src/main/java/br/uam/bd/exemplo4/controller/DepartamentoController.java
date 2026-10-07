package br.uam.bd.exemplo4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uam.bd.exemplo4.model.Departamento;
import br.uam.bd.exemplo4.repository.DepartamentoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/apia/departamentos")
public class DepartamentoController {
    private DepartamentoRepository repository;


    public DepartamentoController (DepartamentoRepository repository) {

        this.repository = repository;
    }

@GetMapping 
public List<Departamento> listarTodos(){
    return repository.findAll(); 
}

@PostMapping 
@ResponseStatus (HttpStatus.CREATED)
public Departamento criar(@RequestBody @Valid Departamento departamento) {
        return repository.save(departamento);
}
}







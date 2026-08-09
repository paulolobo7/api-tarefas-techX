package com.example.demo.controller;


import com.example.demo.model.Tarefa;
import com.example.demo.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;
    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@Valid @RequestBody Tarefa tarefa) {
        Tarefa tarefaCriada = tarefaService.create(tarefa);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tarefaCriada);
    }

    @GetMapping
    public List<Tarefa> listTarefa(){

        return tarefaService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarefaService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Tarefa getById(@PathVariable Long id) {
        return tarefaService.getById(id);
    }

    @PutMapping("/{id}")
    public Tarefa update(
            @PathVariable Long id,
            @RequestBody @Valid Tarefa tarefa
    ) {
        return tarefaService.update(id, tarefa);
    }


}

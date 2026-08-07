package com.example.demo.controller;


import com.example.demo.model.Tarefa;
import com.example.demo.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;
    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping("/create")
    public Tarefa createTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.create(tarefa);
    }

    @GetMapping
    public List<Tarefa> listTarefa(){
        return tarefaService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }



}

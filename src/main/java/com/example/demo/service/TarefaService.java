package com.example.demo.service;

import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    @Autowired
    private  TarefaRepository tarefaRepository;
    
    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> getAll(){
        return tarefaRepository.findAll();
    }

    public Tarefa create(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void delete(Long id){
        tarefaRepository.deleteById(id);
    }
}

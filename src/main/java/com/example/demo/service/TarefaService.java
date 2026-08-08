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
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }

        tarefaRepository.deleteById(id);
    }

    public Tarefa getById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa update(Long id, Tarefa dadosAtualizados) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setNome(dadosAtualizados.getNome());
        tarefa.setDescricao(dadosAtualizados.getDescricao());
        tarefa.setLembrete(dadosAtualizados.getLembrete());
        tarefa.setDataEntrega(dadosAtualizados.getDataEntrega());
        tarefa.setStatus(dadosAtualizados.getStatus());
        tarefa.setPrioridade(dadosAtualizados.getPrioridade());
        tarefa.setTipoAtividade(dadosAtualizados.getTipoAtividade());

        return tarefaRepository.save(tarefa);
    }
}

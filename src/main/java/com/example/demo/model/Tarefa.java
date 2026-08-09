package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da tarefa é obrigatório")
    private String nome;

    private String descricao;

    private String lembrete;

    private LocalDate dataEntrega;

    @NotNull(message = "O status da tarefa é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "A prioridade da tarefa é obrigatória")
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @NotNull(message = "O tipo da atividade é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;
}

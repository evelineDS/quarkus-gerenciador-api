package br.exemplo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String titulo;
    public String descricao;
    public LocalDate prazo;
    public String departamento;
    public int duracao; // em horas
    public boolean finalizada;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    public Pessoa pessoa;
}

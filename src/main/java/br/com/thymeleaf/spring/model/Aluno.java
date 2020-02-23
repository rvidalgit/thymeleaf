package br.com.thymeleaf.spring.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    private UUID id;

    @NotNull(message = "Nome do aluno deve ser informado")
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull(message = "A idade do aluno deve ser informado")
    @Column(precision = 0)
    private int idade;

    @NotNull(message = "A instituição do aluno deve ser informado")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
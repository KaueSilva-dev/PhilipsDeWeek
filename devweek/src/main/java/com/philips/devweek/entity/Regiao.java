package com.philips.devweek.entity;
import javax.persistence.*;
@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String regiao;
    private Long quantidade_exames;

    public Regiao(Long id, String regiao, Long quantidade_exames) {
        this.id = id;
        this.regiao = regiao;
        this.quantidade_exames = quantidade_exames;
    }
    public Regiao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getQuantidade_exames() {
        return quantidade_exames;
    }

    public void setQuantidade_exames(Long quantidade_exames) {
        this.quantidade_exames = quantidade_exames;
    }
}

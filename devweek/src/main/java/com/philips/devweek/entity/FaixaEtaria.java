package com.philips.devweek.entity;
import javax.persistence.*;
@Entity
public class FaixaEtaria {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long faixa_i;
    private Long faixa_f;
    private String descricao;

    public FaixaEtaria(Long faixa_i, Long faixa_f, String descricao) {
        this.faixa_i = faixa_i;
        this.faixa_f = faixa_f;
        this.descricao = descricao;
    }
    public FaixaEtaria(){};

    public Long getId() {
        return id;
    }

    public Long getFaixa_i() {
        return faixa_i;
    }

    public void setFaixa_i(Long faixa_i) {
        this.faixa_i = faixa_i;
    }

    public Long getFaixa_f() {
        return faixa_f;
    }

    public void setFaixa_f(Long faixa_f) {
        this.faixa_f = faixa_f;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

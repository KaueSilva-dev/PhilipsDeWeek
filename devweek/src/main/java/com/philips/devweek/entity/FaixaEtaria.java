package com.philips.devweek.entity;
import javax.persistence.*;
@Entity
public class FaixaEtaria {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

}

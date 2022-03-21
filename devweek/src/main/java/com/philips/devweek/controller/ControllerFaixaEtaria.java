package com.philips.devweek.controller;

import com.philips.devweek.entity.FaixaEtaria;
import com.philips.devweek.repository.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {
    private FaixaEtariaRepo fRepository;

    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.fRepository = frepository;
    }
    @GetMapping("/faixaetaria")
    public ResponseEntity<?> FindAllFaixaEtaria() {
        try {
            List<FaixaEtaria> lista = fRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?>FindByIdFaixaEtaria(@PathVariable long id) {
     try {
         Optional<FaixaEtaria> unidOption = fRepository.findById(id);
         if (unidOption.isPresent()) {
             FaixaEtaria faixaEtariaUnid = unidOption.get();
             return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria postFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria){
        return fRepository.save(newFaixaEtaria);
    }
    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id){
        fRepository.deleteById(id);
    }
}

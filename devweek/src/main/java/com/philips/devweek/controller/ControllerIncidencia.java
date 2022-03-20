package com.philips.devweek.controller;

import com.philips.devweek.entity.FaixaEtaria;
import com.philips.devweek.entity.Incidencia;
import com.philips.devweek.repository.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerIncidencia {
    private IncidenciaRepo iRepository;

    public ControllerIncidencia(IncidenciaRepo iRepository) {
        this.iRepository = iRepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<?> FindAllincidencia() {
            List<Incidencia> lista = iRepository.findAll();
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/incidencia/{id}")
    public ResponseEntity<?>FindByIdIncidencia(@PathVariable long id) {
        Optional<Incidencia> unidOption = iRepository.findById(id);
        if (unidOption.isPresent()) {
            Incidencia incidenciaUnid = unidOption.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/incidencia/novo")
    public Incidencia postIncidencia(@RequestBody Incidencia newIncidencia){
        return iRepository.save(newIncidencia);
    }
    @DeleteMapping("/incidencia/delete/{id}")
    public void deleteIncidencia(@PathVariable Long id){
        iRepository.deleteById(id);
    }
}

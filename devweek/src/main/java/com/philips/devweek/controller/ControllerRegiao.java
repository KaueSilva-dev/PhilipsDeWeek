package com.philips.devweek.controller;

import com.philips.devweek.entity.Regiao;
import com.philips.devweek.repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {
    private final RegiaoRepo repository;
    public ControllerRegiao(RegiaoRepo repository){
        this.repository = repository;
    }
    @GetMapping("/regiao")
    public List<Regiao> GetRegiao(){
        return repository.findAll();
    }
    @GetMapping("regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional reigaoOptional = repository.findById(id);
        if(reigaoOptional.isPresent()){
            Object regiaoEscolhida = reigaoOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/regiao/novo")
    public Regiao postRegiao(@RequestBody Regiao newRegiao){
        return repository.save(newRegiao);
    }
    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }

}

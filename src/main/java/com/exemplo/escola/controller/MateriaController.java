package com.exemplo.escola.controller;

import com.exemplo.escola.entity.Materia;
import com.exemplo.escola.exception.MateriaInexistenteException;
import com.exemplo.escola.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    MateriaRepository materiaRepository;

    @PostMapping
    public Materia incluir(@RequestBody Materia materia){
        return materiaRepository.save(materia);
    }

    @GetMapping("/{id}")
    public Materia consultar(@PathVariable("id") Long id){
        return materiaRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Materia atualizar(@PathVariable("id") Long id, @RequestBody Materia materiaRequest){
        Materia materiaBanco = materiaRepository.findById(id).orElseThrow();

        materiaBanco.setDescricao(materiaRequest.getDescricao());

        return materiaRepository.save(materiaBanco);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id){
        Materia materiaBanco = materiaRepository.findById(id).orElseThrow(MateriaInexistenteException::new);

        materiaRepository.delete(materiaBanco);
    }

}

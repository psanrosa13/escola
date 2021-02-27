package com.exemplo.escola.controller;

import com.exemplo.escola.entity.Professor;
import com.exemplo.escola.exception.ProfessorInexistenteException;
import com.exemplo.escola.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

        @Autowired
        ProfessorRepository professorRepository;

        @PostMapping
        public Professor incluir(@RequestBody Professor professor){
        return professorRepository.save(professor);
    }

        @GetMapping("/{id}")
        public Professor consultar(@PathVariable("id") Long id){
        return professorRepository.findById(id).orElseThrow();
    }

        @PutMapping("/{id}")
        public Professor atualizar(@PathVariable("id") Long id, @RequestBody Professor professorRequest){
        Professor professorBanco = professorRepository.findById(id).orElseThrow();

        professorBanco.setNome(professorRequest.getNome());

        return professorRepository.save(professorBanco);
    }

        @DeleteMapping("/{id}")
        public void excluir(@PathVariable("id") Long id){
        Professor professorBanco = professorRepository.findById(id).orElseThrow(ProfessorInexistenteException::new);

        professorRepository.delete(professorBanco);
    }


}

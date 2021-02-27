package com.exemplo.escola.controller;


import com.exemplo.escola.entity.Turma;
import com.exemplo.escola.exception.TurmaInexistenteException;
import com.exemplo.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    @PostMapping
    public Turma incluir(@RequestBody Turma turma){return turmaRepository.save(turma);}

    @GetMapping("/{id}")
    public Turma consultar(@PathVariable("id") Long id){
        return turmaRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Turma atualizar(@PathVariable("id") Long id, @RequestBody Turma turmaRequest){
        Turma turmaBanco = turmaRepository.findById(id).orElseThrow();

        turmaBanco.setDescricao(turmaRequest.getDescricao());

        return turmaRepository.save(turmaBanco);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id){
        Turma turmaBanco = turmaRepository.findById(id).orElseThrow(TurmaInexistenteException::new);

        turmaRepository.delete(turmaBanco);
    }

}

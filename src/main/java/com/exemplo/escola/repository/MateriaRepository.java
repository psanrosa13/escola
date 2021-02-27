package com.exemplo.escola.repository;

import com.exemplo.escola.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

   Materia findByDescricao(String descricao);
}

package com.exemplo.escola.repository;

import com.exemplo.escola.entity.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long> {
}

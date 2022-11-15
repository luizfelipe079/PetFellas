package com.petfellas.petfellas.repositories;

import com.petfellas.petfellas.model.Dono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Long> {
}

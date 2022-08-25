package com.mercuryservices.ficheservice.repository;

import com.mercuryservices.ficheservice.model.Fiche;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FicheRepository extends JpaRepository<Fiche, Long> {
    Fiche findByFicheId(String ficheId);
}

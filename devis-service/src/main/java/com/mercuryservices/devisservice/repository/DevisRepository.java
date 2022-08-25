package com.mercuryservices.devisservice.repository;

import com.mercuryservices.devisservice.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DevisRepository extends JpaRepository<Devis, Long> {

    Devis findByDevisId(String devisId);
    List<Devis> findDevisByFicheId(String ficheId);

}

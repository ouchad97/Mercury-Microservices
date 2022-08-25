package com.mercuryservices.devisservice.service;

import com.mercuryservices.devisservice.model.Devis;
import com.mercuryservices.devisservice.dto.DevisRequest;

import java.util.List;

public interface DevisService {

    Devis createDevis (DevisRequest devisRequest, String ficheId);
    DevisRequest findDevisByDevisId(String devisId);

    List<DevisRequest> findDevisByFicheId(String ficheId);

    Devis updateDevis (Devis devis, String devisId);

    void deleteDevis(String devisId);
}

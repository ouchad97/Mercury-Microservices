package com.mercuryservices.ficheservice.service;


import com.mercuryservices.ficheservice.dto.FicheRequest;


public interface FicheService {

    void createFiche (FicheRequest ficheRequest);
    FicheRequest findFicheByFicheId(String ficheId);

  //  void updateFiche (String ficheId, FicheRequest ficheRequest);

}

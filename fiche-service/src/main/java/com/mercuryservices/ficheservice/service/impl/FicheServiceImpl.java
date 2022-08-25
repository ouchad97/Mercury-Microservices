package com.mercuryservices.ficheservice.service.impl;

import com.mercuryservices.ficheservice.Utils.Utils;
import com.mercuryservices.ficheservice.dto.FicheRequest;
import com.mercuryservices.ficheservice.dto.FicheResponse;
import com.mercuryservices.ficheservice.model.Fiche;
import com.mercuryservices.ficheservice.repository.FicheRepository;
import com.mercuryservices.ficheservice.service.FicheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FicheServiceImpl  implements FicheService {

    @Autowired
    FicheRepository ficheRepository;

    @Autowired
    Utils util;

    @Override
    public void createFiche(FicheRequest ficheRequest) {

        /**TO DO : Get Random ID fiche**/
        /*
            Fiche fiche = new Fiche();
            fiche.setFicheId((UUID.randomUUID().toString()));
        */
        Fiche ficheEntity = Fiche.builder()
                .ficheId(ficheRequest.getFicheId())
                .datecreationFiche(ficheRequest.getDatecreationFiche())
                .libelleFiche(ficheRequest.getLibelleFiche())
                .build();
        ficheRepository.save(ficheEntity);
        log.info("Fiche {} is saved", ficheEntity.getFicheId());

    }



    public List<FicheResponse> getAllFiche() {
        List<Fiche> fiches = ficheRepository.findAll();

         return fiches.stream()
                 .map(this::mapToFicheResponse)
                 .toList();
    }

    private FicheResponse mapToFicheResponse(Fiche ficheEntity) {
        return FicheResponse.builder()
                .idFiche(ficheEntity.getIdFiche())
                .ficheId(ficheEntity.getFicheId())
                .datecreationFiche(ficheEntity.getDatecreationFiche())
                .libelleFiche(ficheEntity.getLibelleFiche())
                .build();
    }


    @Override
    public FicheRequest findFicheByFicheId(String ficheId) {

        Fiche ficheEntity = ficheRepository.findByFicheId(ficheId);
        FicheRequest ficheReq = new FicheRequest();
        BeanUtils.copyProperties(ficheEntity, ficheReq);
        return ficheReq;
    }

}

package com.mercuryservices.devisservice.service.Impl;

import com.mercuryservices.devisservice.dto.DevisRequest;
import com.mercuryservices.devisservice.dto.DevisResponse;
import com.mercuryservices.devisservice.feign.FicheRestClient;
import com.mercuryservices.devisservice.model.Devis;
import com.mercuryservices.devisservice.model.Fiche;
import com.mercuryservices.devisservice.repository.DevisRepository;
import com.mercuryservices.devisservice.service.DevisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DevisServiceImpl implements DevisService {
    @Autowired
    FicheRestClient ficheRestClient;
    @Autowired
    DevisRepository devisRepository;


    @Override
    public Devis createDevis(DevisRequest devisRequest, String ficheId) {

        Devis devisEntity = new Devis();
        BeanUtils.copyProperties(devisRequest, devisEntity);

        /***Fiche***/
        Fiche fiche = ficheRestClient.getFicheByFicheId(ficheId);
        devisEntity.setFicheId(fiche.getFicheId());

        Devis newDevis = devisRepository.save(devisEntity);
        Devis devisNew = new Devis();
        BeanUtils.copyProperties(newDevis, devisNew);

        return devisEntity;

    }

    @Override
    public DevisRequest findDevisByDevisId(String devisId) {

        Devis devisEntity = devisRepository.findByDevisId(devisId);
        DevisRequest devisReq = new DevisRequest();
        BeanUtils.copyProperties(devisEntity, devisReq);

        /***Fiche***/ //You can comment methode below to get just idfiche
        Fiche fiche = ficheRestClient.getFicheByFicheId(devisReq.getFicheId());
        devisReq.setFiche(fiche);
        return devisReq;
    }


    @Override
    public List<DevisRequest> findDevisByFicheId(String ficheId) {

        List<Devis> devisEntity = (List<Devis>)devisRepository.findDevisByFicheId(ficheId);
        List<DevisRequest> devisReq = new ArrayList<DevisRequest>();

        for(Devis devislist: devisEntity) {
            DevisRequest devisDto= new DevisRequest();
            BeanUtils.copyProperties(devislist, devisDto);
            devisReq.add(devisDto);
        }
        return devisReq;
    }

    @Override
    public Devis updateDevis(Devis devis, String devisId) {

        Devis devisEntity = devisRepository.findByDevisId(devisId);

        if (devisEntity == null)
            System.out.println("****** There is no devis with this id ******");

        devisEntity.setLibelleDevis(devis.getLibelleDevis());
        Devis devisUpdate = devisRepository.save(devisEntity);
        Devis devisnew = new Devis();
        BeanUtils.copyProperties(devisUpdate, devisnew);
        return devisnew;
    }

    @Override
    public void deleteDevis(String devisId) {

        Devis devisEntity  = devisRepository.findByDevisId(devisId);
        if (devisEntity == null)
            System.out.println("****** There is no devis with this id ******");
        devisRepository.delete(devisEntity);
    }


    public List<DevisResponse> getAllDevis(){
        List<Devis> devisList = devisRepository.findAll();
        return devisList.stream()
              .map(this::mapToDevisResponse)
              .toList();
    }
    private DevisResponse mapToDevisResponse(Devis devisEntity) {

        /***Fiche***/ //You can comment methode below to get just idfiche
        Fiche ficheEnt = ficheRestClient.getFicheByFicheId(devisEntity.getFicheId());
        devisEntity.setFiche(ficheEnt);
        return DevisResponse.builder()
                .idDevis(devisEntity.getIdDevis())
                .devisId(devisEntity.getDevisId())
                .datecreationDevis(devisEntity.getDatecreationDevis())
                .libelleDevis(devisEntity.getLibelleDevis())

                /***Fiche***/
                //If you want get just fiche ID enable this
                //.ficheId(devisEntity.getFicheId())
                // Don't forget to comment List of fiche below
                .fiche(ficheEnt)
                .build();
    }

}

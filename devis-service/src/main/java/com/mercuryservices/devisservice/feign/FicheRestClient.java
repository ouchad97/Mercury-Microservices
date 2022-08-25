package com.mercuryservices.devisservice.feign;

import com.mercuryservices.devisservice.model.Fiche;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8081/api/fiche" ,name="FICHE-SERVICE")
public interface FicheRestClient {

    @GetMapping(path="/{ficheId}")
    Fiche getFicheByFicheId(@PathVariable(name="ficheId") String ficheId);

}
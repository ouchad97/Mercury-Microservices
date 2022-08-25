package com.mercuryservices.contractservice.feign;

import com.mercuryservices.contractservice.model.Devis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8082/api/devis/" ,name="DEVIS-SERVICE")
public interface DevisRestClient {

    @GetMapping(path="/{devisId}")
    Devis getDevisByDevisId(@PathVariable(name="devisId") String devisId);

}
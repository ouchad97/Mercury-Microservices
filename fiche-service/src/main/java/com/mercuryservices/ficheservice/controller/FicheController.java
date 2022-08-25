package com.mercuryservices.ficheservice.controller;

import com.mercuryservices.ficheservice.service.impl.FicheServiceImpl;
import com.mercuryservices.ficheservice.dto.FicheRequest;
import com.mercuryservices.ficheservice.dto.FicheResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fiche")
@RequiredArgsConstructor
public class FicheController {

    private final FicheServiceImpl ficheServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFiche(@RequestBody FicheRequest ficheRequest) {

        ficheServiceImpl.createFiche(ficheRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FicheResponse> getAllFiches() {
        return ficheServiceImpl.getAllFiche();
    }


    @GetMapping(path = "/{ficheId}")
    public ResponseEntity<FicheResponse> getFicheByFicheId(@PathVariable String ficheId) {

        FicheRequest ficheReq = ficheServiceImpl.findFicheByFicheId(ficheId);
        FicheResponse ficheResponse = new FicheResponse();
        BeanUtils.copyProperties(ficheReq, ficheResponse);
        return new ResponseEntity<FicheResponse>(ficheResponse, HttpStatus.OK);

    }
}

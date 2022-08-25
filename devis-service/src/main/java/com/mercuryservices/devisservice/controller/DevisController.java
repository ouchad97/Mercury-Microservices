package com.mercuryservices.devisservice.controller;

import com.mercuryservices.devisservice.model.Devis;
import com.mercuryservices.devisservice.dto.DevisRequest;
import com.mercuryservices.devisservice.dto.DevisResponse;
import com.mercuryservices.devisservice.dto.DevisResponsebyFiche;
import com.mercuryservices.devisservice.service.Impl.DevisServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/devis")
@RequiredArgsConstructor
public class DevisController {

    private final DevisServiceImpl devisServiceImpl;

    /** Add devis **/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DevisResponse> createDevis(@RequestBody DevisRequest devisRequest) {

        DevisRequest devis = new DevisRequest();
        BeanUtils.copyProperties(devisRequest, devis);
        Devis createDevis = devisServiceImpl.createDevis(devis, devisRequest.getFicheId());
        DevisResponse devisResponse = new DevisResponse();
        BeanUtils.copyProperties(createDevis, devisResponse);
        return new ResponseEntity<DevisResponse>(devisResponse, HttpStatus.OK);

    }

    /** Update devis **/
    @PutMapping(path = "/{devisId}")
    public ResponseEntity<DevisResponse> updateDevis( @RequestBody DevisRequest devisRequest, @PathVariable String devisId) {

        Devis devis = new Devis();
        BeanUtils.copyProperties(devisRequest, devis);
        Devis udpateDevis = devisServiceImpl.updateDevis(devis ,devisId);
        DevisResponse devisResponse = new DevisResponse();
        BeanUtils.copyProperties(udpateDevis, devisResponse);
        return new ResponseEntity<DevisResponse>(devisResponse, HttpStatus.OK);

    }

    /** Get devis by ID **/
    @GetMapping(path = "/{devisId}")
    public ResponseEntity<DevisResponse> getDevisByDevisId(@PathVariable String devisId) {

        DevisRequest devisReq = devisServiceImpl.findDevisByDevisId(devisId);
        DevisResponse devisResponse = new DevisResponse();
        BeanUtils.copyProperties(devisReq, devisResponse);
        return new ResponseEntity<DevisResponse>(devisResponse, HttpStatus.OK);

    }

    /** Get devis by ficheId **/
    @GetMapping(path = "/fiche/{ficheId}")
    public ResponseEntity<List<DevisResponsebyFiche>> findDevisByFicheId(@PathVariable String ficheId) {

        List<DevisRequest> devisReq = devisServiceImpl.findDevisByFicheId(ficheId);

        Type listType = new TypeToken<List<DevisResponsebyFiche>>() {
        }.getType();
        List<DevisResponsebyFiche> devisResponsebyFiche = new ModelMapper().map(devisReq, listType);
        return new ResponseEntity<List<DevisResponsebyFiche>>(devisResponsebyFiche, HttpStatus.OK);

    }

    /** Get all devis **/
     @GetMapping
     @ResponseStatus(HttpStatus.OK)
     public List<DevisResponse> getAllDevis() {
     return devisServiceImpl.getAllDevis();

     }

    /** Delete devis **/
    @DeleteMapping(path = "/{devisId}")
    public ResponseEntity<Object> deleteDevis(@PathVariable String devisId) {
        devisServiceImpl.deleteDevis(devisId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

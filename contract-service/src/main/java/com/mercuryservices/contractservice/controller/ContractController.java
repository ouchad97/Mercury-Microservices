package com.mercuryservices.contractservice.controller;

import com.mercuryservices.contractservice.dto.ContractRequest;
import com.mercuryservices.contractservice.dto.ContractResponse;
import com.mercuryservices.contractservice.dto.ContractResponsebyDevis;
import com.mercuryservices.contractservice.model.Contract;
import com.mercuryservices.contractservice.service.Impl.ContractServiceImpl;
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
@RequestMapping("/api/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractServiceImpl contractServiceImpl;

    /** Add contract **/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContractResponse> createContract(@RequestBody ContractRequest contractRequest) {

        ContractRequest contract = new ContractRequest();
        BeanUtils.copyProperties(contractRequest, contract);
        Contract createContract = contractServiceImpl.createContract(contract, contractRequest.getDevisId());
        ContractResponse contractResponse = new ContractResponse();
        BeanUtils.copyProperties(createContract, contractResponse);
        return new ResponseEntity<ContractResponse>(contractResponse, HttpStatus.OK);

    }


    /** Update contract **/
    @PutMapping(path = "/{contractId}")
    public ResponseEntity<ContractResponse> updateContract( @RequestBody ContractRequest contractRequest, @PathVariable String contractId) {

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractRequest, contract);
        Contract updateDevs = contractServiceImpl.updateContract(contract ,contractId);
        ContractResponse contractResponse = new ContractResponse();
        BeanUtils.copyProperties(updateDevs, contractResponse);
        return new ResponseEntity<ContractResponse>(contractResponse, HttpStatus.OK);

    }

    /** Get contract by ID **/
    @GetMapping(path = "/{contractId}")
    public ResponseEntity<ContractResponse> getContractByContractId(@PathVariable String contractId) {

        ContractRequest contractReq = contractServiceImpl.findContractByContractId(contractId);
        ContractResponse contractResponse = new ContractResponse();
        BeanUtils.copyProperties(contractReq, contractResponse);
        return new ResponseEntity<ContractResponse>(contractResponse, HttpStatus.OK);

    }

    /** Get contract by devisId **/
    @GetMapping(path = "/devis/{devisId}")
    public ResponseEntity<List<ContractResponsebyDevis>> findContractByDevisId(@PathVariable String devisId) {

        List<ContractRequest> contractReq = contractServiceImpl.findContractByDevisId(devisId);

        Type listType = new TypeToken<List<ContractResponsebyDevis>>() {
        }.getType();
        List<ContractResponsebyDevis> contractResponsebyDevis = new ModelMapper().map(contractReq, listType);
        return new ResponseEntity<List<ContractResponsebyDevis>>(contractResponsebyDevis, HttpStatus.OK);

    }

    /** Get all contract **/
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContractResponse> getAllContract() {
        return contractServiceImpl.getAllContract();

    }

    /** Delete contract **/
    @DeleteMapping(path = "/{contractId}")
    public ResponseEntity<Object> deleteContract(@PathVariable String contractId) {
        contractServiceImpl.deleteContract(contractId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

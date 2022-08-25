package com.mercuryservices.contractservice.service;

import com.mercuryservices.contractservice.dto.ContractRequest;
import com.mercuryservices.contractservice.model.Contract; 

import java.util.List;

public interface DevisService {

    Contract createContract(ContractRequest contractRequest, String devisId);
    ContractRequest findContractByContractId(String contractId);

    List<ContractRequest> findContractByDevisId(String devisId);

    Contract updateContract (Contract contract, String contractId);

    void deleteContract(String contractId);
}

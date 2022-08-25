package com.mercuryservices.contractservice.service.Impl;

import com.mercuryservices.contractservice.dto.ContractRequest;
import com.mercuryservices.contractservice.model.Contract;
import com.mercuryservices.contractservice.service.ContractService;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    @Override
    public Contract createContract(ContractRequest contractRequest, String devisId) {
        return null;
    }

    @Override
    public ContractRequest findContractByContractId(String contractId) {
        return null;
    }

    @Override
    public List<ContractRequest> findContractByDevisId(String devisId) {
        return null;
    }

    @Override
    public Contract updateContract(Contract contract, String contractId) {
        return null;
    }

    @Override
    public void deleteContract(String contractId) {

    }
}

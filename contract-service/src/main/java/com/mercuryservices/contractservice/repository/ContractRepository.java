package com.mercuryservices.contractservice.repository;

import com.mercuryservices.contractservice.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    Contract findByContractId(String contractId);
    List<Contract> findContractByDevisId(String devisId);

}

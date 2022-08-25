package com.mercuryservices.contractservice.service.Impl;

import com.mercuryservices.contractservice.dto.ContractRequest;
import com.mercuryservices.contractservice.dto.ContractResponse;
import com.mercuryservices.contractservice.feign.DevisRestClient;
import com.mercuryservices.contractservice.model.Contract;
import com.mercuryservices.contractservice.model.Devis;
import com.mercuryservices.contractservice.repository.ContractRepository;
import com.mercuryservices.contractservice.service.ContractService;
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
public class ContractServiceImpl implements ContractService {
    @Autowired
    DevisRestClient devisRestClient;
    @Autowired
    ContractRepository contractRepository;
    @Override
    public Contract createContract(ContractRequest contractRequest, String devisId) {

        Contract contractEntity = new Contract();
        BeanUtils.copyProperties(contractRequest, contractEntity);

        /***Devis***/
        Devis devis = devisRestClient.getDevisByDevisId(devisId);
        contractEntity.setDevisId(devis.getDevisId());

        Contract newContract = contractRepository.save(contractEntity);
        Contract contractNew = new Contract();
        BeanUtils.copyProperties(newContract, contractNew);

        return contractEntity;
    }

    @Override
    public ContractRequest findContractByContractId(String contractId) {
        Contract contractEntity = contractRepository.findByContractId(contractId);
        ContractRequest contractReq = new ContractRequest();
        BeanUtils.copyProperties(contractEntity, contractReq);

        /***Devis***/ //You can comment methode below to get just iddevis
        Devis devis = devisRestClient.getDevisByDevisId(contractReq.getDevisId());
        contractReq.setDevis(devis);
        return contractReq;
    }

    @Override
    public List<ContractRequest> findContractByDevisId(String devisId) {

        List<Contract> contractEntity = (List<Contract>)contractRepository.findContractByDevisId(devisId);
        List<ContractRequest> contractReq = new ArrayList<ContractRequest>();
        for(Contract contractlist: contractEntity) {
            ContractRequest contractDto= new ContractRequest();
            BeanUtils.copyProperties(contractlist, contractDto);
            contractReq.add(contractDto);
        }
        return contractReq;
    }


    @Override
    public Contract updateContract(Contract contract, String contractId) {
        Contract contractEntity = contractRepository.findByContractId(contractId);

        if (contractEntity == null)
            System.out.println("****** There is no contract with this id ******");

        contractEntity.setLibelleContract(contract.getLibelleContract());
        Contract contractUpdate = contractRepository.save(contractEntity);
        Contract contractnew = new Contract();
        BeanUtils.copyProperties(contractUpdate, contractnew);
        return contractnew;
    }

    @Override
    public void deleteContract(String contractId) {
        Contract contractEntity = contractRepository.findByContractId(contractId);
        if (contractEntity == null)
            System.out.println("****** There is no contract with this id ******");
        contractRepository.delete(contractEntity);
    }

    public List<ContractResponse> getAllContract(){
        List<Contract> contractList = contractRepository.findAll();
        return contractList.stream()
                .map(this::mapToContractResponse)
                .toList();
    }

    private ContractResponse mapToContractResponse(Contract contractEntity) {

        /***Devis***/ //You can comment methode below to get just iddevis
        Devis devisEnt = devisRestClient.getDevisByDevisId(contractEntity.getDevisId());
        contractEntity.setDevis(devisEnt);
        return ContractResponse.builder()
                .idContract(contractEntity.getIdContract())
                .contractId(contractEntity.getContractId())
                .datecreationContract(contractEntity.getDatecreationContract())
                .libelleContract(contractEntity.getLibelleContract())

                /***Devis***/
                //If you want get just devis ID enable this
                //.devisId(contractEntity.getDevisId())
                // Don't forget to comment List of devis below
                .devis(devisEnt)
                .build();
    }
}

package com.mercuryservices.contractservice.dto;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequest {
    private Long idContract;
    private String contractId;
    private Date datecreationContract;
    private String libelleContract;

}

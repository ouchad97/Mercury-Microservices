package com.mercuryservices.contractservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_contract")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContract;

    /**/
    private String contractId;
    private Date datecreationContract;
    private String libelleContract;

    /***Devis***/
    @Transient
    private Devis devis;
    private String devisId;

}

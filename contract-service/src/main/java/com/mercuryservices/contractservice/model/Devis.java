package com.mercuryservices.contractservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Devis {
    private Long idDevis;

    /**/
    private String devisId;
    private Date datecreationDevis;
    private String libelleDevis;

    /***Fiche***/
    private Fiche Fiche;

}

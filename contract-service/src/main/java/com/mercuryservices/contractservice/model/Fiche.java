package com.mercuryservices.contractservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Fiche {
    private Long idFiche;

    /**/
    private String ficheId;
    private Date datecreationFiche;
    private String libelleFiche;
}

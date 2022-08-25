package com.mercuryservices.devisservice.dto;

import com.mercuryservices.devisservice.model.Fiche;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevisRequest {
    private Long idDevis;
    private String devisId;
    private Date datecreationDevis;
    private String libelleDevis;

    /***Fiche***/
    private Fiche fiche;
    private String ficheId;
}

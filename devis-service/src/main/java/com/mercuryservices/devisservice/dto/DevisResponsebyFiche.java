package com.mercuryservices.devisservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**This classe created to get devis by fiche and remove fiche from response**/
public class DevisResponsebyFiche {

    private Long idDevis;
    private String devisId;
    private Date datecreationDevis;
    private String libelleDevis;


}

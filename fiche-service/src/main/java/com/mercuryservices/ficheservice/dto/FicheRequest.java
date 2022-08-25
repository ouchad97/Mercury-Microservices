package com.mercuryservices.ficheservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FicheRequest {
    private Long idFiche;
    private String ficheId;
    private Date datecreationFiche;
    private String libelleFiche;
}

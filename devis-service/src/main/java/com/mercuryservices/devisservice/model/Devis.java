package com.mercuryservices.devisservice.model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_devis")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevis;

    /**/
    private String devisId;
    private Date datecreationDevis;
    private String libelleDevis;

    /***Fiche***/
    @Transient
    private Fiche fiche;
    private String ficheId;
}

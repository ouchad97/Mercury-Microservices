package com.mercuryservices.ficheservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_fiche")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Fiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiche;

    /**/
    private String ficheId;
    private Date datecreationFiche;
    private String libelleFiche;
}

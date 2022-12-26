package me.arrhioui.dto;


import lombok.*;
import me.arrhioui.enums.ProduitState;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProduitDTO {

        private String id;
        private String name;
        private int quantite;
        @Enumerated(EnumType.STRING)
        private ProduitState produitState;

        @ManyToOne
        private CategorieDTO categorie;
}

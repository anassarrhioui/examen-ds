package me.arrhioui.dto;

import javax.persistence.ManyToOne;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LigneCommandDTO {
    private String id;
    private int quantite;
    private float remise;
    private ProduitDTO produit;
}

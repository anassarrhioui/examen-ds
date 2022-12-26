package me.arrhioui.ordercommandservice.member;

import me.arrhioui.dto.ProduitDTO;
import org.axonframework.modelling.command.EntityId;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LigneCommandMember {
    @EntityId
    private String id;
    private int quantite;
    private float remise;
    private ProduitDTO produit = new ProduitDTO();
}

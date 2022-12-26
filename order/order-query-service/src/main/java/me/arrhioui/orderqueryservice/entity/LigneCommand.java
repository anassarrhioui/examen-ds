package me.arrhioui.orderqueryservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class LigneCommand {
    @Id
    private String id;
    private int quantite;
    private float remise;

    @ManyToOne
    private Produit produit;

}

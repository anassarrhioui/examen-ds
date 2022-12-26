package me.arrhioui.produitqueryservice.entity;

import lombok.*;
import me.arrhioui.enums.ProduitState;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Produit {

    @Id
    private String id;
    private String name;
    private int quantite;
    @Enumerated(EnumType.STRING)
    private ProduitState produitState;

    @ManyToOne
    private Categorie categorie;
}

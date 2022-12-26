package me.arrhioui.produitqueryservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Categorie {

    @Id
    private String id;
    private String name;
    private String description;
}

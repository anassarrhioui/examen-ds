package me.arrhioui.produitcommandservice.members;

import lombok.*;
import org.axonframework.modelling.command.EntityId;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategorieMembre {
    @EntityId
    private String id;
    private String name;
    private String description;
}

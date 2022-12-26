package me.arrhioui.event;

import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProduitCreatedEvent {
    private ProduitDTO produitDTO;
}

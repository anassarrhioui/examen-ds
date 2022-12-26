package me.arrhioui.command;


import lombok.*;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewProduitCommand {
    private ProduitDTO produitDTO;
}

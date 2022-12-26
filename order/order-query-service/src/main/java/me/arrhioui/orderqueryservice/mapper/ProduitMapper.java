package me.arrhioui.orderqueryservice.mapper;

import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.orderqueryservice.entity.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit from(ProduitDTO produitDTO);
    ProduitDTO from(Produit client);
}

package me.arrhioui.produitqueryservice.mapper;

import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.produitqueryservice.entity.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit from(ProduitDTO produitDTO);
    ProduitDTO from(Produit client);
}

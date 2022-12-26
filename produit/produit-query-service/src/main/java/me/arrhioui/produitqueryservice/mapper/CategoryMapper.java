package me.arrhioui.produitqueryservice.mapper;

import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.produitqueryservice.entity.Categorie;
import me.arrhioui.produitqueryservice.entity.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Categorie from(CategorieDTO categorieDTO);
    CategorieDTO from(Categorie categorie);
}

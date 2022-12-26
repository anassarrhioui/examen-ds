package me.arrhioui.produitqueryservice.query;

import lombok.AllArgsConstructor;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.produitqueryservice.mapper.CategoryMapper;
import me.arrhioui.produitqueryservice.mapper.ProduitMapper;
import me.arrhioui.produitqueryservice.repository.CategorieRepository;
import me.arrhioui.produitqueryservice.repository.ProduitRepository;
import me.arrhioui.query.GetAllCategoriesQuery;
import me.arrhioui.query.GetAllProduitsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitQueryHandler {

    private ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;
    private ProduitMapper produitMapper;
    private CategoryMapper categoryMapper;

    @QueryHandler
    public List<ProduitDTO> getAllProduitsQH(GetAllProduitsQuery query){
        return produitRepository
                .findAll()
                .stream()
                .map(produit -> produitMapper.from(produit))
                .collect(Collectors.toList());
    }

    @QueryHandler
    public List<CategorieDTO> getAllCategoriesQH(GetAllCategoriesQuery query){
        return categorieRepository
                .findAll()
                .stream()
                .map(categorie -> categoryMapper.from(categorie))
                .collect(Collectors.toList());
    }

}

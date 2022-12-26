package me.arrhioui.produitqueryservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.query.GetAllCategoriesQuery;
import me.arrhioui.query.GetAllClientQuery;
import me.arrhioui.query.GetAllProduitsQuery;
import me.arrhioui.query.GetClientByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/produits/query")
@AllArgsConstructor
public class ProduitController {

    private QueryGateway queryGateway;

    @GetMapping("/all/Produits")
    public CompletableFuture<List<ProduitDTO>> getAllProduits(){
        return queryGateway.query(new GetAllProduitsQuery(), ResponseTypes.multipleInstancesOf(ProduitDTO.class));
    }

    @GetMapping("/all/Categoris")
    public CompletableFuture<List<CategorieDTO>> getAllCategories(){
        return queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(CategorieDTO.class));
    }

}

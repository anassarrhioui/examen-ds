package me.arrhioui.produitqueryservice.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.event.CategorieCreatedEvent;
import me.arrhioui.event.ProduitCreatedEvent;
import me.arrhioui.produitqueryservice.entity.Categorie;
import me.arrhioui.produitqueryservice.entity.Produit;
import me.arrhioui.produitqueryservice.repository.CategorieRepository;
import me.arrhioui.produitqueryservice.repository.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitEventHandler {
    private ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;

    @EventHandler
    public void on(CategorieCreatedEvent event){

        log.info("CategorieCreatedEvent");
        CategorieDTO categorieDTO = event.getCategorieDTO();

        Categorie categorie = Categorie
                .builder()
                .id(categorieDTO.getId())
                .name(categorieDTO.getName())
                .description(categorieDTO.getDescription())
                .build();

        categorieRepository.save(categorie);
    }

    @EventHandler
    public void on(ProduitCreatedEvent event){

        log.info("ProduitCreatedEvent");
        ProduitDTO produitDTO = event.getProduitDTO();

        Categorie categorie = categorieRepository.findById(produitDTO.getCategorie().getId()).get();

        Produit produit = Produit
                .builder()
                .id(produitDTO.getId())
                .name(produitDTO.getName())
                .quantite(produitDTO.getQuantite())
                .produitState(produitDTO.getProduitState())
                .id(produitDTO.getId())
                .categorie(categorie)
                .build();

        produitRepository.save(produit);
    }
}

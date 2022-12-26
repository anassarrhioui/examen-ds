package me.arrhioui.orderqueryservice.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.event.CategorieCreatedEvent;
import me.arrhioui.event.ProduitCreatedEvent;
import me.arrhioui.orderqueryservice.entity.Produit;
import me.arrhioui.orderqueryservice.repository.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitEventHandler {
    private ProduitRepository produitRepository;

    @EventHandler
    public void on(ProduitCreatedEvent event){

        log.info("ProduitCreatedEvent Order Query");
        ProduitDTO produitDTO = event.getProduitDTO();


        Produit produit = Produit
                .builder()
                .id(produitDTO.getId())
                .name(produitDTO.getName())
                .quantite(produitDTO.getQuantite())
                .produitState(produitDTO.getProduitState())
                .id(produitDTO.getId())
                .build();

        produitRepository.save(produit);
    }
}

package me.arrhioui.orderqueryservice.service;

import lombok.AllArgsConstructor;
import me.arrhioui.dto.CommandDTO;
import me.arrhioui.dto.LigneCommandDTO;
import me.arrhioui.event.CommandCreatedEvent;
import me.arrhioui.orderqueryservice.entity.Commande;
import me.arrhioui.orderqueryservice.entity.LigneCommand;
import me.arrhioui.orderqueryservice.mapper.ClientMapper;
import me.arrhioui.orderqueryservice.repository.ClientRepository;
import me.arrhioui.orderqueryservice.repository.CommandeRepository;
import me.arrhioui.orderqueryservice.repository.LigneCommandeRepository;
import me.arrhioui.orderqueryservice.repository.ProduitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommandEventHandler {
    private ClientRepository clientRepository;
    private ProduitRepository produitRepository;
    private CommandeRepository commandeRepository;
    private LigneCommandeRepository ligneCommandeRepository;

    @EventHandler
    public void on(CommandCreatedEvent event) {
        CommandDTO commandDTO = event.getCommandDTO();
        List<LigneCommand> ligneCommands = new ArrayList<>();

        commandDTO.getLigneCommands().forEach(ligneCommandDTO -> {
                    LigneCommand ligneCommand = LigneCommand
                            .builder()
                            .id(UUID.randomUUID().toString())
                            .remise(ligneCommandDTO.getRemise())
                            .quantite(ligneCommandDTO.getQuantite())
                            .produit(produitRepository.findById(ligneCommandDTO.getProduit().getId()).get())
                            .build();

                    ligneCommands.add(ligneCommandeRepository.saveAndFlush(ligneCommand));
                }
        );

        Commande commande = Commande
                .builder()
                .id(commandDTO.getId())
                .ligneCommands(ligneCommands)
                .client(clientRepository.findById(commandDTO.getClient().getId()).get())
                .dateCommande(commandDTO.getDateCommande())
                .dateLivraison(commandDTO.getDateLivraison())
                .build();

        commandeRepository.save(commande);
    }
}

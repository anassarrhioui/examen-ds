package me.arrhioui.produitcommandservice.aggregate;

import me.arrhioui.command.CreateNewCategorieCommand;
import me.arrhioui.command.CreateNewProduitCommand;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ProduitDTO;
import me.arrhioui.enums.ProduitState;
import me.arrhioui.event.CategorieCreatedEvent;
import me.arrhioui.event.ProduitCreatedEvent;
import me.arrhioui.produitcommandservice.members.CategorieMembre;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Aggregate
public class ProduitAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private int quantite;
    private ProduitState produitState;

    @AggregateMember
    private CategorieMembre categorieMembre;

    public ProduitAggregate() {
    }

    @CommandHandler
    public ProduitAggregate(CreateNewProduitCommand command) {
        command.getProduitDTO().setId(
                UUID.randomUUID().toString()
        );
        AggregateLifecycle.apply(
                new ProduitCreatedEvent(command.getProduitDTO())
        );
    }


    @EventSourcingHandler
    public void on(ProduitCreatedEvent event){
        ProduitDTO produitDTO = event.getProduitDTO();
        this.id = produitDTO.getId();
        this.name = produitDTO.getName();
        this.quantite = produitDTO.getQuantite();
        this.produitState = produitDTO.getProduitState();
        this.categorieMembre = CategorieMembre
                .builder()
                .id(produitDTO.getCategorie().getId())
                .name(produitDTO.getCategorie().getName())
                .description(produitDTO.getCategorie().getDescription())
                .build();
    }
}

package me.arrhioui.produitcommandservice.aggregate;

import me.arrhioui.command.CreateNewCategorieCommand;
import me.arrhioui.command.CreateNewClientCommand;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.event.CategorieCreatedEvent;
import me.arrhioui.event.ClientCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class CategorieAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String description;

    public CategorieAggregate() {
    }

    @CommandHandler
    public CategorieAggregate(CreateNewCategorieCommand command) {
        command.getCategorieDTO().setId(
                UUID.randomUUID().toString()
        );
        AggregateLifecycle.apply(
                new CategorieCreatedEvent(command.getCategorieDTO())
        );
    }


    @EventSourcingHandler
    public void on(CategorieCreatedEvent event){
        CategorieDTO categorieDTO = event.getCategorieDTO();
        this.id = categorieDTO.getId();
        this.name = categorieDTO.getName();
        this.description = categorieDTO.getDescription();
    }
}

package me.arrhioui.ordercommandservice.aggregate;

import me.arrhioui.command.CreateNewCommandeCommand;
import me.arrhioui.dto.CommandDTO;
import me.arrhioui.enums.CommandsState;
import me.arrhioui.event.CommandCreatedEvent;
import me.arrhioui.ordercommandservice.member.ClientMember;
import me.arrhioui.ordercommandservice.member.LigneCommandMember;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Aggregate
public class CommandeAggregate {
    @AggregateIdentifier
    private String id;
    private Instant dateCommande;
    private Instant dateLivraison;

    private CommandsState commandsState;

    @AggregateMember
    private ClientMember client = new ClientMember();

    @AggregateMember
    private List<LigneCommandMember> ligneCommands = new ArrayList<>();
    private List<LigneCommandMember> ligneCommandsTmp = new ArrayList<>();

    public CommandeAggregate() {
    }

    @CommandHandler
    public CommandeAggregate(CreateNewCommandeCommand command) {
        command.getCommandDTO().setId(UUID.randomUUID().toString());
        CommandDTO commandDTO = command.getCommandDTO();

        commandDTO.getLigneCommands().forEach(ligneCommandDTO -> {
            String clId = UUID.randomUUID().toString();
            ligneCommandDTO.setId(clId);
            ligneCommandsTmp.add(
                    LigneCommandMember
                            .builder()
                            .id(clId)
                            .remise((float) Math.random())
                            .produit(ligneCommandDTO.getProduit())
                            .quantite(ligneCommandDTO.getQuantite())
                            .build()
            );
        });
        AggregateLifecycle.apply(new CommandCreatedEvent(command.getCommandDTO()));
    }

    @EventSourcingHandler
    public void on(CommandCreatedEvent event) {
        CommandDTO commandDTO = event.getCommandDTO();
        commandDTO.getLigneCommands().forEach(c -> System.out.println("5555555555555555555"+c.getId()));
        this.id = commandDTO.getId();
        this.dateCommande = commandDTO.getDateCommande();
        this.dateLivraison = commandDTO.getDateLivraison();
        this.commandsState = commandDTO.getCommandsState();
        this.client.setId(commandDTO.getClient().getId());
        this.ligneCommands = ligneCommandsTmp;

    }
}

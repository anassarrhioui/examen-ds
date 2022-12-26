package me.arrhioui.clientcommandservice.aggregate;

import me.arrhioui.command.CreateNewClientCommand;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.event.ClientCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class ClientAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;

    public ClientAggregate() {
    }

    @CommandHandler
    public ClientAggregate(CreateNewClientCommand command) {
        command.getClientDTO().setId(
                UUID.randomUUID().toString()
        );
        AggregateLifecycle.apply(
                new ClientCreatedEvent(command.getClientDTO())
        );
    }


    @EventSourcingHandler
    public void on(ClientCreatedEvent event){
        ClientDTO clientDTO = event.getClientDTO();
        this.id = clientDTO.getId();
        this.name = clientDTO.getName();
        this.address = clientDTO.getAddress();
        this.phone = clientDTO.getPhone();
        this.email = clientDTO.getEmail();
    }
}

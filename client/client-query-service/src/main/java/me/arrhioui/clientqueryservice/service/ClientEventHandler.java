package me.arrhioui.clientqueryservice.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.arrhioui.clientqueryservice.entity.Client;
import me.arrhioui.clientqueryservice.repository.ClientRepository;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.event.ClientCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientEventHandler {
    private ClientRepository clientRepository;

    @EventHandler
    public void on(ClientCreatedEvent event){

        log.info("Event Handler Client Query, ClientCreatedEvent");
        ClientDTO clientDTO = event.getClientDTO();

        Client client = Client
                .builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .address(clientDTO.getAddress())
                .phone(clientDTO.getPhone())
                .build();

        clientRepository.save(client);
    }
}

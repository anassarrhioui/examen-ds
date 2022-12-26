package me.arrhioui.clientcommandservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.command.CreateNewClientCommand;
import me.arrhioui.dto.ClientDTO;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/clients/commands")
@AllArgsConstructor
public class ClientController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createNewClient(@RequestBody ClientDTO clientDTO){
        return commandGateway.send(new CreateNewClientCommand(clientDTO));
    }

}

package me.arrhioui.ordercommandservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.command.CreateNewCommandeCommand;
import me.arrhioui.dto.CommandDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders/command")
@AllArgsConstructor
public class CommandeController {
    private CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createNewCommand(@RequestBody CommandDTO commandDTO){
        return commandGateway.send(new CreateNewCommandeCommand(commandDTO));
    }
}

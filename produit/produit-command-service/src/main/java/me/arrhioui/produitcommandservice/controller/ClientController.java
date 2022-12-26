package me.arrhioui.produitcommandservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.command.CreateNewCategorieCommand;
import me.arrhioui.command.CreateNewClientCommand;
import me.arrhioui.command.CreateNewProduitCommand;
import me.arrhioui.dto.CategorieDTO;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.dto.ProduitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/produits/commands")
@AllArgsConstructor
public class ClientController {
    private CommandGateway commandGateway;

    @PostMapping("/createCategrie")
    public CompletableFuture<String> createNewCategorie(@RequestBody CategorieDTO categorieDTO){
        return commandGateway.send(new CreateNewCategorieCommand(categorieDTO));
    }

    @PostMapping("/createProduit")
    public CompletableFuture<String> createNewProduit(@RequestBody ProduitDTO produitDTO){
        return commandGateway.send(new CreateNewProduitCommand(produitDTO));
    }

}

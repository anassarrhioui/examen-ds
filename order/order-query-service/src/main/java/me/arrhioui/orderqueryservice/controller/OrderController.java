package me.arrhioui.orderqueryservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.event.GetAllOrdersQuery;
import me.arrhioui.orderqueryservice.entity.Commande;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController()
@RequestMapping("orders/query")
@AllArgsConstructor
public class OrderController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Commande>> getAllCommandes(){
        return queryGateway.query(new GetAllOrdersQuery(), ResponseTypes.multipleInstancesOf(Commande.class));
    }
}

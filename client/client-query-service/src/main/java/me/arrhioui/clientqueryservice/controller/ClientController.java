package me.arrhioui.clientqueryservice.controller;

import lombok.AllArgsConstructor;
import me.arrhioui.clientqueryservice.config.ConsulConfig;
import me.arrhioui.dto.ClientDTO;
import me.arrhioui.query.GetAllClientQuery;
import me.arrhioui.query.GetClientByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/clients/query")
@AllArgsConstructor
public class ClientController {

    private QueryGateway queryGateway;
    private ConsulConfig config;

    @GetMapping("/config")
    public Map<String, String> getConfig(){
        return Map.of("p1", String.valueOf(config.getParameter1()), "p2", String.valueOf(config.getParameter2()));
    }

    @GetMapping("/all")
    public CompletableFuture<List<ClientDTO>> getAllClients(){
        return queryGateway.query(new GetAllClientQuery(), ResponseTypes.multipleInstancesOf(ClientDTO.class));
    }


    @GetMapping("/client/{id}")
    public CompletableFuture<ClientDTO> getClientById(@PathVariable String id){
        return queryGateway.query(new GetClientByIdQuery(id), ResponseTypes.instanceOf(ClientDTO.class));
    }
}
